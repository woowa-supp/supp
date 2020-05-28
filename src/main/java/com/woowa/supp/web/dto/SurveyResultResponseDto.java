package com.woowa.supp.web.dto;

import com.woowa.supp.domain.surveyee.Surveyee;
import lombok.Getter;

@Getter
public class SurveyResultResponseDto {

	private String login;
	private String developerType;
	private String osStyle;
	private String computerPrefer;
	private String breaktime;
	private String pairTurn;
	private String afterStudy;
	private String testName;
	private String gitConvention;
	private String messageToCrew;

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
