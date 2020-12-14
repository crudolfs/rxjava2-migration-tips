package com.rudolfs.rxjava.migration.errorhandling.rxjava2;

import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponse;
import com.rudolfs.rxjava.migration.errorhandling.HttpServerResponseImpl;
import com.rudolfs.rxjava.migration.errorhandling.RoutingContextImpl;
import com.rudolfs.rxjava.migration.errorhandling.rxjava1.CustomResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RxJava2ErrorHandlingTest {

    private RxJava2ErrorHandling rxJava2ErrorHandling;

    @BeforeEach
    void beforeEach() {
        this.rxJava2ErrorHandling = new RxJava2ErrorHandling();
    }

    @Test
    void routeToNextMatchingRoute() {
        rxJava2ErrorHandling.handleResponse(0, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseShouldHaveBeenEnded() {
        rxJava2ErrorHandling.handleResponse(1, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseIsNullEvent() {
        assertThrows(NullPointerException.class, () -> {
            rxJava2ErrorHandling.handleResponse(2, new RoutingContextImpl(new HttpServerResponseImpl()));
        });
    }

    @Test
    void responseShouldHaveBeenEndedCaught() {
        rxJava2ErrorHandling.handleResponseCatchException(1, new RoutingContextImpl(new HttpServerResponseImpl()));
    }

    @Test
    void responseShouldNotHaveBeenEnded() {
        HttpServerResponse httpServerResponse = new HttpServerResponseImpl();
        httpServerResponse.close();

        rxJava2ErrorHandling.handleResponse(0, new RoutingContextImpl(httpServerResponse));
    }

    @Test
    void responseShouldNotHaveBeenEndedCaught() {
        HttpServerResponse httpServerResponse = new HttpServerResponseImpl();
        httpServerResponse.close();

        rxJava2ErrorHandling.handleResponseCatchException(0, new RoutingContextImpl(httpServerResponse));
    }

    @Test
    void response() {
        rxJava2ErrorHandling.handleResponse(99, new RoutingContextImpl(new HttpServerResponseImpl()));
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
        RxJavaPlugins.setErrorHandler(throwable -> {
            System.out.println("RxJavaPlugins.onError: " + throwable.getMessage());
        });

        Single.just(CustomResponse.ENDED)
                .subscribe(customResponse -> {
                    System.out.println("onSuccess");
                    throw new IllegalStateException("Response should not have been ended");
                }, throwable -> {
                    System.out.println("onError: " + throwable.getMessage());
                });
    }
}
