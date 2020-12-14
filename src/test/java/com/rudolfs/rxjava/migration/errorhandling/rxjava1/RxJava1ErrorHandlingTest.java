package com.rudolfs.rxjava.migration.errorhandling.rxjava1;

import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponse;
import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponseImpl;
import com.rudolfs.rxjava.migration.errorhandling.RoutingContextImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rx.Completable;
import rx.Observable;
import rx.Single;

class RxJava1ErrorHandlingTest {

    private RxJava1ErrorHandling rxJava1ErrorHandling;

    @BeforeEach
    void beforeEach() {
        this.rxJava1ErrorHandling = new RxJava1ErrorHandling();
    }

    @Test
    void routeToNextMatchingRoute() {
        rxJava1ErrorHandling.handleResponse(0, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseShouldHaveBeenEnded() {
        rxJava1ErrorHandling.handleResponse(1, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseIsNullEvent() {
        rxJava1ErrorHandling.handleResponse(2, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseShouldNotHaveBeenEnded() {
        HttpServerResponse httpServerResponse = new HttpServerResponseImpl();
        httpServerResponse.close();

        rxJava1ErrorHandling.handleResponse(0, new RoutingContextImpl(httpServerResponse));
    }

    @Test
    void response() {
        rxJava1ErrorHandling.handleResponse(99, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void testObservableErrorHandling() {
        Observable.just(CustomResponse.ENDED)
                .subscribe(customResponse -> {
                    System.out.println("onNext");
                    throw new IllegalStateException("Response should not have been ended");
                }, throwable -> {
                    System.out.println("onError: " + throwable.getMessage());
                }, () -> System.out.println("onCompleted"));
    }

    @Test
    void testSingleErrorHandling() {
        Single.just(CustomResponse.ENDED)
                .subscribe(customResponse -> {
                    System.out.println("onCompleted");
                    throw new IllegalStateException("Response should not have been ended");
                }, throwable -> {
                    System.out.println("onError: " + throwable.getMessage());
                });
    }

    @Test
    void testCompletableErrorHandling() {
        Completable.complete()
                .subscribe(() -> {
                    System.out.println("onCompleted");
                    throw new IllegalStateException("Response should not have been ended");
                }, throwable -> {
                    System.out.println("onError: " + throwable.getMessage());
                });
    }
}
