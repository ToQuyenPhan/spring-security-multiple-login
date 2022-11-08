package com.example.demo.database;

import com.example.demo.Role;
import com.example.demo.entity.User;
import com.example.demo.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    private IUserRepository repo;

    public DatabaseLoader(IUserRepository repo) {
        this.repo = repo;
    }

    @Bean
    public CommandLineRunner initializeDatabase(){
        return args -> {
            User user1 = new User("quyen1230@gmail.com", "123456", Role.ADMIN);
            User user2 = new User("quyenlh8888@gmail.com", "123456", Role.ADMIN);
            User user3 = new User("quyenlh111@gmail.com", "123456", Role.USER);
            User user4 = new User("quyenlh000@gmail.com", "123456", Role.USER);
            repo.saveAll(List.of(user1, user2, user3, user4));
            System.out.println("Database initialized.");
        };
    }
}
