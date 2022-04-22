package dev.Alexandrov.regions.controllers;

import dev.Alexandrov.regions.exceptions.RegionNotFound;
import dev.Alexandrov.regions.exceptions.ValidatorException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsController {
    @ResponseBody
    @ExceptionHandler(ValidatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String onConstraintValidationException(ValidatorException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RegionNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String onConstraintValidationException(RegionNotFound e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String onConstraintValidationException(DuplicateKeyException e) {
        return "Данный id уже занят";
    }



}
