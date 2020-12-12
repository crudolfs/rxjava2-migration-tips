package com.rudolfs.rxjava.migration.functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FunctionalInterfaceChangesTest {
    private FunctionalInterfaceChanges sut;

    @BeforeEach
    void beforeEach() {
        sut = new FunctionalInterfaceChanges();
    }

    @Test
    void rxJava1Func1() {
        sut.rxJava1Func1();
    }

    @Test
    void rxJava1Func1Extracted() {
        sut.rxJava1Func1Extracted();
    }

    @Test
    void rxJava2Function() {
        sut.rxJava2Function();
    }

    @Test
    void rxJava2FunctionExtracted() {
        sut.rxJava2FunctionExtracted();
    }
}
