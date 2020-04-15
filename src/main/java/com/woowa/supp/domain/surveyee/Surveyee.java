package com.woowa.supp.domain.surveyee;

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
	private String email;

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

	@Builder
	public Surveyee(String email, DeveloperType developerType, AfterStudyStyle afterStudyStyle, BreaktimeStyle breaktimeStyle, ComputerPreferStyle computerPreferStyle, OSStyle osStyle, PairTurnStyle pairTurnStyle) {
		this.email = email;
		this.developerType = developerType;
		this.afterStudyStyle = afterStudyStyle;
		this.breaktimeStyle = breaktimeStyle;
		this.computerPreferStyle = computerPreferStyle;
		this.osStyle = osStyle;
		this.pairTurnStyle = pairTurnStyle;
	}
}
