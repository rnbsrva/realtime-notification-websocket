package com.akerke.notification.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Slf4j
@EnableRedisRepositories
@Configuration(proxyBeanMethods = false)
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String redisHost;
    @Value("${spring.data.redis.port}")
    private Integer redisPort;

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        var redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                redisHost,
                redisPort
        );

        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    <K, V> RedisTemplate<K, V> reactiveStringRedisTemplate(
            @Qualifier("redisConnectionFactory") RedisConnectionFactory fct
    ) {
        var template = new RedisTemplate<K,V>();

        template.setConnectionFactory(fct);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }

}