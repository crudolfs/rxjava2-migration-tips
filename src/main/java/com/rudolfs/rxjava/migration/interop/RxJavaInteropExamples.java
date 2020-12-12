package com.rudolfs.rxjava.migration.interop;

import hu.akarnokd.rxjava.interop.RxJavaInterop;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Single;
import rx.Observable;

import java.util.List;

public class RxJavaInteropExamples {

    Single<List<String>> rxJava1ObservableToRxJava2Single() {
        Observable<List<String>> sportsObservable = Observable.just("soccer", "tennis", "padel").toList();

        // alternative way to convert to io.reactivex.Single
        // Single.fromObservable(RxJavaInterop.toV2Observable(sportsObservable));
        return RxJavaInterop.toV2Single(sportsObservable.toSingle());
    }

    Observable<Void> rxJava2CompletableToRxJava1ObservableVoid() {
        return RxJavaInterop.toV1Observable(doSomethingAndComplete().toSingle(() -> "").toObservable(), BackpressureStrategy.ERROR)
                .map(s -> null);
    }

    private Completable doSomethingAndComplete() {
        return Completable.create(emitter -> {
            System.out.println("doSomething");
            emitter.onComplete();
        });
    }
}
