package com.rudolfs.rxjava.migration.errorhandling.rxjava1;

import rx.Observable;

import static rx.Observable.just;

public enum CustomResponse {
    ENDED,
    NOT_ENDED;

    public static Observable<CustomResponse> notEnded() {
        return just(CustomResponse.NOT_ENDED);
    }

    public static Observable<CustomResponse> ended() {
        return just(CustomResponse.ENDED);
    }
}
