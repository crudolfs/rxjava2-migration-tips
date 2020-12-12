package com.rudolfs.rxjava.migration.basetypes.rxjava2;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleRxJava2ProfileServiceTest {

    private RxJava2ProfileService rxJava2ProfileService;

    @BeforeEach
    void beforeEach() {
        this.rxJava2ProfileService = new SimpleRxJava2ProfileService(new RxJava2StubProfileRepository());
    }

    @Test
    void testInsertAndFind() {
        final Profile profile = new Profile("id-01", "rxjava2");

        rxJava2ProfileService.insert(profile)
                .test()
                .assertComplete();

        rxJava2ProfileService.findById(profile.getId())
                .test()
                .assertValue(profile);
    }

    @Test
    void testInsertRxJava1Way() {
        SimpleRxJava2ProfileService simpleRxJava2ProfileService = (SimpleRxJava2ProfileService) rxJava2ProfileService;
        simpleRxJava2ProfileService.insertRxJava1Way(new Profile("id-01", "rxjava2"))
                .test()
                .assertError(NullPointerException.class);
    }
}
