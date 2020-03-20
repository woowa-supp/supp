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
			model.addAttribute("crewName", user.getName());
		}
		return "index";
	}

	@GetMapping("/survey")
	public String surveyStart(Model model) {
		model.addAttribute("question", "멀티테스킹에 대해 어떻게 생각하시나요?😀");
		model.addAttribute("answerYes", "저는 여러가지 일을 동시에 할 수 있죠!😉");
		model.addAttribute("answerNo", "왜 한번에 하나만 하면 안되는거죠?😤");
		model.addAttribute("pageYes", "/survey/y");
		model.addAttribute("pageNo", "/survey/n");
		return "survey";
	}

	@GetMapping("/survey/y")
	public String surveyYes(Model model) {
		model.addAttribute("question", "갑자기 예측할 수 없는 에러가 발생했어요. 당신은 어떻게 행동할건가요?");
		model.addAttribute("answerYes", "포기하지 않을거에요! 해결책을 찾아야죠!");
		model.addAttribute("answerNo", "웹에서 해결책을 찾을거에요.");
		model.addAttribute("pageYes", "/survey/y/y");
		model.addAttribute("pageNo", "/survey/y/n");
		return "survey";
	}

	@GetMapping("/survey/n")
	public String surveyNo(Model model) {
		model.addAttribute("question", "협업에 대해서 어떻게 생각해요?");
		model.addAttribute("answerYes", "사람이 많을 수록 일은 더 잘 되요!");
		model.addAttribute("answerNo", "저는 외로운 늑대죠...");
		model.addAttribute("pageYes", "/survey/n/y");
		model.addAttribute("pageNo", "/survey/n/n");
		return "survey";
	}

	@GetMapping("/survey/y/y")
	public String surveyYesYes(Model model) {
		model.addAttribute("question", "12시 01분은 12시 00분이 아니다?");
		model.addAttribute("answerYes", "1분 정도는 괜찮죠~");
		model.addAttribute("answerNo", "시간은 칼같이 지켜야해요.");
		model.addAttribute("pageYes", "/survey/y/y/y");
		model.addAttribute("pageNo", "/survey/y/y/n");
		return "survey";
	}

	@GetMapping("/survey/y/n")
	public String surveyYesNo(Model model) {
		model.addAttribute("question", "코드의 퀄리티는 중요한가요?");
		model.addAttribute("answerYes", "완벽함보다는 완료하는게 중요해요.");
		model.addAttribute("answerNo", "코드는 규칙을 따라야해요.");
		model.addAttribute("pageYes", "/survey/y/n/y");
		model.addAttribute("pageNo", "/survey/y/n/n");
		return "survey";
	}

	@GetMapping("/survey/n/y")
	public String surveyNoYes(Model model) {
		model.addAttribute("question", "코드의 퀄리티는 중요한가요?");
		model.addAttribute("answerYes", "완벽함보다는 완료하는게 중요해요.");
		model.addAttribute("answerNo", "코드는 규칙을 따라야해요.");
		model.addAttribute("pageYes", "/survey/n/y/y");
		model.addAttribute("pageNo", "/survey/n/y/n");
		return "survey";
	}

	@GetMapping("/survey/n/n")
	public String surveyNoNo(Model model) {
		model.addAttribute("question", "체크무늬셔츠 좋아하나요?");
		model.addAttribute("answerYes", "그럼요 체크무늬셔츠가 유행이 아닌 적이 없죠!");
		model.addAttribute("answerNo", "세상엔 많은 종류의 옷들이 있어요.");
		model.addAttribute("pageYes", "/survey/n/n/y");
		model.addAttribute("pageNo", "/survey/n/n/n");
		return "survey";
	}
}
