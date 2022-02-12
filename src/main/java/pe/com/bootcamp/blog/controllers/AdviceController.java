package pe.com.bootcamp.blog.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.com.bootcamp.blog.dto.response.GenericResponse;
import pe.com.bootcamp.blog.dto.response.GenericResponse.Metadata;
import pe.com.bootcamp.blog.exceptions.BusinessException;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleCityNotFoundException(BusinessException ex, WebRequest request) {
		GenericResponse<Object> response = GenericResponse.builder()
				.metadata(Metadata.builder().status(ex.getHttpStatus().value()).message(ex.getMessage()).build())
				.build();
		return handleExceptionInternal(ex, response, 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}
