package com.woowa.supp.domain.surveyee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyeeRepository extends JpaRepository<Surveyee, Long> {

	Optional<Surveyee> findByLogin(String login);
}
