package com.codelogs.zeinholistic.restful.utils

import org.springframework.data.domain.Page

/**
 **********************************************
 *  zeinholistic-restful
 *  |-> com.codelogs.zeinholistic.restful.utils
 *    |-> PageableExt.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 02/05/21 🕰 21:18 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

fun <T> Page<T>.lastPage(): Int = this.totalPages - 1