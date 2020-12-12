package com.rudolfs.rxjava.migration.backpressure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Enable to run backpressure example")
class RxJava2BackpressureExamplesTest {

    private RxJava2BackpressureExamples examples;

    @BeforeEach
    void beforeEach() {
        this.examples = new RxJava2BackpressureExamples();
    }

    /**
     * Just for demo purposes, not a production worthy test
     */
    @Test
    void testObservableHasNoBackpressure() {
        examples.noBackpressure();

        RxJava2BackpressureExamples.sleep(5000);
    }

    /**
     * Just for demo purposes, not a production worthy test
     */
    @Test
    void testFlowableHasBackpressure() {
        examples.backpressure();

        RxJava2BackpressureExamples.sleep(5000);
    }

}
