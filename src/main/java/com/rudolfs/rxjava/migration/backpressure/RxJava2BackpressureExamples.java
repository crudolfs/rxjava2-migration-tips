package com.rudolfs.rxjava.migration.backpressure;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class RxJava2BackpressureExamples {

    void noBackpressure() {
        Observable.interval(1, MILLISECONDS)
                .doOnNext(number -> System.out.println("i: " + number))
                .observeOn(Schedulers.computation())
                .subscribe(number -> sleep(1000));
    }

    void backpressure() {
        Flowable.interval(1, MILLISECONDS)
                .doOnNext(number -> System.out.println("i: " + number))
                .observeOn(Schedulers.computation())
                .subscribe(number -> sleep(1000));
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
