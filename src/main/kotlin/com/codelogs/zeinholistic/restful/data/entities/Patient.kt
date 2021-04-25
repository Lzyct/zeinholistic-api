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
 *    |-> Patient.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 16:39 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
@Entity
@Table(name = "patient")
data class Patient(
    @Id
    val id: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "sex")
    val sex: String,
    @Column(name = "birthday")
    val birthday: String,
    @Column(name = "address")
    val address: String,
    @Column(name = "phone_number")
    val phoneNumber: String,
    @Column(name = "createdAt")
    override val createdAt: Date,
    @Column(name = "updatedAt")
    override val updatedAt: Date?,
    ) : BaseEntity