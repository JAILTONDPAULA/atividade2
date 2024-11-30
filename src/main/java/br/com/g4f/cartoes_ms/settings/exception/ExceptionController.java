package br.com.g4f.cartoes_ms.settings.exception;

import br.com.g4f.cartoes_ms.dtos.ErrorDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> validationExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> erros = bindingResult.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(erros));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> ExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(Collections.singletonList(ex.getMessage())));
    }

}
