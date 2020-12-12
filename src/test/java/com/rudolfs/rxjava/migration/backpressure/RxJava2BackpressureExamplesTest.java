package com.rudolfs.rxjava.migration.backpressure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RxJava2BackpressureExamplesTest {

    private RxJava2BackpressureExamples examples;

    @BeforeEach
    void beforeEach() {
        this.examples = new RxJava2BackpressureExamples();
    }

    @Test
    void testObservableHasNoBackpressure() {
        examples.noBackpressure();

        RxJava2BackpressureExamples.sleep(5000);
    }

    @Test
    void testFlowableHasBackpressure() {
        examples.backpressure();

        RxJava2BackpressureExamples.sleep(5000);
    }

}
