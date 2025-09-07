package com.quizapp.Quizzing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class QuizzingApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzingApplication.class, args);
	}

    @Bean
    public PlatformTransactionManager transactionManager(MongoDatabaseFactory dbfactory) {
        return new MongoTransactionManager(dbfactory);

    }

}
