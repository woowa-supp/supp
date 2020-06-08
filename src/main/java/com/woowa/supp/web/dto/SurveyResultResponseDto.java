package com.woowa.supp.web.dto;

import com.woowa.supp.domain.surveyee.Surveyee;
import lombok.Getter;

@Getter
public class SurveyResultResponseDto {

	private final String login;
	private final String developerType;
	private final String osStyle;
	private final String computerPrefer;
	private final String breaktime;
	private final String pairTurn;
	private final String afterStudy;
	private final String testName;
	private final String gitConvention;
	private final String messageToCrew;

	public SurveyResultResponseDto(Surveyee entity) {
		this.login = entity.getLogin().toLowerCase();
		this.developerType = entity.getDeveloperType().name();
		this.osStyle = entity.getOsStyle().name();
		this.computerPrefer = entity.getComputerPreferStyle().name();
		this.breaktime = entity.getBreaktimeStyle().name();
		this.pairTurn = entity.getPairTurnStyle().name();
		this.afterStudy = entity.getAfterStudyStyle().name();
		this.testName = entity.getTestName();
		this.gitConvention = entity.getGitConvention();
		this.messageToCrew = entity.getMessageToCrew();
	}
}
