package com.security.documentversioncontrol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MySQLConnectionTest {
    @Bean
    CommandLineRunner run(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                String result = jdbcTemplate.queryForObject("SELECT VERSION()", String.class);
                System.out.println("✅ Connected to MySQL! Version: " + result);
            } catch (Exception e) {
                System.out.println("❌ Failed to connect: " + e.getMessage());
            }
        };
    }
}
