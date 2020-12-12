package com.rudolfs.rxjava.migration.functions;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.functions.Func1;

@Slf4j
public class FunctionalInterfaceChanges {

    void rxJava1Func1() {
        Observable.just("car")
                // uses Func1
                .map(String::toUpperCase)
                .subscribe(log::info);
    }

    void rxJava1Func1Extracted() {
        Func1<String, String> mapFunction = String::toUpperCase;

        Observable.just("car")
                .map(mapFunction)
                .subscribe(log::info);
    }

    void rxJava2Function() {
        io.reactivex.Observable.just("car")
                .map(String::toUpperCase)
                .subscribe(log::info);
    }

    void rxJava2FunctionExtracted() {
        io.reactivex.functions.Function<String, String> rxFunction = String::toUpperCase;

        io.reactivex.Observable.just("car")
                .map(rxFunction)
                .subscribe(log::info);
    }
}
