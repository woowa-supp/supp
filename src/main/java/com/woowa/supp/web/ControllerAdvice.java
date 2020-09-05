package com.woowa.supp.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.woowa.supp.domain.surveyee.style.InvalidStyleException;
import com.woowa.supp.service.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({IllegalArgumentException.class, UserNotFoundException.class,
            InvalidStyleException.class})
    private ErrorMessage handleExpectedException(IllegalArgumentException e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorMessage.setMessage(e.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    private ErrorMessage handleUnexpectedException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorMessage.setMessage(
                "예기치 못한 에러가 발생했습니다. \n 개발자가 열심히 확인하고 있습니다. 🔧 \n " + e.getMessage());
        return errorMessage;
    }
}
