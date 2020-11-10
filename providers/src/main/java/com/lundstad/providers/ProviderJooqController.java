package com.lundstad.providers;

import  com.lundstad.providers.db.tables.tables.daos.ProviderDao;
import com.lundstad.providers.db.tables.tables.pojos.Provider;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.jooq.Configuration;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class ProviderJooqController {
    @Autowired
    private final ProviderDao providerDao;
    private final DSLContext dsl;
    private final TransactionTemplate transactionTemplate;

    public ProviderJooqController(DSLContext dsl, Configuration jooqConfiguration,
                                  TransactionTemplate transactionTemplate) {
        this.providerDao = new ProviderDao(jooqConfiguration);
        this.dsl = dsl;
        this.transactionTemplate = transactionTemplate;
    }

    @GetMapping("/listProviders")
    public List<Provider> employees() {
        return this.providerDao.findAll();
    }

    @Transactional
    @PostMapping("/newEmployee")
    public Provider newProvider(@RequestBody Provider newProvider) {
        Provider p = new Provider();
        p.setFirstname("Hege");
        p.setLastname("Lu");
        p.setEmail("asd@asdf.com");
        this.providerDao.insert(p);
        System.out.println(p.getId());
        return p;
    }

}
