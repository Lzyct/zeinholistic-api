package com.codelogs.zeinholistic.restful.services.impl

import com.codelogs.zeinholistic.restful.data.entities.MedicalRecord
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.CreateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.ListMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.UpdateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.response.MedicalRecordResponse
import com.codelogs.zeinholistic.restful.error.NotFoundException
import com.codelogs.zeinholistic.restful.repositories.MedicalRecordRepository
import com.codelogs.zeinholistic.restful.services.MedicalRecordService
import com.codelogs.zeinholistic.restful.utils.Validation
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
class MedicalRecordServiceImpl(
    val medicalRecordRepository: MedicalRecordRepository,
    val validation: Validation
) : MedicalRecordService {

    override fun create(request: CreateMedicalRecordRequest): MedicalRecordResponse {
        validation.validate(request)

        val medicalRecord = MedicalRecord(
            id = 0,
            idPatient = request.idPatient!!,
            mainComplaint = request.mainComplaint!!,
            additionalComplaint = request.additionalComplaint ?: "",
            historyOfDisease = request.historyOfDisease ?: "",
            checkUpResult = request.checkUpResult ?: "",
            conclusionDiagnosis = request.conclusionDiagnosis ?: "",
            suggestion = request.suggestion ?: "",
            examiner = request.examiner ?: "",
            createdAt = Date(),
            updatedAt = null,
        )
        medicalRecordRepository.save(medicalRecord)
        return convertToMedicalRecordResponse(medicalRecord)
    }

    override fun get(id: Int): MedicalRecordResponse {
        val medicalRecord = findByIdOrNotFound(id)
        return convertToMedicalRecordResponse(medicalRecord)
    }

    override fun update(id: Int, request: UpdateMedicalRecordRequest): MedicalRecordResponse {
        val medicalRecord = findByIdOrNotFound(id)
        validation.validate(request)

        medicalRecord.apply {
            mainComplaint = request.mainComplaint!!
            additionalComplaint = request.additionalComplaint ?: ""
            historyOfDisease = request.historyOfDisease ?: ""
            checkUpResult = request.checkUpResult ?: ""
            conclusionDiagnosis = request.conclusionDiagnosis ?: ""
            suggestion = request.suggestion ?: ""
            examiner = request.examiner ?: ""
            updatedAt = Date()
        }
        medicalRecordRepository.save(medicalRecord)

        return convertToMedicalRecordResponse(medicalRecord)
    }

    override fun delete(id: Int) {
        val medicalRecord = findByIdOrNotFound(id)
        medicalRecordRepository.delete(medicalRecord)
    }

    override fun list(request: ListMedicalRecordRequest): Pair<List<MedicalRecordResponse>, Page<MedicalRecord>> {
        val page =
            if (request.q.isEmpty()) medicalRecordRepository.findAllByIdPatient(
                request.idPatient,
                PageRequest.of(request.page, request.size, Sort.by(Sort.Direction.DESC, "createdAt"))
            )
            else medicalRecordRepository.findAllByIdPatientAndMainComplaintContaining(
                request.idPatient,
                request.q,
                PageRequest.of(request.page, request.size, Sort.by(Sort.Direction.DESC, "createdAt"))
            )
        val medicalRecords: List<MedicalRecord> = page.get().collect(Collectors.toList())
        return Pair(medicalRecords.map { medicalRecord -> convertToMedicalRecordResponse(medicalRecord) }, page)
    }

    fun findByIdOrNotFound(id: Int): MedicalRecord {
        return medicalRecordRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    fun convertToMedicalRecordResponse(medicalRecord: MedicalRecord): MedicalRecordResponse {
        return MedicalRecordResponse(
            id = medicalRecord.id,
            idPatient = medicalRecord.idPatient,
            mainComplaint = medicalRecord.mainComplaint,
            additionalComplaint = medicalRecord.additionalComplaint,
            historyOfDisease = medicalRecord.historyOfDisease,
            checkUpResult = medicalRecord.checkUpResult,
            conclusionDiagnosis = medicalRecord.conclusionDiagnosis,
            suggestion = medicalRecord.suggestion,
            examiner = medicalRecord.examiner,
            createdAt = medicalRecord.createdAt,
            updatedAt = medicalRecord.updatedAt,
        )
    }
}