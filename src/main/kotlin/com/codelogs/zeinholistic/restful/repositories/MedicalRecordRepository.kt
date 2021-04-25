package com.codelogs.zeinholistic.restful.repositories

import com.codelogs.zeinholistic.restful.data.entities.MedicalRecord
import org.springframework.data.jpa.repository.JpaRepository

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.repositories
 *    |-> MedicalRecordRepository.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 22:19 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
interface MedicalRecordRepository : JpaRepository<MedicalRecord, Int> {
}