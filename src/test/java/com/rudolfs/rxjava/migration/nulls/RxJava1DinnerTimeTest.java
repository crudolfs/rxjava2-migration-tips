package com.rudolfs.rxjava.migration.nulls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RxJava1DinnerTimeTest {

    private RxJava1DinnerTime rxJava1DinnerTime;

    @BeforeEach
    void beforeEach() {
        this.rxJava1DinnerTime = new RxJava1DinnerTime();
    }

    @Test
    void testDinnerTime() {
        rxJava1DinnerTime.dinnerTime()
                .test()
                .assertCompleted();
    }

    @Test
    void testGoodMoodNullEvent() {
        rxJava1DinnerTime.dinnerTimeByMood("good")
                .test()
                .assertCompleted();
    }

    @Test
    void testBadMoodNullEvent() {
        rxJava1DinnerTime.dinnerTimeByMood("bad")
                .test()
                .assertCompleted();
    }

    @Test
    void testGoodMoodEmptyEvent() {
        rxJava1DinnerTime.dinnerTimeByMoodEmptyEvent("good")
                .test()
                .assertCompleted();
    }

    @Test
    void testBadMoodEmptyEvent() {
        rxJava1DinnerTime.dinnerTimeByMoodEmptyEvent("bad")
                .test()
                .assertCompleted();
    }
}
