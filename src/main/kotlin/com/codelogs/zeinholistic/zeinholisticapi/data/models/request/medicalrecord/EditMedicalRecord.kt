package com.codelogs.zeinholistic.zeinholisticapi.data.models.request.medicalrecord

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.zeinholisticapi.data.models.request.medicalrecord
 *    |-> CreateMedicalRecord.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 17:00 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class EditMedicalRecord(
    val idPatient: String,
    val mainComplaint: String,
    val additionalComplaint: String? = "",
    val historyOfDisease: String? = "",
    val checkUpResult: String? = "",
    val conclusionDiagnosis: String? = "",
    val suggestion: String? = "",
    val examiner: String? = "",
    val updatedAt: String,
)