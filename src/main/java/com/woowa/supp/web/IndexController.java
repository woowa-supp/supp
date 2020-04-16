package com.woowa.supp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woowa.supp.config.auth.LoginUser;
import com.woowa.supp.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		if (user != null) {
			model.addAttribute("loginName", user.getLogin());
		}
		return "index";
	}

	@GetMapping("/survey-type")
	public String survey() {
		return "survey-type";
	}

	@GetMapping("/survey-style")
	public String pair() {
		return "survey-style";
	}
}
