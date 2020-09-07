package com.woowa.supp.domain.surveyee.style;

import java.util.Arrays;

public enum OSStyle {
    APPLE("사과"),
    WINDOWS("창문"),
    LINUX("펭귄");

    private final String title;

    OSStyle(String title) {
        this.title = title;
    }

    public static OSStyle of(String title) {
        return Arrays.stream(OSStyle.values())
                .filter(value -> value.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new InvalidStyleException(title));
    }
}
