package com.arboleda.arboledarecharge.db;

import com.arboleda.arboledarecharge.model.Account;
import com.arboleda.arboledarecharge.model.Phone;
import com.arboleda.arboledarecharge.model.TelecomProvider;
import com.arboleda.arboledarecharge.model.User;
import com.arboleda.arboledarecharge.repository.AccountRepository;
import com.arboleda.arboledarecharge.repository.PhoneRepository;
import com.arboleda.arboledarecharge.repository.TelecomProviderRepository;
import com.arboleda.arboledarecharge.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(
            TelecomProviderRepository telecomProviderRepository,
            PhoneRepository phoneRepository,
            UserRepository userRepository,
            AccountRepository accountRepository
    ) {
        return args -> {
            var claro = new TelecomProvider(1L, "PEN", "Claro");
            telecomProviderRepository.save(claro);
            phoneRepository.save(new Phone("999888777", claro));
            phoneRepository.save(new Phone("930866115", claro));
            var user1 = new User(2L, "Juan Perez", "Password");
            userRepository.save(user1);
            accountRepository.save(new Account(3L, "PEN", user1, 500.0));
        };
    }
}
