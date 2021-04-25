package com.codelogs.zeinholistic.restful.data.models.response

import java.util.*

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.response
 *    |-> MedicalRecordResponse.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:16 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class MedicalRecordResponse(
    val id: Int,
    val idPatient: String,
    val mainComplaint: String,
    val additionalComplaint: String,
    val historyOfDisease: String,
    val checkUpResult: String,
    val conclusionDiagnosis: String,
    val suggestion: String,
    val examiner: String,
    val createdAt: Date,
    val updatedAt: Date?,
)