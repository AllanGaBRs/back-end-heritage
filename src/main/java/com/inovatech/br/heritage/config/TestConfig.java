package com.inovatech.br.heritage.config;

import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.repository.HeritageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private HeritageRepository heritageRepository;

    @Override
    public void run(String... args) throws Exception {

        Heritage heritage1 = new Heritage();
        heritage1.setName("CHINAMATE");
        heritage1.setCode("APEC 9895");
        heritage1.setCategory("TABLET");
        heritage1.setLocation("inovatech");

        heritageRepository.save(heritage1);
    }
}
