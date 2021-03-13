package com.lundstad.providers;

import com.lundstad.providers.db.tables.tables.daos.ProviderDao;
import com.lundstad.providers.db.tables.tables.pojos.Provider;
import com.lundstad.providers.db.tables.tables.records.ProviderRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Collection;

import static com.lundstad.providers.db.tables.tables.Provider.PROVIDER;

@Service
public class ProviderServiceImpl implements ProviderService {
    final TransactionTemplate transactionTemplate;
    private final ProviderDao providerDao;
    private final DSLContext dsl;

    public ProviderServiceImpl(DSLContext dsl, Configuration jooqConfiguration,
                               TransactionTemplate transactionTemplate) {
        this.providerDao = new ProviderDao(jooqConfiguration);
        this.dsl = dsl;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Provider createProvider(Provider newProvider) {
        ProviderRecord rc = dsl.insertInto(PROVIDER)
                .set(PROVIDER.FIRSTNAME, newProvider.getFirstname())
                .set(PROVIDER.LASTNAME, newProvider.getLastname())
                .set(PROVIDER.EMAIL, newProvider.getEmail())
                .returning()
                .fetchOne();
        return rc.into(Provider.class);
    }

    @Override
    public void updateProvider(int id, Provider product) {
    }

    @Override
    public void deleteProvider(int id) {
    }

    @Override
    public Collection<Provider> getProviders() {
        return this.providerDao.findAll();
    }

    @Override
    public Provider getProvider(int id) {
        return this.providerDao.findById(id);
    }
}
