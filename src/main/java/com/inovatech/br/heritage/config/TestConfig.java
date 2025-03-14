package com.inovatech.br.heritage.config;

import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.model.entities.User;
import com.inovatech.br.heritage.model.enums.UserRole;
import com.inovatech.br.heritage.repository.HeritageRepository;
import com.inovatech.br.heritage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private HeritageRepository heritageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("allan");
        user1.setUserRole(UserRole.ADMIN);
        user1.setEmail("allan@gmail.com");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setUsername("mello");
        user2.setUserRole(UserRole.USER);
        user2.setEmail("mello@gmail.com");
        user2.setPassword("123456");

        userRepository.save(user1);
        userRepository.save(user2);

        Heritage heritage1 = new Heritage();
        heritage1.setName("CHINAMATE");
        heritage1.setCode("APEC 9895");
        heritage1.setCategory("TABLET");
        heritage1.setLocation("inovatech");
        heritage1.setCreateBy(user1);
        heritage1.setModifiedBy(user1);

        heritageRepository.save(heritage1);
    }
}
