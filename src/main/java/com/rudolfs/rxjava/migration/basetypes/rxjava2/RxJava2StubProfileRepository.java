package com.rudolfs.rxjava.migration.basetypes.rxjava2;

import com.rudolfs.rxjava.migration.basetypes.model.Profile;
import com.rudolfs.rxjava.migration.basetypes.model.Success;
import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.HashMap;
import java.util.Map;

public class RxJava2StubProfileRepository {
    private Map<String, Profile> repository = new HashMap<>();

    public Maybe<Profile> findById(String profileId) {
        return Maybe.fromCallable(() -> repository.containsKey(profileId) ? repository.get(profileId) : null);
    }

    public Single<Success> insert(Profile profile) {
        return Single.fromCallable(() -> {
            repository.put(profile.getId(), profile);
            return Success.SUCCESS;
        });
    }
}
