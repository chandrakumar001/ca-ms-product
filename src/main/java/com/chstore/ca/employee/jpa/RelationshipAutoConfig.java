package com.chstore.ca.employee.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class RelationshipAutoConfig {
	
	@Bean
	public AuditorAware<String> auditorAware() {

		return new SpringSecurityAuditorAware();
	}
	

}