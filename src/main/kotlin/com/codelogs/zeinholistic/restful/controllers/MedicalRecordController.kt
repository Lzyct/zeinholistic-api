package com.codelogs.zeinholistic.restful.controllers

import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.CreateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.ListMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.request.medicalrecord.UpdateMedicalRecordRequest
import com.codelogs.zeinholistic.restful.data.models.response.BaseResponse
import com.codelogs.zeinholistic.restful.data.models.response.MedicalRecordResponse
import com.codelogs.zeinholistic.restful.services.MedicalRecordService
import org.springframework.web.bind.annotation.*
import static.Strings

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
        produces = [Strings.APP_JSON],
        consumes = [Strings.APP_JSON]
    )
    fun createMedicalRecord(@RequestBody body: CreateMedicalRecordRequest): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.create(body)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = medicalRecordResponse
        )
    }

    @GetMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        produces = [Strings.APP_JSON]
    )
    fun getMedicalRecord(@PathVariable("idMedicalRecord") id: Int): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.get(id)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = medicalRecordResponse
        )
    }


    @PutMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        produces = [Strings.APP_JSON],
        consumes = [Strings.APP_JSON]
    )
    fun updateMedicalRecord(
        @PathVariable("idMedicalRecord") id: Int, @RequestBody body: UpdateMedicalRecordRequest
    ): BaseResponse<MedicalRecordResponse> {
        val medicalRecordResponse = medicalRecordService.update(id, body)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = medicalRecordResponse
        )
    }

    @DeleteMapping(
        value = ["api/medical-record/{idMedicalRecord}"],
        produces = [Strings.APP_JSON]
    )
    fun deleteMedicalRecord(@PathVariable(value = "idMedicalRecord") id: Int): BaseResponse<Int> {
        medicalRecordService.delete(id)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = id
        )
    }

    @GetMapping(
        value = ["api/medical-records"],
        produces = [Strings.APP_JSON]
    )
    fun listMedicalRecord(
        @RequestParam(value = "size", defaultValue = "20") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): BaseResponse<List<MedicalRecordResponse>> {
        val request = ListMedicalRecordRequest(size = size, page = page)
        val medicalRecordResponses = medicalRecordService.list(request)
        return BaseResponse(
            code = 200,
            status = Strings.SUCCESS,
            data = medicalRecordResponses
        )
    }

}