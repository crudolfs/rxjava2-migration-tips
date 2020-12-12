package com.rudolfs.rxjava.migration.backpressure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Enable to run backpressure example")
class RxJava1BackpressureExamplesTest {

    private RxJava1BackpressureExamples examples;

    @BeforeEach
    void beforeEach() {
        this.examples = new RxJava1BackpressureExamples();
    }

    /**
     * Just for demo purposes, not a production worthy test
     */
    @Test
    void testBackpressure() {
        examples.backpressure1();

        RxJava1BackpressureExamples.sleep(5000);
    }
}
