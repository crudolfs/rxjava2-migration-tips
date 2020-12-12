package com.rudolfs.rxjava.migration.nulls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RxJava2DinnerTimeTest {

    private RxJava2DinnerTime rxJava2DinnerTime;

    @BeforeEach
    void beforeEach() {
        this.rxJava2DinnerTime = new RxJava2DinnerTime();
    }

    @Test
    void testDinnerTime() {
        rxJava2DinnerTime.dinnerTime()
                .test()
                .assertComplete();
    }

    @Test
    void testGoodMood() {
        rxJava2DinnerTime.dinnerTimeByMood("good")
                .test()
                .assertComplete();
    }

    @Test
    void testBadMood() {
        rxJava2DinnerTime.dinnerTimeByMood("bad")
                .test()
                .assertComplete();
    }
}
