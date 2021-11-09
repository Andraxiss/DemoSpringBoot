package com.amigosCode.springBootTutorial.Config;

import com.amigosCode.springBootTutorial.Model.Student;
import com.amigosCode.springBootTutorial.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student me = new Student("Me","me@gmail.com", LocalDate.of(1999,06,30));
            Student you = new Student("You","You@gmail.com", LocalDate.of(2005,06,30));
            studentRepository.saveAll(
                    List.of(me,you)
            );
        };
    }
}
