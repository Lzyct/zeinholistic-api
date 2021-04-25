package com.codelogs.zeinholistic.zeinholisticapi.data.entities

import java.util.*

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.zeinholisticapi.data.entities
 *    |-> BaseEntity.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 25/04/21 🕰 16:38 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */
interface BaseEntity {
    abstract val createdAt: Date
    abstract val updatedAt: Date?
}