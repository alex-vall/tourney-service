package com.vall.tourneyservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;

/**
 * Created by alex.volosatov
 * Creation date 12/5/2018.
 */
@Configuration
@EnableJdbcRepositories(basePackages = "com.vall.tourneyservice.repository")
@Import(JdbcConfiguration.class)
public class RepositoryConfiguration {
}
