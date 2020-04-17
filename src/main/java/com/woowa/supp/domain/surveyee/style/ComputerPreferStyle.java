package com.woowa.supp.domain.surveyee.style;

import java.util.Arrays;

public enum ComputerPreferStyle {
	MY_COMPUTER("내 컴퓨터"),
	PAIR_COMPUTER("페어의 컴퓨터"),
	DONT_CARE("아무거나"),
	IN_TURN("번갈아가며");

	private final String title;

	ComputerPreferStyle(String title) {
		this.title = title;
	}

	public static ComputerPreferStyle of(String title) {
		return Arrays.stream(ComputerPreferStyle.values())
			.filter(value -> value.title.equals(title))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(title + ": 적절하지 않은 답변 이름 입니다."));
	}
}
