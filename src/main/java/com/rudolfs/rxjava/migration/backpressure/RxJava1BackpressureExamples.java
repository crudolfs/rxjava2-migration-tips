package com.rudolfs.rxjava.migration.backpressure;

import rx.Observable;
import rx.schedulers.Schedulers;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class RxJava1BackpressureExamples {

    void backpressure1() {
        Observable.interval(5, MILLISECONDS)
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
