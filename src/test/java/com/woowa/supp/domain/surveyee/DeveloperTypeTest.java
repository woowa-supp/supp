package com.woowa.supp.domain.surveyee;

import static com.woowa.supp.domain.surveyee.DeveloperType.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeveloperTypeTest {
    @Test
    void of() {
        DeveloperType expected = DeveloperType.MAD_SCIENTIST;
        DeveloperType actual = DeveloperType.of("Mad Scientist");

        assertEquals(expected, actual);
    }

    @Test
    void of_GivenInvalidDeveloperType() {
        String invalidDeveloperType = "ESFJ";

        assertThatThrownBy(() -> DeveloperType.of(invalidDeveloperType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TYPE_NOT_FOUND, invalidDeveloperType);
    }
}