package com.codelogs.zeinholistic.restful.services

import com.codelogs.zeinholistic.restful.data.models.request.patient.CreatePatientRequestRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.UpdatePatientRequestRequest
import com.codelogs.zeinholistic.restful.data.models.response.PatientResponse

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.services
 *    |-> PatientServices.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:21 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
interface PatientService {

    fun create(request: CreatePatientRequestRequest): PatientResponse

    fun get(id: String): PatientResponse

    fun update(id: String, request: UpdatePatientRequestRequest): PatientResponse

    fun delete(id: String)

    fun list()
}