package com.woowa.supp.domain.surveyee.style;

public class InvalidStyleException extends IllegalArgumentException {
    static final String USER_NOT_FOUND = "해당 스타일이 존재하지 않습니다 : %s";

    InvalidStyleException(String style) {
        super(String.format(USER_NOT_FOUND, style));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
