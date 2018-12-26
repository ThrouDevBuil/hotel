package br.com.guacom.hotel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Quarto implements Cadastra {
	private static long cont;
	private Long numero;
	private Hotel hotel;
	private String descricao;
	private BigDecimal diaria;
	private boolean status;
	private List<Ficha> fichas;
	
	public Quarto(String descricao, BigDecimal diaria, Hotel hotel) {
		this.descricao = descricao;
		this.status = true;
		this.diaria = diaria;
		this.fichas = new ArrayList<>();
		this.hotel = hotel;
		this.numero = cont;
		Quarto.cont++;
	}
	
	public List<Ficha> getFichas() {
		return fichas;
	}
	
	public Long getNumero() {
		return numero;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public BigDecimal getDiaria() {
		return diaria;
	}
	
	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	@Override
	public boolean equals(Object obj) {
		Quarto quarto = (Quarto) obj;
		if(quarto.numero == this.numero) {
			return true;
		}
		return false;
	}

	@Override
	public void cadastrar() {
		String cidadeOrig = JOptionPane.showInputDialog("Cidade origem: ");
		String cidadeDest = JOptionPane.showInputDialog("Cidade destino: ");
		fichas.add(new Ficha(cidadeOrig, cidadeDest, fichas.get(0).getIdRoom(), fichas.get(0).getHospede()));
	}
}
