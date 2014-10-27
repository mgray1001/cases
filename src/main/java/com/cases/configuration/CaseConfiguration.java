package com.cases.configuration;

import com.cases.model.mongo.Forum;
import com.cases.repository.impl.mongo.CaseMongoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import javax.servlet.MultipartConfigElement;


/**
 * Created by mario on 7/2/14.
 */
//@Profile("default")
@Configuration
@EnableMongoRepositories( basePackageClasses = { CaseMongoRepository.class } )
@Import({RepositoryRestMvcConfiguration.class, AppConfiguration.class, SocialConfiguration.class})
@EnableAutoConfiguration( exclude = HibernateJpaAutoConfiguration.class )
@ComponentScan( basePackages = {"com.cases.controller"})
//@PropertySource("classpath:config/application.properties")
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
    public RedisTemplate<String, Forum> redisTemplate(RedisConnectionFactory connectionFactory) {
                RedisTemplate<String, Forum> redisTemplate = new RedisTemplate<String,Forum>();
        redisTemplate.setConnectionFactory( connectionFactory);
        return redisTemplate;

    }

    @Bean
    MultipartConfigElement  multipartConfigElement() {
        MultipartConfigFactory  factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1MB");
        factory.setMaxRequestSize("1MB");
        return factory.createMultipartConfig();
    }

}
