package com.developlee.springbootmessageconverter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author liululee
 * @desc 消息转换配置
 * @since 2019/5/28 0028
 **/
@Configuration
public class MessageConverterConfigure implements WebMvcConfigurer {

    // Spring Boot不需要这么写？？？Yes, 感谢自动装配..只要引入Jackson依赖就好了
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.xml();
//        builder.indentOutput(true);
//        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.build()));
//    }
}
