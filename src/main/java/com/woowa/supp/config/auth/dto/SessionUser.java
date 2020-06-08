package com.woowa.supp.config.auth.dto;

import java.io.Serializable;

import com.woowa.supp.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private String name;
	private String login;
	private String avatar;

	public SessionUser(User user) {
		this.name = user.getName();
		this.login = user.getLogin();
		this.avatar = user.getAvatar();
	}
}
