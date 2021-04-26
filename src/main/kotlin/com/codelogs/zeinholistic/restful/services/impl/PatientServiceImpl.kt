package com.codelogs.zeinholistic.restful.services.impl

import com.codelogs.zeinholistic.restful.data.entities.Patient
import com.codelogs.zeinholistic.restful.data.models.request.patient.CreatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.ListPatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.UpdatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.response.PatientResponse
import com.codelogs.zeinholistic.restful.error.NotFoundException
import com.codelogs.zeinholistic.restful.repositories.PatientRepository
import com.codelogs.zeinholistic.restful.services.PatientService
import com.codelogs.zeinholistic.restful.utils.Validation
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

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

    override fun create(request: CreatePatientRequest): PatientResponse {
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
        val patient = findByIdOrNotFound(id)
        return convertToPatientResponse(patient)
    }

    override fun update(id: String, request: UpdatePatientRequest): PatientResponse {
        val patient = findByIdOrNotFound(id)
        validation.validate(request)

        patient.apply {
            name = request.name
            sex = request.sex
            address = request.address
            phoneNumber = request.phoneNumber
            birthday = request.birthday
        }
        patientRepository.save(patient)

        return convertToPatientResponse(patient)
    }

    override fun delete(id: String) {
        val patient = findByIdOrNotFound(id)
        patientRepository.delete(patient)
    }

    override fun list(request: ListPatientRequest): List<PatientResponse> {
        val page = patientRepository.findAll(PageRequest.of(request.page, request.size))
        val patients: List<Patient> = page.get().collect(Collectors.toList())
        return patients.map { patient -> convertToPatientResponse(patient) }
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