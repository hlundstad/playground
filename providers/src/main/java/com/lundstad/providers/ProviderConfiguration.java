package com.lundstad.providers;
import org.springframework.context.annotation.Bean;
import org.jooq.Configuration;
import com.lundstad.providers.db.tables.tables.daos.ProviderDao;

@org.springframework.context.annotation.Configuration
public class ProviderConfiguration {
    @Bean
    public ProviderDao employeeDao(Configuration jooqConfiguration) {
        return new ProviderDao(jooqConfiguration);
    }
}
