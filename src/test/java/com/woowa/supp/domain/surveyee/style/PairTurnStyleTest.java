package com.woowa.supp.domain.surveyee.style;

import static com.woowa.supp.domain.surveyee.style.InvalidStyleException.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PairTurnStyleTest {
    @Test
    void of() {
        PairTurnStyle expected = PairTurnStyle.TURN_BY_TIME;
        PairTurnStyle actual = PairTurnStyle.of("시간을 정해서 돌아간다.");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidPairTurnStyle() {
        String invalidPairTurnStyle = "내가 혼자 할래요.";

        assertThatThrownBy(() -> PairTurnStyle.of(invalidPairTurnStyle))
                .isInstanceOf(InvalidStyleException.class)
                .hasMessage(STYLE_NOT_FOUND, invalidPairTurnStyle);
    }
}