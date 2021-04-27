package com.codelogs.zeinholistic.restful.services

import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.CreateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.ListMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.UpdateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.response.MedicalRecordResponse

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
interface MedicalRecordService {

    fun create(request: CreateMedicalRecordRequest): MedicalRecordResponse

    fun get(id: Int): MedicalRecordResponse

    fun update(id: Int, request: UpdateMedicalRecordRequest): MedicalRecordResponse

    fun delete(id: Int)

    fun list(request: ListMedicalRecordRequest): List<MedicalRecordResponse>
}