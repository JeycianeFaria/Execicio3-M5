package br.com.zup.simulador.simulador.config;

import br.com.zup.simulador.simulador.exeptions.InvestimentoInvalido;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControladorAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemError> execoesValidacoes(MethodArgumentNotValidException exception) {
        List<MensagemError> mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            mensagens.add(new MensagemError(fieldError.getDefaultMessage()));
        }

        return mensagens;
    }


    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemError riscoInvalido(InvalidFormatException exeption) {
        return new MensagemError("Risco não reconhecido");
    }

    @ExceptionHandler(InvestimentoInvalido.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemError investimentoInvalido(InvestimentoInvalido exeption) {
        return new MensagemError(exeption.getMessage());
    }

}
