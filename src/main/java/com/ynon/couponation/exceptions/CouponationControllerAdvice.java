package com.ynon.couponation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ynon on  14-Aug-21
 */
@RestController
@ControllerAdvice
public class CouponationControllerAdvice {

    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDto handleSystemException(Exception e){
        return new ErrDto(e.getMessage());
    }

    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDto handleIOException(Exception e){
        return new ErrDto(e.getMessage());
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<?> validationErrorHandler(ConstraintViolationException e) {
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrDto> globalExceptionHandler(Exception ex, WebRequest request) {
    ErrDto message = new ErrDto(
            ex.getMessage()
           /* ,HttpStatus.INTERNAL_SERVER_ERROR,
            request.getDescription(false)*/);

    return new ResponseEntity<ErrDto>(HttpStatus.INTERNAL_SERVER_ERROR);
}

//    @ExceptionHandler(value = {ApplicationException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ErrDto handleLoginException(Exception e){
//        return new ErrDto(e.getMessage());
//    }


}
