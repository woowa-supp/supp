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
    public Long saveType(DeveloperTypeSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {
        Surveyee surveyee = Surveyee.builder()
                                    .login(sessionUser.getLogin())
                                    .developerType(requestDto.toEntity())
                                    .build();

        return surveyeeRepository.save(surveyee).getId();
    }

    @Transactional
    public Long updateType(DeveloperTypeSaveRequestDto requestDto, Surveyee surveyee) {
        surveyee.updateTypeBy(requestDto.toEntity());
        return surveyeeRepository.save(surveyee).getId();
    }

    @Transactional
    public Long saveStyle(Map<String, Object> styles, @LoginUser SessionUser sessionUser) {
        // TODO: 2020/04/17 type 등록이 안된 상태로 접근한다면?
        Surveyee surveyee = surveyeeRepository.findByLogin(sessionUser.getLogin()).get();
        surveyee.updateStylesBy(styles);
        return surveyeeRepository.save(surveyee).getId();
    }

    public Optional<Surveyee> findByLogin(SessionUser user) {
        return surveyeeRepository.findByLogin(user.getLogin());
    }

    public Optional<Surveyee> findByLogin(String login) {
        return surveyeeRepository.findByLogin(login);
    }
}
