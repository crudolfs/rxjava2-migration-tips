package com.rudolfs.rxjava.migration.basetypes.rxjava2;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface RxJava2ProfileService {

    Maybe<Profile> findById(String id);

    Maybe<Profile> findByName(String name);

    Flowable<Profile> findAll();

    Completable insert(Profile profile);

    Completable upsert(Profile profile);

    Completable delete(String profileId);

    Single<String> createAccessToken();
}
