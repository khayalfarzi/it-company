package az.company.itcompany.controller;

import az.company.itcompany.entities.Exception;
import az.company.itcompany.exceptions.GeneralException;
import az.company.itcompany.exceptions.NoDataFoundException;
import az.company.itcompany.exceptions.NotAllowException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotAllowException.class)
    public Exception handleNotAllowException(NotAllowException e) {
        return Exception
                .builder()
                .code(701)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(GeneralException.class)
    public Exception handleGeneralException(GeneralException e) {
        return Exception
                .builder()
                .code(702)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(NoDataFoundException.class)
    public Exception handleNoDataFoundException(NoDataFoundException e) {
        return Exception
                .builder()
                .code(703)
                .message(e.getMessage())
                .build();
    }
}
