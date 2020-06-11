package com.woowa.supp.domain.surveyee;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.woowa.supp.domain.surveyee.style.AfterStudyStyle;
import com.woowa.supp.domain.surveyee.style.BreaktimeStyle;
import com.woowa.supp.domain.surveyee.style.ComputerPreferStyle;
import com.woowa.supp.domain.surveyee.style.OSStyle;
import com.woowa.supp.domain.surveyee.style.PairTurnStyle;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Surveyee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String login;

	@Column(nullable = false)
	private String avatar;

	@Enumerated(EnumType.STRING)
	private DeveloperType developerType;

	@Enumerated(EnumType.STRING)
	private AfterStudyStyle afterStudyStyle;

	@Enumerated(EnumType.STRING)
	private BreaktimeStyle breaktimeStyle;

	@Enumerated(EnumType.STRING)
	private ComputerPreferStyle computerPreferStyle;

	@Enumerated(EnumType.STRING)
	private OSStyle osStyle;

	@Enumerated(EnumType.STRING)
	private PairTurnStyle pairTurnStyle;

	@Column
	private String testNameFirstAnswer;

	@Column
	private String testNameSecondAnswer;

	@Column
	private String gitConventionFirstAnswer;

	@Column
	private String gitConventionSecondAnswer;

	@Column
	private String messageToCrew;

	@Builder
	public Surveyee(String login, String avatar, DeveloperType developerType) {
		this.login = login;
		this.avatar = avatar;
		this.developerType = developerType;
	}

	public boolean hasType() {
		return developerType != null;
	}

	public void updateTypeBy(DeveloperType developerType) {
		this.developerType = developerType;
	}

	public void updateStylesBy(Map<String, Object> styles) {
		String firstAnswerKey = "firstAnswer";
		String secondAnswerKey = "secondAnswer";

		this.osStyle = OSStyle.of(styles.get("0").toString());
		this.computerPreferStyle = ComputerPreferStyle.of(styles.get("1").toString());
		this.breaktimeStyle = BreaktimeStyle.of(styles.get("2").toString());
		this.pairTurnStyle = PairTurnStyle.of(styles.get("3").toString());
		this.afterStudyStyle = AfterStudyStyle.of(styles.get("4").toString());

		LinkedHashMap<String, String> testName = (LinkedHashMap<String, String>) styles.get("5");
		this.testNameFirstAnswer = testName.get(firstAnswerKey);
		this.testNameSecondAnswer = testName.get(secondAnswerKey);

		LinkedHashMap<String, String> gitConvention = (LinkedHashMap<String, String>) styles.get("6");
		this.gitConventionFirstAnswer = gitConvention.get(firstAnswerKey);
		this.gitConventionSecondAnswer = gitConvention.get(secondAnswerKey);
		this.messageToCrew = styles.get("7").toString();
	}
}
