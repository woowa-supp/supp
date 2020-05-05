package com.woowa.supp.web;

import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import com.woowa.supp.service.SurveyService;
import com.woowa.supp.web.dto.DeveloperTypeSaveRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SurveyApiController {

    private final SurveyService surveyService;

    @PutMapping("/api/v1/survey-type")
    public Long saveType(@RequestBody DeveloperTypeSaveRequestDto requestDto, @LoginUser SessionUser user) {
        return surveyService.findByLogin(user)
                .map(surveyee -> surveyService.updateType(requestDto, surveyee))
                .orElseGet(() -> surveyService.saveType(requestDto, user));
    }

    @PutMapping("/api/v1/survey-style")
    public Long saveStyle(@RequestBody Map<String, Object> styles, @LoginUser SessionUser user) {
        return surveyService.saveStyle(styles, user);
    }
}
