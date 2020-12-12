package com.rudolfs.rxjava.migration.basetypes.rxjava1;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import com.rudolfs.rxjava.migration.basetypes.model.Success;
import rx.Observable;

import java.util.HashMap;
import java.util.Map;

public class RxJava1StubProfileRepository {
    private Map<String, Profile> repository = new HashMap<>();

    public Observable<Profile> findById(String profileId) {
        return Observable.fromCallable(() -> repository.get(profileId));
    }

    public Observable<Success> insert(Profile profile) {
        return Observable.fromCallable(() -> {
            repository.put(profile.getId(), profile);

            return Success.SUCCESS;
        });
    }
}
