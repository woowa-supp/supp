package com.woowa.supp.domain.surveyee.style;

import static com.woowa.supp.domain.surveyee.style.InvalidStyleException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OSStyleTest {
    @Test
    void of() {
        OSStyle expected = OSStyle.APPLE;
        OSStyle actual = OSStyle.of("사과");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidOSStyle() {
        String invalidOSStyle = "티맥스";

        assertThatThrownBy(() -> OSStyle.of(invalidOSStyle))
                .isInstanceOf(InvalidStyleException.class)
                .hasMessage(STYLE_NOT_FOUND, invalidOSStyle);
    }
}