package com.codelogs.zeinholistic.restful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer





@SpringBootApplication
class ZeinholisticApiApplication{

    // Override allow origin to url client to fix CORS
    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8181")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ZeinholisticApiApplication>(*args)
}