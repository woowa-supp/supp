package com.woowa.supp.config.auth.dto;

import java.io.Serializable;

import com.woowa.supp.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private final String name;
	private final String login;

	public SessionUser(User user) {
		this.name = user.getName();
		this.login = user.getLogin();
	}
}
