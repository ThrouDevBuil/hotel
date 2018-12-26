package br.com.guacom.hotel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Hospede extends Pessoa implements Cadastra, Comparable<Hospede> {
	public static int cont;
	private String filiacao;
	private Hotel hotel;
	private List<Servico> servicos;
	private List<Ficha> fichas;
	private Integer qntdDias;
	
	/**
	 * 
	 * @param codigo
	 * @param nome
	 * @param endereco
	 * @param filiacao
	 * @param hotel
	 * @param qntdDias
	 * @throws NullPointerException
	 */
	public Hospede(Long codigo, String nome, Endereco endereco, String filiacao, Hotel hotel, int qntdDias) throws NullPointerException {
		super(codigo, nome, endereco);
		this.filiacao = filiacao;
		this.hotel = hotel;
		servicos = new ArrayList<>();
		fichas = new ArrayList<>();
		this.qntdDias = Integer.valueOf(qntdDias);
	}
	
	public void addRecord(Ficha record) {
		fichas.add(record);
	}
	
	public List<Ficha> getFichas() {
		return fichas;
	}
	
	public String getFiliacao() {
		return filiacao;
	}
	
	public List<Servico> getServicos() {
		return servicos;
	}
	
	public void addService(Servico service) {
		servicos.add(service);
	}
	
	/**
	 * 
	 * @throws QuartoIndisponivelException
	 */
	public void checkIn() throws QuartoIndisponivelException {
		StringBuilder sb = new StringBuilder("Digite o id do quarto que você deseja selecionar: \n");
		
		for(Quarto quarto : hotel.getQuartos()) {
			sb.append(quarto.getNumero() + " - " + quarto.getDescricao());
			sb.append("\n");
		}
		Long idRoom = Long.valueOf(JOptionPane.showInputDialog(sb));
		while(!hotel.getQuartos().get(idRoom.intValue()).isStatus()) {
			throw new QuartoIndisponivelException("Quarto indisponível!!");
		}
		String cidadeOrig = JOptionPane.showInputDialog("Cidade de origem: ");
		String cidadeDest = JOptionPane.showInputDialog("Cidade de destino: ");
		
		Ficha ficha = new Ficha(cidadeOrig, cidadeDest, idRoom, this);
		ficha.cadastrar();
		hotel.getQuartos().get(idRoom.intValue()).setStatus(false);
		fichas.add(ficha);
	}
	
	public BigDecimal checkOut() {
		BigDecimal valor = calcularTotal(this.fichas.get(0).getIdRoom());
		return valor;
	}
	

	private BigDecimal calcularTotal(long idRoom) {
		BigDecimal total;
		
		for(Quarto quarto : hotel.getQuartos()) {
			
			if(quarto.getNumero().longValue() == idRoom) {
				total = BigDecimal.valueOf(this.qntdDias.longValue()).multiply(quarto.getDiaria());
				for(Servico service : servicos) {
					total.add(service.getPreco());
				}
				return total;
			}
		}
		return BigDecimal.valueOf(0.0);
	}

	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	/*
	 * Uma subclasse pode redefinir (sobrescrever) um método herdado 
	 * – Este mecanismo é chamado de polimorfismo
	 * – O polimorfismo se realiza através da recodificação de
	 * 	 um ou mais métodos herdados por uma subclasse.
	 *	 Qualquer subclasse é comparável com a sua superclasse, mas a superclasse não.
     * – Em tempo de execução, o Java saberá qual implementação deve ser usada
     *	 a anotação Override é usada para sobrescrever o método da classe mãe,
     *   indicando que o método original foi alterado.
	 
	 */	
	@Override
	public void cadastrar() {
		int choose = Integer.parseInt(JOptionPane.showInputDialog("Selecione:"
				+ "\n1 - Lavanderia"
				+ "\n2 - Passeio"));
		String desc = JOptionPane.showInputDialog("Descrição: ");
		BigDecimal preco = BigDecimal.valueOf(Double.parseDouble((JOptionPane.showInputDialog("Preço: "))));
		
		switch(choose) {
			case 1:
				String restri = JOptionPane.showInputDialog("Restriçoes: ");
				addService(new Lavanderia(Hospede.cont, desc, preco, restri));
				break;
			case 2:
				String local = JOptionPane.showInputDialog("Digite o local: ");
				addService(new Passeio(Hospede.cont, desc, preco, local));
				break;
			
			default:
				break;
		}
		Hospede.cont++;
	}

	public Integer getDias() {
		return qntdDias;
	}
	
	@Override
	public int compareTo(Hospede h) {
		return getNome().compareTo(h.getNome());
	}
}
