package com.rudolfs.rxjava.migration.interop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RxJavaInteropExamplesTest {

    private RxJavaInteropExamples examples;

    @BeforeEach
    void beforeEach() {
        this.examples = new RxJavaInteropExamples();
    }

    @Test
    void observableListToSingle() {
        examples.rxJava1ObservableToRxJava2Single()
                .test()
                .assertValue(List.of("soccer", "tennis", "padel"))
                .assertComplete();
    }

    @Test
    void completableToObservableVoid() {
        examples.rxJava2CompletableToRxJava1ObservableVoid()
                .test()
                .assertValue(null)
                .assertCompleted();
    }
}
