package co.doublev.apitransactions.exceptions;


import co.doublev.apitransactions.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralErrorResponse {

	 private ErrorEnum error;
	    private String message;

}




