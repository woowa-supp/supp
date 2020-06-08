package com.woowa.supp.web.dto;

import com.woowa.supp.domain.surveyee.DeveloperType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeveloperTypeSaveRequestDto {
	private String title;

	@Builder
	public DeveloperTypeSaveRequestDto(String title) {
		this.title = title;
	}

	public DeveloperType toEntity() {
		return DeveloperType.of(title);
	}
}
