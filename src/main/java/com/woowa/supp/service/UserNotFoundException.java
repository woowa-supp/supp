package com.woowa.supp.service;

public class UserNotFoundException extends IllegalArgumentException {
    static final String USER_NOT_FOUND = "유저가 존재하지 않습니다 : %s";

    UserNotFoundException(String id) {
        super(String.format(USER_NOT_FOUND, id));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}