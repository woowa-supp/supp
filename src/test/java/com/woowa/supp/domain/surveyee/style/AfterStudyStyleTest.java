package com.woowa.supp.domain.surveyee.style;

import static com.woowa.supp.domain.surveyee.style.InvalidStyleException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AfterStudyStyleTest {
    @Test
    void of() {
        AfterStudyStyle expected = AfterStudyStyle.MORE_PAIR;
        AfterStudyStyle actual = AfterStudyStyle.of("밥먹고 더할까요?");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidAfterStudyStyle() {
        String invalidAfterStudyStyle = "메롱 안해";

        assertThatThrownBy(() -> AfterStudyStyle.of(invalidAfterStudyStyle))
                .isInstanceOf(InvalidStyleException.class)
                .hasMessage(STYLE_NOT_FOUND, invalidAfterStudyStyle);
    }
}