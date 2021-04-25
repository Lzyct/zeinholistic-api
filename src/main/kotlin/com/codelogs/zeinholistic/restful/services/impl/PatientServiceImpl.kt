package com.codelogs.zeinholistic.restful.services.impl

import com.codelogs.zeinholistic.restful.data.entities.Patient
import com.codelogs.zeinholistic.restful.data.models.request.patient.CreatePatientRequestRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.UpdatePatientRequestRequest
import com.codelogs.zeinholistic.restful.data.models.response.PatientResponse
import com.codelogs.zeinholistic.restful.error.NotFoundException
import com.codelogs.zeinholistic.restful.repositories.PatientRepository
import com.codelogs.zeinholistic.restful.services.PatientService
import com.codelogs.zeinholistic.restful.utils.Validation
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.services.impl
 *    |-> PatienServiceImplement.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:54 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

@Service
class PatientServiceImpl(
    val patientRepository: PatientRepository,
    val validation: Validation
) : PatientService {

    override fun create(request: CreatePatientRequestRequest): PatientResponse {
        validation.validate(request)

        val patient = Patient(
            id = "${System.currentTimeMillis()}-${request.name}",
            name = request.name,
            sex = request.sex,
            birthday = request.birthday,
            address = request.address,
            phoneNumber = request.phoneNumber,
            createdAt = Date(),
            updatedAt = null
        )
        patientRepository.save(patient)
        return convertToPatientResponse(patient)
    }

    override fun get(id: String): PatientResponse {
        val product = findByIdOrNotFound(id)
        return convertToPatientResponse(product)
    }

    override fun update(id: String, request: UpdatePatientRequestRequest): PatientResponse {
    }

    override fun delete(id: String) {
    }

    override fun list() {
    }

    fun findByIdOrNotFound(id: String): Patient {
        return patientRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    fun convertToPatientResponse(patient: Patient): PatientResponse {
        return PatientResponse(
            id = patient.id,
            name = patient.name,
            sex = patient.sex,
            birthday = patient.birthday,
            address = patient.address,
            phoneNumber = patient.phoneNumber,
            createdAt = patient.createdAt,
            updatedAt = patient.updatedAt,
        )
    }
}