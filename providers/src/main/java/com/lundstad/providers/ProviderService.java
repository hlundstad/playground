package com.lundstad.providers;

import com.lundstad.providers.db.tables.tables.pojos.Provider;

import java.util.Collection;

public interface ProviderService {
    Provider createProvider(Provider provider);

    void updateProvider(int id, Provider provider);

    void deleteProvider(int id);

    Collection<Provider> getProviders();

    Provider getProvider(int id);

}
