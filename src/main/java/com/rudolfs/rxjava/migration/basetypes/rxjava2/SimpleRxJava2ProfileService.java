package com.rudolfs.rxjava.migration.basetypes.rxjava2;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SimpleRxJava2ProfileService implements RxJava2ProfileService {

    private final RxJava2StubProfileRepository repository;

    public SimpleRxJava2ProfileService(RxJava2StubProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<Profile> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Maybe<Profile> findByName(String name) {
        return null;
    }

    @Override
    public Flowable<Profile> findAll() {
        return null;
    }

    @Override
    public Completable insert(Profile profile) {
        return repository.insert(profile)
                .ignoreElement();
    }

    public Observable<Void> insertRxJava1Way(Profile profile) {
        return repository.insert(profile)
                .toObservable()
                .map(success -> null);
    }

    @Override
    public Completable upsert(Profile profile) {
        return null;
    }

    @Override
    public Completable delete(String profileId) {
        return null;
    }

    @Override
    public Single<String> createAccessToken() {
        return null;
    }
}
