/**
 * 
 */
package com.bms.exception;

import lombok.Getter;


@Getter
public class BmsException extends RuntimeException {

	private static final long serialVersionUID = 646182706219385282L;

	private final String message;

	public BmsException(String message) {
		super(message);
		this.message = message;
	}

}