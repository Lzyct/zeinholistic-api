package com.codelogs.zeinholistic.restful.data.models.request.medicalrecord

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.request.medicalrecord
 *    |-> ListMedicalRecordRequest.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:38 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class ListMedicalRecordRequest(
    val idPatient: String,
    val page: Int,
    val size: Int
)