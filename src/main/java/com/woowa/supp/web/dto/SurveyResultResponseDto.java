package com.woowa.supp.web.dto;

import com.woowa.supp.domain.surveyee.Surveyee;
import lombok.Getter;

@Getter
public class SurveyResultResponseDto {

	private String login;
	private String avatar;
	private String developerType;
	private String osStyle;
	private String computerPrefer;
	private String breaktime;
	private String pairTurn;
	private String afterStudy;
	private String testNameFirstAnswer;
	private String testNameSecondAnswer;
	private String gitConventionFirstAnswer;
	private String gitConventionSecondAnswer;
	private String messageToCrew;

	public SurveyResultResponseDto(Surveyee entity) {
		this.login = entity.getLogin().toLowerCase();
		this.avatar = entity.getAvatar();
		this.developerType = entity.getDeveloperType().name();
		this.osStyle = entity.getOsStyle().name();
		this.computerPrefer = entity.getComputerPreferStyle().name();
		this.breaktime = entity.getBreaktimeStyle().name();
		this.pairTurn = entity.getPairTurnStyle().name();
		this.afterStudy = entity.getAfterStudyStyle().name();
		this.testNameFirstAnswer = entity.getTestNameFirstAnswer();
		this.testNameSecondAnswer = entity.getTestNameSecondAnswer();
		this.gitConventionFirstAnswer = entity.getGitConventionFirstAnswer();
		this.gitConventionSecondAnswer = entity.getGitConventionSecondAnswer();
		this.messageToCrew = entity.getMessageToCrew();
	}
}
