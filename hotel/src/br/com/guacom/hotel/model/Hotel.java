package br.com.guacom.hotel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.guacom.hotel.util.MoedaUtil;

public class Hotel implements Cadastra {
	private Integer codigo;
	private static long cont;
	private String nome;
	private Endereco endereco;
	private List<Hospede> hospedes;
	private List<Quarto> quartos;
	
	/**
	 * 
	 * @param nome
	 * @param end
	 * @param codigo
	 * @param quartos
	 * @param hospedes
	 * @throws NullPointerException
	 */
	public Hotel(String nome, Endereco end, int codigo, ArrayList<Quarto> quartos, ArrayList<Hospede> hospedes) throws NullPointerException {
		
		if(end == null) {
			throw new NullPointerException("O endereço não foi cadastrado!");
		}
		this.nome = nome;
		this.endereco = end;
		this.codigo = Integer.valueOf(codigo);
		this.hospedes = hospedes;
		this.quartos = quartos;
	}
	
	public List<Quarto> getQuartos() {
		return quartos;
	}
	
	public List<Hospede> getHospedes() {
		return hospedes;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
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
	
	/**
	 * @author Elvis
	 * @throws QuartoIndisponivelException
	 *
	 * Efetua o cadastro de um hóspede
	 */
	@Override
	public void cadastrar() throws QuartoIndisponivelException {
		
		String nome = JOptionPane.showInputDialog("Nome: ");
		String estado = JOptionPane.showInputDialog("Estado: ");
		String cidade = JOptionPane.showInputDialog("Cidade: ");
		String filiacao = JOptionPane.showInputDialog("Filiação: ");
		int qntdDias = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dias: "));
		
		Hospede hospede = new Hospede(Hotel.cont, nome, new Endereco(estado, cidade), filiacao, this, qntdDias);
		hospede.checkIn();
		hospedes.add(hospede);
		quartos.get(hospede.getFichas().get(0).getIdRoom().intValue()).setStatus(false);
		Hotel.cont++;
	}
	
	/**
	 * 
	 * @param position
	 * @
	 */
	public void remover(int position) {
		BigDecimal total = BigDecimal.valueOf(0.0);
		total = hospedes.get(position).checkOut();
		hospedes.remove(hospedes.get(position));
		efetuarPagamento(total);
	}		

	/**
	 * 
	 * @param total
	 */
	private void efetuarPagamento(BigDecimal total) {
		JOptionPane.showMessageDialog(null, "Valor total da estádia - " + MoedaUtil.formatBr(total));
	}
}
