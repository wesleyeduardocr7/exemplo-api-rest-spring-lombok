package br.com.wesleyti.lombokspringapirest.api.excecao.handler;
import br.com.wesleyti.lombokspringapirest.api.excecao.RespostaDeExcecoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class RespostaDeExcecoesCustomizadas extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<RespostaDeExcecoes> handleAllExceptions(Exception ex, WebRequest request) {
		RespostaDeExcecoes respostaDeExcecoes =
				new RespostaDeExcecoes(
						new Date(),
						ex.getMessage(),
						request.getDescription(false));
		return new ResponseEntity<>(respostaDeExcecoes, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
