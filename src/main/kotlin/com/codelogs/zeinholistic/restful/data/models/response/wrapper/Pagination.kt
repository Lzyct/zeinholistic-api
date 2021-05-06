package com.codelogs.zeinholistic.restful.data.models.response.wrapper

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.restful.data.models.response
 *    |-> Pagination.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 06/05/21 🕰 14:29 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
data class Pagination(
    val totalItems: Int,
    val currentPage: Int,
    val lastPage: Int
)