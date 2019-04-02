package br.com.fiap.orderservice.handler;

import static br.com.fiap.orderservice.handler.Exceptions.generateMessage;
import static br.com.fiap.orderservice.handler.Exceptions.toMap;

public class EntityNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> clazz, String... searchParamsMap) {
        super(generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));
    }
}