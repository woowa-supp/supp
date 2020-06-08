package com.woowa.supp.domain.surveyee;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum DeveloperType {
	MAD_SCIENTIST("Mad Scientist"),
	MACGYVER("MacGyver"),
	THE_ARCHITECT("The Architect"),
	CODE_GUARDIAN("Code Guardian"),
	NINJA("Ninja");

	private final String title;

	DeveloperType(String title) {
		this.title = title;
	}

	public static DeveloperType of(String title) {
		return Arrays.stream(DeveloperType.values())
		             .filter(developerType -> developerType.title.equals(title))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException(title + " : no matched type"));
	}
}
