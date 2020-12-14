package com.rudolfs.rxjava.migration.errorhandling.rxjava2;


import io.reactivex.Single;

public enum CustomResponse {
    ENDED,
    NOT_ENDED;

    public static Single<CustomResponse> notEnded() {
        return Single.just(CustomResponse.NOT_ENDED);
    }

    public static Single<CustomResponse> ended() {
        return Single.just(CustomResponse.ENDED);
    }
}
