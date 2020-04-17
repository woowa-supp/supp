package com.woowa.supp.domain.surveyee.style;

import java.util.Arrays;

public enum BreaktimeStyle {
	NO_BREAK("저는 진짜 힘들때까진 계속 코딩 하는 편이에요."),
	SCHEDULED_BREAK("저는 일정 시간마다 쉬어야 합니다."),
	DONT_CARE("저는 뭐... 상관 없습니다.");

	private final String title;

	BreaktimeStyle(String title) {
		this.title = title;
	}

	public static BreaktimeStyle of(String title) {
		return Arrays.stream(BreaktimeStyle.values())
			.filter(value -> value.title.equals(title))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(title + ": 적절하지 않은 답변 이름 입니다."));
	}
}
