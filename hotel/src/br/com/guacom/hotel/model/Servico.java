package br.com.guacom.hotel.model;

import java.math.BigDecimal;

public class Servico implements Comparable<Servico> {
	private Long codigo;
	private String descricacao;
	private BigDecimal preco;
	private Hospede hospede;
	
	/**
	 * 
	 * @param codigo
	 * @param descricao
	 * @param preco
	 * @throws NullPointerException
	 */
	public Servico(long codigo, String descricao, BigDecimal preco) throws NullPointerException {
		codigo = Long.valueOf(codigo);
		this.descricacao = descricao;
		if(preco == null) {
			throw new NullPointerException("O valor não foi cadastrado!");
		}
		this.preco = preco;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int compareTo(Servico s) {
		return preco.compareTo(s.preco);
	}
}
