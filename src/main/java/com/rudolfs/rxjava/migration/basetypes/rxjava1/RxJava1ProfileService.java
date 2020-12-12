package com.rudolfs.rxjava.migration.basetypes.rxjava1;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import rx.Observable;

public interface RxJava1ProfileService {

    Observable<Profile> findById(String id);

    Observable<Profile> findByName(String name);

    Observable<Profile> findAll();

    Observable<Void> insert(Profile profile);

    Observable<Void> upsert(Profile profile);

    Observable<Void> delete(String profileId);

    Observable<String> createAccessToken();
}

