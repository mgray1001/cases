package com.cases.configuration;

import com.cases.CasesStart;
import com.cases.model.Case;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;


/**
 * Created by mario on 7/2/14.
 */
//@PropertySource("classpath:/redis.properties")
//@Profile("default")
@Configuration
@EnableMongoRepositories( basePackageClasses = { com.cases.repository.UserProfileMongoRepository.class } )
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class CaseConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(CaseConfiguration.class, args);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        jcf.setUsePool( false);

        return jcf;
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<String, Case> redisTemplate(RedisConnectionFactory connectionFactory) {
                RedisTemplate<String, Case> redisTemplate = new RedisTemplate<String,Case>();
        redisTemplate.setConnectionFactory( connectionFactory);
        return redisTemplate;

    }

}
