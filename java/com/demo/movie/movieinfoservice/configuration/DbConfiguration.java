package com.demo.movie.movieinfoservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties("db")
public class DbConfiguration {
	private String connection;
	private String host;
	private int port;
}
