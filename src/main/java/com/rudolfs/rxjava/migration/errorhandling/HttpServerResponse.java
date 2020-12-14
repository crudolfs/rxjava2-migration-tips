package com.rudolfs.rxjava.migration.errorhandling;

public interface HttpServerResponse {

    boolean ended();

    boolean closed();

    void close();
}
