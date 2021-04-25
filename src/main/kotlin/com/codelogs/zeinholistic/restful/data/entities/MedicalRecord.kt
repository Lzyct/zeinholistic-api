package com.codelogs.zeinholistic.restful.data.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.data.entities
 *    |-> MedicalRecord.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 16:44 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
@Entity()
@Table(name = "medical_record")
data class MedicalRecord(
    @Id
    val id: Int,
    @Column(name = "id_patient")
    val idPatient: String,
    @Column(name = "main_complaint")
    val mainComplaint: String,
    @Column(name = "additional_complaint")
    val additionalComplaint: String,
    @Column(name = "history_of_disease")
    val historyOfDisease: String,
    @Column(name = "check_up_result")
    val checkUpResult: String,
    @Column(name = "conclusion_diagnosis")
    val conclusionDiagnosis: String,
    @Column(name = "suggestion")
    val suggestion: String,
    @Column(name = "examiner")
    val examiner: String,
    @Column(name = "createdAt")
    override val createdAt: Date,
    @Column(name = "updatedAt")
    override val updatedAt: Date?,

    ) : BaseEntity
