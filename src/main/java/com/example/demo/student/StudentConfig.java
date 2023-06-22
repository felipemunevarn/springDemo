package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mary",
                    "maanraca@gmail.com",
                    LocalDate.of(1982,Month.JANUARY,23)
			);
            Student alex = new Student(
                    "Alex",
                    "alexis@hotmail.com",
                    LocalDate.of(2015,Month.JANUARY,7)
			);
            repository.saveAll(
                List.of(mariam, alex)
            );
        };
    }
}
