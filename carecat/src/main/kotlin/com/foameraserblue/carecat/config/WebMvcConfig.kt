package com.foameraserblue.carecat.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * 프론트와의 cors 오류를 임시적으로 모든 origin에 대해 개방
 * Todo: 실제 서비스 환경에서는 특정 ip와 port만 개방해야함.
 */
@Configuration
class WebMvcConfig : WebMvcConfigurer {
    val maxAge: Long = 3000

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "OPTIONS")
            .allowedHeaders("*")
//            .allowCredentials(true)
            .maxAge(maxAge)
    }
}