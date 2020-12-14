package com.rudolfs.rxjava.migration.errorhandling;

public class HttpServerResponseImpl implements HttpServerResponse {

    private boolean ended = false;
    private boolean closed = false;

    @Override
    public boolean ended() {
        return this.ended;
    }

    @Override
    public boolean closed() {
        return this.closed;
    }

    @Override
    public void close() {
        this.ended = true;
        this.closed = true;
    }
}
