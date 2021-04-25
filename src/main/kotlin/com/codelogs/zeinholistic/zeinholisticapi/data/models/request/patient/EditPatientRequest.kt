package com.codelogs.zeinholistic.zeinholisticapi.data.models.request.patient


/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.zeinholisticapi.data.models.request.patient
 *    |-> CreatePatientRequest.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 16:53 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class EditPatientRequest(
    val id: String,
    val name: String,
    val sex: String,
    val dateBirth: String,
    val address: String,
    val phoneNumber: String,
    val updatedAt: String
)