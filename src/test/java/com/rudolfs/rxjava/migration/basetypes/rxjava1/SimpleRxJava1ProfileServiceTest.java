package com.rudolfs.rxjava.migration.basetypes.rxjava1;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleRxJava1ProfileServiceTest {

    private RxJava1ProfileService rxJava1ProfileService;

    @BeforeEach
    void beforeEach() {
        this.rxJava1ProfileService = new SimpleRxJava1ProfileService(new RxJava1StubProfileRepository());
    }

    @Test
    void testInsertAndFind() {
        final Profile profile = new Profile("id-01", "rxjava1");

        rxJava1ProfileService.insert(profile)
                .test()
                .assertValue(null)
                .assertCompleted();

        rxJava1ProfileService.findById(profile.getId())
                .test()
                .assertValue(profile)
                .assertCompleted();
    }
}
