package com.rudolfs.rxjava.migration.errorhandling.rxjava1;

import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponse;
import com.rudolfs.rxjava.migration.errorhandling.RoutingContext;
import lombok.extern.slf4j.Slf4j;
import rx.Observable;

import static java.util.Objects.requireNonNull;

@Slf4j
public class RxJava1ErrorHandling {

    void handleResponse(int flow, RoutingContext routingContext) {
        handle(flow)
                //.singleOrDefault(null)
                .subscribe(customResponse -> handleCustomResponse(routingContext, customResponse),
                        routingContext::fail,
                        () -> log.info("onCompleted"));
    }

    private Observable<CustomResponse> handle(int flow) {
        switch (flow) {
            case 0:
                return CustomResponse.notEnded();
            case 1:
                return CustomResponse.ended();
            case 2:
                // triggers onNext with 'null' event
                return Observable.just(null);
            default:
                // triggers onCompleted immediately
                return Observable.empty();
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

