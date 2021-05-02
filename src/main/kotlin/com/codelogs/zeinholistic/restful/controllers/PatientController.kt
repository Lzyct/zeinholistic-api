package com.codelogs.zeinholistic.restful.controllers

import com.codelogs.zeinholistic.restful.data.models.request.patient.CreatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.ListPatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.UpdatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.response.BaseResponse
import com.codelogs.zeinholistic.restful.data.models.response.BaseResponsePagination
import com.codelogs.zeinholistic.restful.data.models.response.PaginationResponse
import com.codelogs.zeinholistic.restful.data.models.response.PatientResponse
import com.codelogs.zeinholistic.restful.services.PatientService
import com.codelogs.zeinholistic.restful.utils.Const
import com.codelogs.zeinholistic.restful.utils.lastPage
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.restful.controllers
 *    |-> PatientController.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 26/04/21 🕰 11:24 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

@RestController
class PatientController(val patientService: PatientService) {

    @PostMapping(
        value = ["api/patient"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun createPatient(body: CreatePatientRequest): BaseResponse<PatientResponse> {
        val patientResponse = patientService.create(body)
        return BaseResponse(
            code = 200,
            status = Const.SUCCESS,
            data = patientResponse
        )
    }

    @GetMapping(
        value = ["api/patient/{idPatient}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getPatient(@PathVariable("idPatient") id: String): BaseResponse<PatientResponse> {
        val patientResponse = patientService.get(id)
        return BaseResponse(
            code = 200,
            status = Const.SUCCESS,
            data = patientResponse
        )
    }


    @PutMapping(
        value = ["api/patient/{idPatient}"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun updatePatient(
        @PathVariable("idPatient") id: String, body: UpdatePatientRequest
    ): BaseResponse<PatientResponse> {
        val patientResponse = patientService.update(id, body)
        return BaseResponse(
            code = 200,
            status = Const.SUCCESS,
            data = patientResponse
        )
    }

    @DeleteMapping(
        value = ["api/patient/{idPatient}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deletePatient(@PathVariable(value = "idPatient") id: String): BaseResponse<String> {
        patientService.delete(id)
        return BaseResponse(
            code = 200,
            status = Const.SUCCESS,
            data = id
        )
    }

    @GetMapping(
        value = ["api/patients"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun listPatient(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): BaseResponsePagination<List<PatientResponse>> {
        val request = ListPatientRequest(size = size, page = page)
        val (patientResponses, pagination) = patientService.list(request)
        return BaseResponsePagination(
            code = 200,
            status = Const.SUCCESS,
            data = patientResponses,
            page = PaginationResponse(
                totalItems = pagination.numberOfElements,
                currentPage = pagination.number,
                lastPage = pagination.lastPage()
            )
        )
    }

}