package com.codelogs.zeinholistic.restful.data.entities

import java.util.*
import javax.persistence.*

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "id_patient")
    val idPatient: String,
    @Column(name = "main_complaint")
    var mainComplaint: String,
    @Column(name = "additional_complaint")
    var additionalComplaint: String,
    @Column(name = "history_of_disease")
    var historyOfDisease: String,
    @Column(name = "check_up_result")
    var checkUpResult: String,
    @Column(name = "conclusion_diagnosis")
    var conclusionDiagnosis: String,
    @Column(name = "suggestion")
    var suggestion: String,
    @Column(name = "examiner")
    var examiner: String,
    @Column(name = "createdAt")
    override val createdAt: Date,
    @Column(name = "updatedAt")
    override var updatedAt: Date?,

    ) : BaseEntity
