package com.week5.homework.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan({"com.week5.homework.web"})
@EnableWebMvc
public class UmWebConfig implements WebMvcConfigurer {
    public UmWebConfig() {
        super();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter :
                converters) {
            if(converter instanceof final AbstractJackson2HttpMessageConverter jackson2HttpMessageConverter){
                jackson2HttpMessageConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                jackson2HttpMessageConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            }
        }
    }
}
