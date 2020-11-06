package com.lundstad.providers;

import java.util.Collection;

public interface ProviderService {
    void createProvider(Provider product);

    void updateProvider(int id, Provider product);

    void deleteProvider(int id);

    Collection<Provider> getProviders();

    Provider getProvider(int id);

}
