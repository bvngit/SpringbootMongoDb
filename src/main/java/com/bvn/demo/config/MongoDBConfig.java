package com.bvn.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bvn.demo.model.Student;
import com.bvn.demo.repositories.StudentRepository;

@EnableMongoRepositories(basePackageClasses = {StudentRepository.class})
@Configuration
public class MongoDBConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				studentRepository.save(new Student(3, "Cao Minh", 29, 4.7));	
				studentRepository.save(new Student(4, "Cao Quang", 39, 4.9));	
			}
		};
	}
}
