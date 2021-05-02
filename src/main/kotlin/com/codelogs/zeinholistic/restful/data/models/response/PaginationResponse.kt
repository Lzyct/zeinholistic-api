package com.codelogs.zeinholistic.restful.data.models.response

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.response
 *    |-> PaginationResponse.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 30/04/21 🕰 23:16 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
data class PaginationResponse(
    val totalItems: Int,
    val currentPage: Int,
    val lastPage: Int
)