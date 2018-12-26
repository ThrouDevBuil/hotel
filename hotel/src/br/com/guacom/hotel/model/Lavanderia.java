package br.com.guacom.hotel.model;

import java.math.BigDecimal;

public class Lavanderia extends Servico {
	public String restricoes;
	
	public Lavanderia(long codigo, String descricao, BigDecimal preco, String restricoes) {
		super(codigo, descricao, preco);
		this.restricoes = restricoes;
	}
	
	public String getRestricoes() {
		return restricoes;
	}
}
