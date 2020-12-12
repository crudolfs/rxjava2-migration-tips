package com.rudolfs.rxjava.migration.basetypes.rxjava1;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import rx.Observable;

public class SimpleRxJava1ProfileService implements RxJava1ProfileService {

    private final RxJava1StubProfileRepository repository;

    public SimpleRxJava1ProfileService(RxJava1StubProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Profile> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Observable<Profile> findByName(String name) {
        return null;
    }

    @Override
    public Observable<Profile> findAll() {
        return null;
    }

    @Override
    public Observable<Void> insert(Profile profile) {
        return repository.insert(profile)
                .map(success -> null);
    }

    @Override
    public Observable<Void> upsert(Profile profile) {
        return null;
    }

    @Override
    public Observable<Void> delete(String profileId) {
        return null;
    }

    @Override
    public Observable<String> createAccessToken() {
        return null;
    }
}
