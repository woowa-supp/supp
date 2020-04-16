package com.woowa.supp.web;


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

    @PutMapping("/api/v1/type")
    public Long saveType(@RequestBody DeveloperTypeSaveRequestDto requestDto, @LoginUser SessionUser user) {
        if (surveyService.findByLogin(user).isPresent()) {
            throw new IllegalArgumentException(user.getLogin() + " is present");
        }
        return surveyService.saveType(requestDto, user);
    }
}
