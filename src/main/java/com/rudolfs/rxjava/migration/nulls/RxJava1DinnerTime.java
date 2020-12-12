package com.rudolfs.rxjava.migration.nulls;

import rx.Observable;

public class RxJava1DinnerTime {

    Observable<Void> dinnerTime() {
        return cookMeal()
                .flatMap(x -> setTheTable())
                .flatMap(x -> eat())
                .flatMap(x -> clearTheTable())
                .map(x -> null);
    }

    Observable<Void> dinnerTimeByMood(String mood) {
        return cookMealByMood(mood)
                .flatMap(x -> setTheTable())
                .flatMap(x -> eat())
                .flatMap(x -> clearTheTable())
                .map(x -> null);
    }

    Observable<Void> dinnerTimeByMoodEmptyEvent(String mood) {
        return cookMealByMoodWithEmpty(mood)
                .defaultIfEmpty("defaultFood")
                .flatMap(x -> setTheTable())
                .flatMap(x -> eat())
                .flatMap(x -> clearTheTable())
                .map(x -> null);
    }

    private Observable<Void> cookMeal() {
        return Observable.just(null);
    }

    private Observable<String> cookMealByMood(String mood) {
        return Observable.fromCallable(() -> mood.equals("good") ? "lasagne" : null);
    }

    private Observable<String> cookMealByMoodWithEmpty(String mood) {
        return Observable.defer(() -> mood.equals("good") ? Observable.just("lasagne") : Observable.empty());
    }

    private Observable<String> cookMealByMoodAlternative(String mood) {
        return Observable.fromCallable(() -> mood)
                .filter(moodToFilter -> "good".equals(mood))
                .map(filteredMood -> "lasagne");
    }

    private Observable<Void> setTheTable() {
        return Observable.fromCallable(() -> {
            System.out.println("setTheTable");
            return "setTheTable";
        }).map(x -> null);
    }

    private Observable<Void> eat() {
        return Observable.fromCallable(() -> {
            System.out.println("eat");
            return "eat";
        }).map(x -> null);
    }

    private Observable<Void> clearTheTable() {
        return Observable.fromCallable(() -> {
            System.out.println("clearTheTable");
            return "clearTheTable";
        }).map(x -> null);
    }
}
