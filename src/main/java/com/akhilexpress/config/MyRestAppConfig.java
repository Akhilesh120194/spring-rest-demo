package com.akhilexpress.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc //activate validation,mapper etc .it helps us to set up necessary n=beans used for web application
@Configuration
@ComponentScan("com")
public class MyRestAppConfig {

}
