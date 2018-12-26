package br.com.guacom.hotel.model;

public abstract class Pessoa {
	private Long codigo;
	private String nome;
	private Endereco endereco;
	
	public Pessoa(Long codigo, String nome, Endereco endereco) throws NullPointerException {
		this.codigo = codigo;
		this.nome = nome;
		if(endereco == null) {
			throw new NullPointerException("O endereço não foi cadastrado!");
		}
		this.endereco = endereco;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pessoa pessoa = (Pessoa) obj;
		if(this.codigo == pessoa.codigo) {
			return true;
		}
		return false;
	}
}
