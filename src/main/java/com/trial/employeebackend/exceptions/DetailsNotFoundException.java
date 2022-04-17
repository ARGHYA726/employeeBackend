/**
 * 
 */
package com.trial.employeebackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ARGSAHA
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DetailsNotFoundException extends RuntimeException {
	public DetailsNotFoundException(String message){
		super(message);
	}

}
