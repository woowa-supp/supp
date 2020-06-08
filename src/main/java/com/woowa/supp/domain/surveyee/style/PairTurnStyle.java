package com.woowa.supp.domain.surveyee.style;

import java.util.Arrays;

public enum PairTurnStyle {
	TURN_BY_TIME("시간을 정해서 돌아간다."),
	TURN_BY_FUNCTION("기능을 정해서 돌아간다."),
	DONT_CARE("상관 없다.");

	private final String title;

	PairTurnStyle(String title) {
		this.title = title;
	}

	public static PairTurnStyle of(String title) {
		return Arrays.stream(PairTurnStyle.values())
		             .filter(value -> value.title.equals(title))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException(title + ": 적절하지 않은 답변 이름 입니다."));
	}
}
