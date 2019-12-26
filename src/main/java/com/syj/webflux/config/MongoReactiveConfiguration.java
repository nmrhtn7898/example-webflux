package com.syj.webflux.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.syj.webflux.app.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoReactiveConfiguration {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://syj:1234@syj-tzrqs.mongodb.net/test?retryWrites=true&w=majority");
    }

    @Bean
    public SimpleReactiveMongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient) {
        return new SimpleReactiveMongoDatabaseFactory(mongoClient, "example");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(SimpleReactiveMongoDatabaseFactory mongoDatabaseFactory, MongoConverter converter) {
        return new ReactiveMongoTemplate(mongoDatabaseFactory, converter);
    }


}
