package com.woowa.supp.domain.surveyee;

import com.woowa.supp.domain.surveyee.style.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

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
	private String testName;

	@Column
	private String gitConvention;

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
		this.osStyle = OSStyle.of(styles.get("0").toString());
		this.computerPreferStyle = ComputerPreferStyle.of(styles.get("1").toString());
		this.breaktimeStyle = BreaktimeStyle.of(styles.get("2").toString());
		this.pairTurnStyle = PairTurnStyle.of(styles.get("3").toString());
		this.afterStudyStyle = AfterStudyStyle.of(styles.get("4").toString());
		this.testName = toJsonFormat((LinkedHashMap<String, String>) styles.get("5"));
		this.gitConvention = toJsonFormat((LinkedHashMap<String, String>) styles.get("6"));
		this.messageToCrew = styles.get("7").toString();
	}

	private String toJsonFormat(LinkedHashMap<String, String> style) {
		String firstKey = "firstAnswer";
		String secondKey = "secondAnswer";

		String first = style.get(firstKey);
		String second = style.get(secondKey);

		return "{" + firstKey + ":" + first + "," + secondKey + ":" + second + "}";
	}
}
