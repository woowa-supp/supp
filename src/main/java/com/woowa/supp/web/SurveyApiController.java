package com.woowa.supp.web;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import com.woowa.supp.domain.surveyee.Surveyee;
import com.woowa.supp.service.SurveyService;
import com.woowa.supp.web.dto.DeveloperTypeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.data.util.Optionals.ifPresentOrElse;

@RequiredArgsConstructor
@RestController
public class SurveyApiController {

    private final SurveyService surveyService;

    @PutMapping("/api/v1/survey-type")
    public Long saveType(@RequestBody DeveloperTypeSaveRequestDto requestDto, @LoginUser SessionUser user) {
        if (surveyService.findByLogin(user).isPresent()) {
            Surveyee surveyee = surveyService.findByLogin(user)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Surveyee입니다."));
            return surveyService.updateType(requestDto, surveyee);
        }
        return surveyService.saveType(requestDto, user);
    }

    @PutMapping("/api/v1/survey-style")
    public Long saveStyle(@RequestBody Map<String, Object> styles, @LoginUser SessionUser user) {
        return surveyService.saveStyle(styles, user);
    }
}
