package com.rudolfs.rxjava.migration.backpressure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RxJava1BackpressureExamplesTest {

    private RxJava1BackpressureExamples examples;

    @BeforeEach
    void beforeEach() {
        this.examples = new RxJava1BackpressureExamples();
    }

    @Test
    void testBackpressure() {
        examples.backpressure1();

        RxJava1BackpressureExamples.sleep(5000);
    }
}
