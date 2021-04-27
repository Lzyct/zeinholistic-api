package com.codelogs.zeinholistic.restful.controllers

import com.codelogs.zeinholistic.restful.data.models.request.patient.CreatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.ListPatientRequest
import com.codelogs.zeinholistic.restful.data.models.request.patient.UpdatePatientRequest
import com.codelogs.zeinholistic.restful.data.models.response.BaseResponse
import com.codelogs.zeinholistic.restful.data.models.response.PatientResponse
import com.codelogs.zeinholistic.restful.services.PatientService
import org.springframework.web.bind.annotation.*
import static.Strings

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
        produces = [Strings.APP_JSON],
        consumes = [Strings.APP_JSON]
    )
    fun createPatient(@RequestBody body: CreatePatientRequest): BaseResponse<PatientResponse> {
        val patientResponse = patientService.create(body)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = patientResponse
        )
    }

    @GetMapping(
        value = ["api/patient/{idPatient}"],
        produces = [Strings.APP_JSON]
    )
    fun getPatient(@PathVariable("idPatient") id: String): BaseResponse<PatientResponse> {
        val patientResponse = patientService.get(id)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = patientResponse
        )
    }


    @PutMapping(
        value = ["api/patient/{idPatient}"],
        produces = [Strings.APP_JSON],
        consumes = [Strings.APP_JSON]
    )
    fun updatePatient(
        @PathVariable("idPatient") id: String, @RequestBody body: UpdatePatientRequest
    ): BaseResponse<PatientResponse> {
        val patientResponse = patientService.update(id, body)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = patientResponse
        )
    }

    @DeleteMapping(
        value = ["api/patient/{idPatient}"],
        produces = [Strings.APP_JSON]
    )
    fun deletePatient(@PathVariable(value = "idPatient") id: String): BaseResponse<String> {
        patientService.delete(id)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = id
        )
    }

    @GetMapping(
        value = ["api/patients"],
        produces = [Strings.APP_JSON]
    )
    fun listPatient(
        @RequestParam(value = "size", defaultValue = "20") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): BaseResponse<List<PatientResponse>> {
        val request = ListPatientRequest(size = size, page = page)
        val patientResponses = patientService.list(request)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = patientResponses
        )
    }

}