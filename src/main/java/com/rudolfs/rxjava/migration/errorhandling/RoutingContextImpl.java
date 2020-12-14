package com.rudolfs.rxjava.migration.errorhandling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoutingContextImpl implements RoutingContext {

    private final HttpServerResponse httpServerResponse;

    public RoutingContextImpl(HttpServerResponse httpServerResponse) {
        this.httpServerResponse = httpServerResponse;
    }

    @Override
    public void next() {
        log.info("Tell the router to route this context to the next matching route (if any).");
    }

    @Override
    public void fail(Throwable throwable) {
        log.error("Fail the context: ", throwable);
    }

    @Override
    public HttpServerResponse response() {
        return this.httpServerResponse;
    }
}
