package com.codelogs.zeinholistic.restful.data.models.request.patient

import java.util.*
import javax.validation.constraints.NotBlank


/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.models.request.patient
 *    |-> CreatePatientRequest.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 16:53 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

data class UpdatePatientRequest(
    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val sex: String?,

    @field:NotBlank
    val birthday: Date?,

    @field:NotBlank
    val address: String?,

    @field:NotBlank
    val phoneNumber: String?,
)
