package com.rudolfs.rxjava.migration.nulls;

import rx.Observable;

public class SingleOrDefault {

    void rxJava1SingleOrDefault() {
        rx.Observable.empty()
                .singleOrDefault(null)
                .subscribe(customResponse -> System.out.println("onNext: " + customResponse)
                        , throwable -> System.out.println("onError: " + throwable.getMessage())
                        , () -> System.out.println("onCompleted"));
    }

    void rxJava1DefaultIfEmptyAndSingle() {
        Observable.empty()
                .defaultIfEmpty(null)
                .single()
                .subscribe(customResponse -> System.out.println("onNext: " + customResponse)
                        , throwable -> System.out.println("onError: " + throwable.getMessage())
                        , () -> System.out.println("onCompleted"));
    }

    void rxJava2SingleWithNull() {
        io.reactivex.Observable.empty()
                .single(null)
                .subscribe(customResponse -> System.out.println("onNext: " + customResponse)
                        , throwable -> System.out.println("onError: " + throwable.getMessage()));
    }

    void rxJava2MaybeDefaultIfEmpty() {

        io.reactivex.Maybe.empty()
                .toSingle("success")
                .subscribe(customResponse -> System.out.println("onNext: " + customResponse)
                        , throwable -> System.out.println("onError: " + throwable.getMessage()));

    }
}
