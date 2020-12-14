package com.rudolfs.rxjava.migration.errorhandling;

public interface RoutingContext {

    void next();

    void fail(Throwable throwable);

    HttpServerResponse response();
}
