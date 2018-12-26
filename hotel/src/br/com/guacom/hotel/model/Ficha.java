package br.com.guacom.hotel.model;

import br.com.guacom.hotel.util.DateUtil;

public class Ficha implements Cadastra {
	public static long cont;
	private long codigo = cont;
	private String cidadeOrigem;
	private Quarto quarto;
	private Hospede hospede;
	private String cidadeDestino;
	private String dataEHora;
	private Long idRoom;
	
	/**
	 * 
	 * @param cidadeOrigem
	 * @param cidadeDestino
	 * @param idRoom
	 * @param hospede
	 */
	public Ficha(String cidadeOrigem, String cidadeDestino, long idRoom, Hospede hospede) {
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.hospede = hospede;
		this.hospede = hospede;
		this.dataEHora = DateUtil.getDateAndTime();
		this.idRoom = Long.valueOf(idRoom);
		cont++;
	}
	
	public long getCodigo() {
		return codigo;
	}
	
	public Long getIdRoom() {
		return idRoom;
	}
	
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}
	
	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public String getDataEHora() {
		return dataEHora;
	}
	
	public Quarto getQuarto() {
		return quarto;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	
	@Override
	public boolean equals(Object obj) {
		Ficha regi = (Ficha) obj;
		
		if(regi.codigo != this.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public void cadastrar() {
		quarto = hospede.getHotel().getQuartos().get(idRoom.intValue());
	}
}
