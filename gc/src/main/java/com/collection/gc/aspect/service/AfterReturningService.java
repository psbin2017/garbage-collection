package com.collection.gc.aspect.service;

public interface AfterReturningService {

    public void afterReturningException(String stringArg, Long longArg);

    public void afterReturning(String stringArg, Long longArg);
}
