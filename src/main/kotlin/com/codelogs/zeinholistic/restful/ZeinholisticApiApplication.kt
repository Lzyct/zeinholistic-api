package com.codelogs.zeinholistic.restful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*
import javax.annotation.PostConstruct


@SpringBootApplication
@ComponentScan
class ZeinholisticApiApplication {

    // Override allow origin to url client to fix CORS
    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
            }
        }
    }

    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"))
        println("Spring boot application running in UTC timezone :" + Date())
    }
}

fun main(args: Array<String>) {
    runApplication<ZeinholisticApiApplication>(*args)
}