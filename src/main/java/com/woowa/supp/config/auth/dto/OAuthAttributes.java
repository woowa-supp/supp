package com.woowa.supp.config.auth.dto;

import java.util.Map;

import com.woowa.supp.domain.user.Role;
import com.woowa.supp.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private final Map<String, Object> attributes;
	private final String nameAttributeKey;
	private final String name;
	private final String login;

	@Builder
	public OAuthAttributes(
		Map<String, Object> attributes, String nameAttributeKey, String name, String login) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.login = login;
	}

	public static OAuthAttributes of(String userNameAttributeName, Map<String, Object> attributes) {
		return ofGithub(userNameAttributeName, attributes);
	}

	private static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
		                      .name((String)attributes.get("name"))
		                      .login((String)attributes.get("login"))
		                      .attributes(attributes)
		                      .nameAttributeKey(userNameAttributeName)
		                      .build();
	}

	public User toEntity() {
		return User.builder()
		           .name(name)
		           .login(login)
		           .role(Role.USER)
		           .build();
	}
}

