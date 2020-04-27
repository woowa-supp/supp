package com.woowa.supp.web;

import com.woowa.supp.domain.surveyee.DeveloperType;
import com.woowa.supp.domain.surveyee.Surveyee;
import com.woowa.supp.service.SurveyService;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

import static org.springframework.data.util.Optionals.ifPresentOrElse;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller
public class IndexController {
	private final SurveyService surveyService;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		if (user != null) {
			model.addAttribute("loginName", user.getLogin());
			ifPresentOrElse(surveyService.findByLogin(user),
					surveyee -> model.addAttribute("isTypeSurveyDone", surveyee.hasType()),
					() -> model.addAttribute("isTypeSurveyDone", false));
		}
		return "index";
	}

	@GetMapping("/survey-type")
	public String surveyType() {
		return "survey-type";
	}

	@GetMapping("/survey-style")
	public String surveyStyle() {
		return "survey-style";
	}

	@GetMapping("/result")
	public String result(@LoginUser SessionUser user) {
		Surveyee surveyee = surveyService.findByLogin(user).orElseThrow(NoSuchElementException::new);
		DeveloperType type = surveyee.getDeveloperType();
		return "/type-result/" + type.name().toLowerCase();
	}
}
