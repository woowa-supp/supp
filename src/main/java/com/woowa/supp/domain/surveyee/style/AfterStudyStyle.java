package com.woowa.supp.domain.surveyee.style;

import java.util.Arrays;

public enum AfterStudyStyle {
    MORE_PAIR("밥먹고 더할까요?"),
    WRAP_UP("내일 마무리 해보죠."),
    WAIT_PAIR_SUGGESTION("상대방의 말을 기다린다.");

    private final String title;

    AfterStudyStyle(String title) {
        this.title = title;
    }

    public static AfterStudyStyle of(String title) {
        return Arrays.stream(AfterStudyStyle.values())
                .filter(value -> value.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new InvalidStyleException(title));
    }
}
