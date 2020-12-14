package com.rudolfs.rxjava.migration.nulls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleOrDefaultTest {

    private SingleOrDefault singleOrDefault;

    @BeforeEach
    void beforeEach() {
        this.singleOrDefault = new SingleOrDefault();
    }

    @Test
    void rxJava1SingleOrDefault() {
        singleOrDefault.rxJava1SingleOrDefault();
    }

    @Test
    void rxJava1DefaultIfEmptyAndSingle() {
        singleOrDefault.rxJava1DefaultIfEmptyAndSingle();
    }

    @Test
    void rxJava2SingleWithNull() {
        assertThrows(NullPointerException.class, () -> {
            singleOrDefault.rxJava2SingleWithNull();
        });
    }

    @Test
    void rxJava2MaybeDefaultIfEmpty() {
        singleOrDefault.rxJava2MaybeDefaultIfEmpty();
    }
}
