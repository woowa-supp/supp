package com.woowa.supp.service;

import java.util.Map;
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
	public Long saveOrUpdateType(DeveloperTypeSaveRequestDto requestDto, SessionUser user) {
		Optional<Surveyee> persist = surveyeeRepository.findByLogin(user.getLogin());
		if (persist.isPresent()) {
			return updateType(requestDto, persist.get());
		}
		return saveType(requestDto, user);
	}

	private Long updateType(DeveloperTypeSaveRequestDto requestDto, Surveyee persist) {
		persist.updateTypeBy(requestDto.toEntity());
		return persist.getId();
	}

	private Long saveType(DeveloperTypeSaveRequestDto requestDto,
			@LoginUser SessionUser sessionUser) {
		Surveyee surveyee = Surveyee.builder()
				.login(sessionUser.getLogin())
				.avatar(sessionUser.getAvatar())
				.developerType(requestDto.toEntity())
				.build();

		return surveyeeRepository.save(surveyee).getId();
	}

	@Transactional
	public Long saveStyle(Map<String, Object> styles, @LoginUser SessionUser sessionUser) {
		Optional<Surveyee> persist = surveyeeRepository.findByLogin(sessionUser.getLogin());
		if (persist.isPresent()) {
			persist.get().updateStylesBy(styles);
			return persist.get().getId();
		}
		throw new UserNotFoundException(sessionUser.getLogin());
	}

	@Transactional(readOnly = true)
	public Optional<Surveyee> findOptionalByUser(SessionUser user) {
		return surveyeeRepository.findByLogin(user.getLogin());
	}

	@Transactional(readOnly = true)
	public Surveyee findByUser(SessionUser user) {
		return findByLogin(user.getLogin());
	}

	@Transactional(readOnly = true)
	public Surveyee findByLogin(String login) {
		return surveyeeRepository.findByLogin(login)
				.orElseThrow(() -> new UserNotFoundException(login));
	}
}

