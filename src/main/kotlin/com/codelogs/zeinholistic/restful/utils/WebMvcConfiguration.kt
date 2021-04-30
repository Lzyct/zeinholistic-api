package com.codelogs.zeinholistic.restful.utils

import org.springframework.context.annotation.Configuration
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.utils
 *    |-> WebMvcConfiguration.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 30/04/21 🕰 23:35 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

@Configuration
open class WebMvcConfiguration : WebMvcConfigurer {
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        val resolver = PageableHandlerMethodArgumentResolver()
        resolver.setOneIndexedParameters(true)
        resolvers.add(resolver)
    }
}