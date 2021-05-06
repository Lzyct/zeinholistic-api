package com.codelogs.zeinholistic.restful.controllers

import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.CreateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.ListMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.UpdateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.response.*
import com.codelogs.zeinholistic.restful.data.models.response.wrapper.BaseResponse
import com.codelogs.zeinholistic.restful.data.models.response.wrapper.BaseResponsePagination
import com.codelogs.zeinholistic.restful.data.models.response.wrapper.Diagnostic
import com.codelogs.zeinholistic.restful.data.models.response.wrapper.Pagination
import com.codelogs.zeinholistic.restful.services.MedicalRecordService
import com.codelogs.zeinholistic.restful.utils.Const
import com.codelogs.zeinholistic.restful.utils.lastPage
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.restful.controllers
 *    |-> MedicalRecordController.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 26/04/21 🕰 11:24 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

@RestController
class MedicalRecordController(val medicalRecordService: MedicalRecordService) {

    @PostMapping(
        value = ["api/medical-record"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun createMedicalRecord(body: CreateMedicalRecordRequest): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.create(body)
        return BaseResponse(
            diagnostic = Diagnostic(
                code = 200,
                status = Const.SUCCESS,
            ),
            data = medicalRecordResponse
        )
    }

    @GetMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getMedicalRecord(@PathVariable("idMedicalRecord") id: Int): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.get(id)
        return BaseResponse(
            diagnostic = Diagnostic(
                code = 200,
                status = Const.SUCCESS,
            ),
            data = medicalRecordResponse
        )
    }


    @PutMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun updateMedicalRecord(
        @PathVariable("idMedicalRecord") id: Int, body: UpdateMedicalRecordRequest
    ): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.update(id, body)
        return BaseResponse(
            diagnostic = Diagnostic(
                code = 200,
                status = Const.SUCCESS,
            ),
            data = medicalRecordResponse
        )
    }

    @DeleteMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteMedicalRecord(@PathVariable(value = "idMedicalRecord") id: Int): BaseResponse<Int> {
        medicalRecordService.delete(id)
        return BaseResponse(
            diagnostic = Diagnostic(
                code = 200,
                status = Const.SUCCESS,
            ),
            data = id
        )
    }

    @GetMapping(
        value = ["api/medical-records"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun listMedicalRecord(
        @RequestParam(value = "idPatient") idPatient: String,
        @RequestParam(value = "size", defaultValue = "20") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): BaseResponsePagination<List<MedicalRecordResponse>> {
        val request = ListMedicalRecordRequest(
            size = size,
            page = page,
            idPatient = idPatient
        )
        val (medicalRecordResponses, pagination) = medicalRecordService.list(request)
        return BaseResponsePagination(
            diagnostic = Diagnostic(
                code = 200,
                status = Const.SUCCESS,
            ),
            data = medicalRecordResponses,
            page = Pagination(
                totalItems = pagination.numberOfElements,
                currentPage = pagination.number,
                lastPage = pagination.lastPage()
            )
        )
    }

}