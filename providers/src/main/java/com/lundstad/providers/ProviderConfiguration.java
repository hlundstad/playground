package com.lundstad.providers;

import com.lundstad.providers.db.tables.tables.daos.ProviderDao;
import org.jooq.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ProviderConfiguration {
    @Bean
    public ProviderDao employeeDao(Configuration jooqConfiguration) {
        return new ProviderDao(jooqConfiguration);
    }
}
