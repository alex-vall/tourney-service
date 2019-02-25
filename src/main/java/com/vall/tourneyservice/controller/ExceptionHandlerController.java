package com.vall.tourneyservice.controller;

import com.vall.tourneyservice.dto.BaseResponse;
import com.vall.tourneyservice.dto.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex.volosatov
 * Creation date 2/20/2019.
 */

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionHandlerController {


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleMandatoryField(MissingServletRequestParameterException e) {
        return BaseResponse.builder().status(ResponseStatus.MANDATORY_FIELD.getStatus()).error(e.getMessage()).build();
    }

    @ExceptionHandler(TypeMismatchException.class)
    public BaseResponse handleBadRequestError(TypeMismatchException e) {
        return BaseResponse.builder().status(ResponseStatus.TYPE_MISMATCH.getStatus()).error(e.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleServerError(Exception e) {
        log.error("Error occured during process the request: ", e);
        return BaseResponse.builder().status(ResponseStatus.SERVER_ERROR.getStatus()).error(e.getMessage()).build();
    }



}
