package com.woowa.supp.web;

import static org.springframework.data.util.Optionals.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import com.woowa.supp.service.SurveyService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	private final SurveyService surveyService;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		if (user != null) {
			model.addAttribute("loginName", user.getLogin());
			ifPresentOrElse(surveyService.findOptionalByUser(user),
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

	@GetMapping("/developer/{developerType}")
	public String result(@PathVariable("developerType") String developerType) {
		return "developer/" + developerType;
	}
}
