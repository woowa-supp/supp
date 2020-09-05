package com.woowa.supp.service;

import static com.woowa.supp.service.UserNotFoundException.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.woowa.supp.config.auth.dto.SessionUser;
import com.woowa.supp.domain.surveyee.Surveyee;
import com.woowa.supp.domain.surveyee.SurveyeeRepository;
import com.woowa.supp.domain.user.User;
import com.woowa.supp.web.dto.DeveloperTypeSaveRequestDto;

@ExtendWith(value = MockitoExtension.class)
public class SurveyServiceTest {

	@Mock
	private SurveyeeRepository surveyeeRepository;

	private SurveyService surveyService;

	@BeforeEach
	void setUp() {
		surveyService = new SurveyService(surveyeeRepository);
	}

	@Test
	public void saveType() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.empty());

		when(surveyeeRepository.save(any()))
				.thenReturn(Surveyee.builder()
						.id(1L)
						.build());

		assertThat(surveyService.saveOrUpdateType(new DeveloperTypeSaveRequestDto("Mad Scientist"),
				new SessionUser(new User()))).isEqualTo(1L);
	}

	@Test
	public void updateType() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.of(Surveyee.builder().id(1L).build()));

		assertThat(surveyService.saveOrUpdateType(new DeveloperTypeSaveRequestDto("Mad Scientist"),
				new SessionUser(new User()))).isEqualTo(1L);
	}

	@Test
	public void saveStyle() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.of(Surveyee.builder().id(1L).build()));

		Map<String, Object> styles = new HashMap<>();
		styles.put("0", "사과");
		styles.put("1", "내 컴퓨터");
		styles.put("2", "저는 진짜 힘들때까진 계속 코딩 하는 편이에요.");
		styles.put("3", "시간을 정해서 돌아간다.");
		styles.put("4", "밥먹고 더할까요?");
		styles.put("5", new LinkedHashMap<String, String>());
		styles.put("6", new LinkedHashMap<String, String>());
		styles.put("7", "test");

		assertThat(surveyService.saveStyle(styles, new SessionUser(new User()))).isEqualTo(1L);
	}

	@Test
	public void saveStyleWhenNoSurveyee() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.empty());

		Map<String, Object> styles = new HashMap<>();
		styles.put("0", "사과");
		styles.put("1", "내 컴퓨터");
		styles.put("2", "저는 진짜 힘들때까진 계속 코딩 하는 편이에요.");
		styles.put("3", "시간을 정해서 돌아간다.");
		styles.put("4", "밥먹고 더할까요?");
		styles.put("5", new LinkedHashMap<String, String>());
		styles.put("6", new LinkedHashMap<String, String>());
		styles.put("7", "test");

		assertThatThrownBy(() -> surveyService.saveStyle(styles, new SessionUser(new User())))
				.isInstanceOf(UserNotFoundException.class)
				.hasMessageContaining(String.format(USER_NOT_FOUND, "null"));
	}

	@Test
	public void findOptionalByUser() {
		surveyService.findOptionalByUser(new SessionUser(new User()));
		verify(surveyeeRepository).findByLogin(any());
	}

	@Test
	public void findByUser() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.of(Surveyee.builder().build()));

		surveyService.findByUser(new SessionUser(new User()));
		verify(surveyeeRepository).findByLogin(any());
	}

	@Test
	public void findByUserWhenNoUser() {
		when(surveyeeRepository.findByLogin(any()))
				.thenReturn(Optional.empty());
		assertThatThrownBy(() -> surveyService.findByUser(new SessionUser(new User())))
				.isInstanceOf(UserNotFoundException.class)
				.hasMessageContaining(String.format(USER_NOT_FOUND, "null"));
	}

	@Test
	public void findByLogin() {
		String login = "login";
		when(surveyeeRepository.findByLogin(login))
				.thenReturn(Optional.of(Surveyee.builder().build()));
		surveyService.findByLogin(login);
		verify(surveyeeRepository).findByLogin(login);
	}

	@Test
	public void findByLoginWhenNoUser() {
		String login = "login";
		when(surveyeeRepository.findByLogin(login))
				.thenReturn(Optional.empty());

		assertThatThrownBy(() -> surveyService.findByLogin(login))
				.isInstanceOf(UserNotFoundException.class)
				.hasMessageContaining(String.format(USER_NOT_FOUND, login));
	}
}
