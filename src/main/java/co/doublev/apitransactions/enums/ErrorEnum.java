package co.doublev.apitransactions.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
	UNAUTHORIZED("001","No autorizado",HttpStatus.UNAUTHORIZED),
	INTERNAL_SERVER_ERROR("002","Error inesperado",HttpStatus.INTERNAL_SERVER_ERROR),
	USER_ID_IS_REQUIRED("100","Usuario es requerido" , HttpStatus.BAD_REQUEST),
	TICKET_ID_IS_REQUIRED("101","Ticket es requerido" , HttpStatus.BAD_REQUEST),
	TICKET_NOT_FOUND("102","Ticket no encontrado" , HttpStatus.NOT_FOUND);
	
	private String code;
	private String description;
	private HttpStatus httpCode;
	
	
}



