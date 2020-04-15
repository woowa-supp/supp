package com.woowa.supp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import com.woowa.supp.domain.surveyee.Surveyee;
import com.woowa.supp.domain.surveyee.SurveyeeRepository;
import com.woowa.supp.web.dto.DeveloperTypeSaveRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SurveyService {

	private final SurveyeeRepository surveyeeRepository;

	@Transactional
	public Long saveType(DeveloperTypeSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {
		Surveyee surveyee = Surveyee.builder()
			.email(sessionUser.getEmail())
			.developerType(requestDto.toEntity())
			.build();

		return surveyeeRepository.save(surveyee).getId();
	}

	public Optional<Surveyee> findByEmail(SessionUser user) {
		return surveyeeRepository.findByEmail(user.getEmail());
	}
}
