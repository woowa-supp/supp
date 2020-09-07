package com.woowa.supp.domain.surveyee;


import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.woowa.supp.domain.surveyee.style.AfterStudyStyle;
import com.woowa.supp.domain.surveyee.style.BreaktimeStyle;
import com.woowa.supp.domain.surveyee.style.ComputerPreferStyle;
import com.woowa.supp.domain.surveyee.style.OSStyle;
import com.woowa.supp.domain.surveyee.style.PairTurnStyle;

public class SurveyeeTest {
	private Surveyee surveyee;

	@BeforeEach
	void setUp() {
		surveyee = Surveyee.builder()
			.id(1L)
			.login("login")
			.avatar("avatar")
			.developerType(DeveloperType.CODE_GUARDIAN)
			.build();
	}

	@Test
	public void hasType() {
		assertThat(surveyee.hasType()).isTrue();
		assertThat(Surveyee.builder().build().hasType()).isFalse();
	}

	@Test
	public void updateTypeBy() {
		DeveloperType updated = DeveloperType.MACGYVER;
		surveyee.updateTypeBy(updated);

		assertThat(surveyee.getDeveloperType()).isEqualTo(updated);
	}

	@Test
	public void updateStylesBy() {
		Map<String, Object> styles = new HashMap<>();
		String 사과 = "사과";
		String 내_컴퓨터 = "내 컴퓨터";
		String 저는_진짜_힘들때까진_계속_코딩_하는_편이에요 = "저는 진짜 힘들때까진 계속 코딩 하는 편이에요.";
		String 시간을_정해서_돌아간다 = "시간을 정해서 돌아간다.";
		String 밥먹고_더할까요 = "밥먹고 더할까요?";
		String TEST = "test";

		styles.put("0", 사과);
		styles.put("1", 내_컴퓨터);
		styles.put("2", 저는_진짜_힘들때까진_계속_코딩_하는_편이에요);
		styles.put("3", 시간을_정해서_돌아간다);
		styles.put("4", 밥먹고_더할까요);
		styles.put("5", new LinkedHashMap<String, String>());
		styles.put("6", new LinkedHashMap<String, String>());
		styles.put("7", TEST);

		surveyee.updateStylesBy(styles);

		assertThat(surveyee.getOsStyle()).isEqualTo(OSStyle.of(사과));
		assertThat(surveyee.getComputerPreferStyle()).isEqualTo(ComputerPreferStyle.of(내_컴퓨터));
		assertThat(surveyee.getBreaktimeStyle()).isEqualTo(BreaktimeStyle.of(저는_진짜_힘들때까진_계속_코딩_하는_편이에요));
		assertThat(surveyee.getPairTurnStyle()).isEqualTo(PairTurnStyle.of(시간을_정해서_돌아간다));
		assertThat(surveyee.getAfterStudyStyle()).isEqualTo(AfterStudyStyle.of(밥먹고_더할까요));
		assertThat(surveyee.getMessageToCrew()).isEqualTo(TEST);
	}
}