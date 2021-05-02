package com.codelogs.zeinholistic.restful.data.models.request.medicalrecord

import javax.validation.constraints.NotBlank

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.request.medicalrecord
 *    |-> CreateMedicalRecord.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 17:00 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class UpdateMedicalRecordRequest(
    @field:NotBlank
    val mainComplaint: String?,

    val additionalComplaint: String? = "",
    val historyOfDisease: String? = "",
    val checkUpResult: String? = "",
    val conclusionDiagnosis: String? = "",
    val suggestion: String? = "",
    val examiner: String? = "",
)