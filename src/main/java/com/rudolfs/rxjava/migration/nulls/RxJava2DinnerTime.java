package com.rudolfs.rxjava.migration.nulls;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class RxJava2DinnerTime {

    Completable dinnerTime() {
        return cookMeal()
                .andThen(setTheTable())
                .andThen(eat())
                .andThen(clearTheTable());
    }

    Completable dinnerTimeByMood(String mood) {
        return cookMealByMood(mood)
                //.defaultIfEmpty("no meal")
                .flatMapCompletable(x -> setTheTable())
                .andThen(eat())
                .andThen(clearTheTable());
    }

    private Maybe<String> cookMealByMood(String mood) {
        return Maybe.fromCallable(() -> mood.equals("good") ? "lasagne" : null);
    }

    private Maybe<String> cookMealByMoodAlternative(String mood) {
        return Maybe.fromCallable(() -> mood)
                .filter(moodToFilter -> "good".equals(mood))
                .map(filteredMood -> "lasagne");
    }

    private Completable cookMeal() {
        return Completable.complete();
    }

    private Completable setTheTable() {
        return Completable.defer(() -> {
            System.out.println("setTheTable");
            return Completable.complete();
        });
    }

    private Completable eat() {
        return Completable.defer(() -> {
            System.out.println("eat");
            return Completable.complete();
        });
    }

    private Completable clearTheTable() {
        return Completable.defer(() -> {
            System.out.println("clearTheTable");
            return Completable.complete();
        });
    }
}
