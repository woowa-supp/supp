package com.woowa.supp.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowa.supp.config.auth.CustomOAuth2UserService;
import com.woowa.supp.domain.surveyee.DeveloperType;
import com.woowa.supp.domain.surveyee.Surveyee;
import com.woowa.supp.domain.user.UserRepository;
import com.woowa.supp.service.SurveyService;
import com.woowa.supp.web.dto.DeveloperTypeSaveRequestDto;

@WebMvcTest(controllers = SurveyApiController.class)
@Import(value = {CustomOAuth2UserService.class})
public class SurveyApiControllerTest {
	@MockBean
	private SurveyService surveyService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private ClientRegistrationRepository clientRegistrationRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	private Surveyee surveyee;

	@BeforeEach
	void setUp(WebApplicationContext webApplicationContext) {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
			.alwaysDo(print())
			.build();
		Map<String, Object> styles = new HashMap<>();
		styles.put("0", "사과");
		styles.put("1", "내 컴퓨터");
		styles.put("2", "저는 진짜 힘들때까진 계속 코딩 하는 편이에요.");
		styles.put("3", "시간을 정해서 돌아간다.");
		styles.put("4", "밥먹고 더할까요?");
		styles.put("5", new LinkedHashMap<String, String>());
		styles.put("6", new LinkedHashMap<String, String>());
		styles.put("7", "test");

		surveyee = new Surveyee("login", "avatar", DeveloperType.CODE_GUARDIAN);
		surveyee.updateStylesBy(styles);
	}

	@Test
	public void saveType() throws Exception {
		String request = objectMapper.writeValueAsString(new DeveloperTypeSaveRequestDto("title"));

		when(surveyService.saveOrUpdateType(any(), any())).thenReturn(1L);

		mockMvc.perform(put("/api/v1/survey-type")
			.contentType(MediaType.APPLICATION_JSON)
			.content(request)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	public void saveStyle() throws Exception {
		String request = objectMapper.writeValueAsString(new HashMap<String, Object>());

		when(surveyService.saveStyle(any(), any())).thenReturn(1L);

		mockMvc.perform(put("/api/v1/survey-style")
			.contentType(MediaType.APPLICATION_JSON)
			.content(request)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	public void findByUser() throws Exception {
		when(surveyService.findByUser(any())).thenReturn(surveyee);

		mockMvc.perform(get("/api/v1/survey-result")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	public void findByLogin() throws Exception {
		String login = "login";
		when(surveyService.findByLogin(login)).thenReturn(surveyee);

		mockMvc.perform(get("/api/v1/survey-result/" + login)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

	@Test
	public void result() throws Exception {
		when(surveyService.findByUser(any())).thenReturn(surveyee);

		mockMvc.perform(get("/api/v1/result")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
}