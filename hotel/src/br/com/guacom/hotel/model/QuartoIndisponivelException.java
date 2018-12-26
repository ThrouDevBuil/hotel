package br.com.guacom.hotel.model;

public class QuartoIndisponivelException extends IllegalStateException {
	
	/**
	 * 
	 * @param s
	 * @exception QuartoIndisponivelException
	 */
	public QuartoIndisponivelException(String s) {
		super(s);		
	}
}
