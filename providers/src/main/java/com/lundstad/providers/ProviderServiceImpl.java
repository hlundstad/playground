package com.lundstad.providers;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderServiceImpl implements ProviderService {
    private static int i=0;
    private static final Map<Integer, Provider> providerRepo = new HashMap<>();


    static {
        setupRepo();
    }

    public static void setupRepo(){
        Provider a = new Provider(++i,"Peter","Olsen");
        providerRepo.put(a.getId(), a);
        Provider b = new Provider(++i,"Donald","Trump");
        providerRepo.put(b.getId(), b);
        Provider c = new Provider(++i,"Joe","Biden");
        providerRepo.put(c.getId(), c);

    }

    @Override
    public void createProvider(Provider provider) {
        providerRepo.put(provider.getId(), provider);
    }

    @Override
    public void updateProvider(int id, Provider product) {

    }

    @Override
    public void deleteProvider(int id) {

    }

    @Override
    public Collection<Provider> getProviders() {
        return providerRepo.values();
    }

    @Override
    public Provider getProvider(int id) {
        return providerRepo.get(id);
    }

    public static int getCounter(){
        return i;
    }
}
