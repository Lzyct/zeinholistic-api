package com.codelogs.zeinholistic.restful.data.models.response

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.response
 *    |-> BaseResponse.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:53 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
data class BaseResponsePagination<T>(
    val diagnostic: Diagnostic,
    val data: T,
    val page: Pagination
)

