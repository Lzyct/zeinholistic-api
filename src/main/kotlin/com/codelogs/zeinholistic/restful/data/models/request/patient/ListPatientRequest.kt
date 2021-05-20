package com.codelogs.zeinholistic.restful.data.models.request.patient

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.request.patient
 *    |-> ListPatientRequest.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:38 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
data class ListPatientRequest(
    val q: String,
    val page: Int,
    val size: Int,
    val filter: String,
    val sex: String,
)
