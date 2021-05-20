package com.codelogs.zeinholistic.restful.repositories

import com.codelogs.zeinholistic.restful.data.entities.Patient
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.repositories
 *    |-> PatientRepository.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:18 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
interface PatientRepository : JpaRepository<Patient, String> {
    fun findByNameContaining(name: String, pageable: Pageable): Page<Patient>

    fun findByNameAndSexContaining(name: String, sex: String, pageable: Pageable): Page<Patient>

    fun findBySexContaining(sex: String, pageable: Pageable): Page<Patient>
}