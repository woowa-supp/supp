package com.woowa.supp.domain.surveyee.style;

import static com.woowa.supp.domain.surveyee.style.InvalidStyleException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerPreferStyleTest {
    @Test
    void of() {
        ComputerPreferStyle expected = ComputerPreferStyle.MY_COMPUTER;
        ComputerPreferStyle actual = ComputerPreferStyle.of("내 컴퓨터");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidComputerPreferStyle() {
        String invalidComputerPreferStyle = "그램이 좋아요";

        assertThatThrownBy(() -> ComputerPreferStyle.of(invalidComputerPreferStyle))
                .isInstanceOf(InvalidStyleException.class)
                .hasMessage(STYLE_NOT_FOUND, invalidComputerPreferStyle);
    }
}