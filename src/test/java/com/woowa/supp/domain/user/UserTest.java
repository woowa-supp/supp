package com.woowa.supp.domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {

	@Test
	public void update() {
		User user = User.builder()
			.name("name")
			.login("login")
			.avatar("avatar")
			.role(Role.GUEST)
			.build();

		String updatedName = "test";

		user.update(updatedName);

		assertThat(user.getName()).isEqualTo(updatedName);
	}
}