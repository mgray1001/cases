package com.cases.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

/**
 * Created by mario on 7/23/14.
 */
@Configuration
public class SocialConfiguration {

    @Bean
    Facebook facebook(@Value("${cases.social.facebook.appId}") String appId,
                      @Value("${cases.social.facebook.appSecret}") String appSecret) {
        return new FacebookTemplate(appId + '|' + appSecret);
    }

}
