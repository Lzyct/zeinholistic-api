package com.codelogs.zeinholistic.restful.data.models.response

import java.util.*

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.response
 *    |-> PatientResponse.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:15 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class PatientResponse(
    val id: String,
    val name: String,
    val sex: String,
    val birthday: String,
    val address: String,
    val phoneNumber: String,
    val createdAt: Date,
    val updatedAt: Date?,
)