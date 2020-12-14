package com.rudolfs.rxjava.migration.errorhandling.rxjava2;

import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponse;
import com.rudolfs.rxjava.migration.errorhandling.RoutingContext;
import io.reactivex.Maybe;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.requireNonNull;

@Slf4j
public class RxJava2ErrorHandling {

    void handleResponse(int flow, RoutingContext routingContext) {
        handle(flow)
                //.defaultIfEmpty(CustomResponse.NOT_ENDED)
                .subscribe(customResponse -> handleCustomResponse(routingContext, customResponse),
                        routingContext::fail,
                        () -> log.info("onCompleted"));
    }

    void handleResponseCatchException(int flow, RoutingContext routingContext) {
        handle(flow)
                .flatMapSingle(customResponse -> Single.fromCallable(() -> {
                    handleCustomResponse(routingContext, customResponse);
                    return customResponse;
                }))
                .subscribe(customResponse -> log.info("onCompleted"),
                        routingContext::fail);
    }

    private Maybe<CustomResponse> handle(int flow) {
        switch (flow) {
            case 0:
                return CustomResponse.notEnded().toMaybe();
            case 1:
                return CustomResponse.ended().toMaybe();
            case 2:
                // throws NullPointerException in RxJava 2
                return Maybe.just(null);
            default:
                // triggers onComplete immediately
                return Maybe.empty();
        }
    }

    private static void handleCustomResponse(RoutingContext routingContext, CustomResponse customResponse) {
        requireNonNull(routingContext.response());

        HttpServerResponse httpServerResponse = routingContext.response();

        if (customResponse == null) {
            log.info("CustomResponse == null");
        }

        if (customResponse == CustomResponse.ENDED && !httpServerResponse.closed() && !httpServerResponse.ended()) {
            throw new IllegalStateException("Response should have been ended");
        }

        if (customResponse == CustomResponse.NOT_ENDED) {
            if (httpServerResponse.ended()) {
                throw new IllegalStateException("Response should not have been ended");
            } else if (!httpServerResponse.closed()) {
                routingContext.next();
            }
        }
    }
}

