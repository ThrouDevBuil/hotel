package br.com.guacom.hotel.model;

import java.math.BigDecimal;

import br.com.guacom.hotel.util.DateUtil;

public class Passeio extends Servico {
	private String date;
	private String local;
	
	public Passeio(long codigo, String descricao, BigDecimal preco, String local) {
		super(codigo, descricao, preco);
		date = DateUtil.getDate();
		this.local = local;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getLocal() {
		return local;
	}
}
