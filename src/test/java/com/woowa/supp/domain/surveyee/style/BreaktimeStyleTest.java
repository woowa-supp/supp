package com.woowa.supp.domain.surveyee.style;

import static com.woowa.supp.domain.surveyee.style.InvalidStyleException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BreaktimeStyleTest {
    @Test
    void of() {
        BreaktimeStyle expected = BreaktimeStyle.NO_BREAK;
        BreaktimeStyle actual = BreaktimeStyle.of("저는 진짜 힘들때까진 계속 코딩 하는 편이에요.");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidBreaktimeStyle() {
        String invalidBreaktimeStyle = "못해 안해";

        assertThatThrownBy(() -> BreaktimeStyle.of(invalidBreaktimeStyle))
                .isInstanceOf(InvalidStyleException.class)
                .hasMessage(STYLE_NOT_FOUND, invalidBreaktimeStyle);
    }
}