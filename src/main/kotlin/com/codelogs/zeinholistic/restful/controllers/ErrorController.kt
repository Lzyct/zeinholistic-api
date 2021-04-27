package com.codelogs.zeinholistic.restful.controllers

import com.codelogs.zeinholistic.restful.data.models.response.BaseResponse
import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import static.Strings
import javax.validation.ConstraintViolationException

/**
 **********************************************
 *  zeinholistic-api
 *  |-> com.codelogs.zeinholistic.restful.controllers
 *    |-> ErrorController.kt
 * --------------------------------------------
 * Created by Mudassir 🧑🏻‍💻
 * on 📅 26/04/21 🕰 11:49 with ❤️
 * email : hey.mudassir@gmail.com
 * github : https://www.github.com/ukieTux
 **********************************************
 * © 2021 | All Right Reserved
 */

@RestControllerAdvice
class ErrorController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): BaseResponse<String> {
        return BaseResponse(
            code = HttpStatus.BAD_REQUEST.value(),
            status = Strings.ERROR,
            data = constraintViolationException.message ?: Strings.ERROR
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException): BaseResponse<String> {
        return BaseResponse(
            code = HttpStatus.NOT_FOUND.value(),
            status = Strings.ERROR,
            data = Strings.NOT_FOUND
        )
    }
}