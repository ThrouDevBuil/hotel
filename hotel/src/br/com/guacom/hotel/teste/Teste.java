package br.com.guacom.hotel.teste;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.guacom.hotel.model.Endereco;
import br.com.guacom.hotel.model.Ficha;
import br.com.guacom.hotel.model.Hospede;
import br.com.guacom.hotel.model.Hotel;
import br.com.guacom.hotel.model.Quarto;
import br.com.guacom.hotel.model.QuartoIndisponivelException;

public class Teste {
	
	public static void main(String[] args) {
		long cod;
		int choose = 0;
		boolean enter = true;
		
		ArrayList<Hospede> hospedes = new ArrayList<>();
		
		ArrayList<Quarto> quartos = new ArrayList<>();
		
		Hotel hotel = new Hotel("Tres Altares", new Endereco("Bahia", "Salvador"), 123, quartos, hospedes);
		
		quartos.add(new Quarto("Basic with 1 bed", new BigDecimal(250.32), hotel));
		quartos.add(new Quarto("Basic with 2 beds", new BigDecimal(300.35), hotel));
		quartos.add(new Quarto("Standard with double bed", new BigDecimal(750.43), hotel));
		quartos.add(new Quarto("Standard with double bed and 1 single bed", new BigDecimal(989.54), hotel));
		quartos.add(new Quarto("Ultimate with 2 double beds", new BigDecimal(1300.21), hotel));
		
		
		while(choose == 0) {
			
			choose = Integer.parseInt(JOptionPane.showInputDialog("Escolha:"
					+ "\n1 - Cadastrar um novo hóspede"
					+ "\n2 - Cadastrar um novo serviço"
					+ "\n3 - Cadastrar uma nova ficha"
					+ "\n4 - Remover um hóspede"));
			
			switch (choose) {
				case 1:
					enter = true;
					
					while(enter) {
						
						try {
							enter = false;
							hotel.cadastrar();
						} catch(QuartoIndisponivelException | NullPointerException ex) {
							enter = true;
							JOptionPane.showMessageDialog(null, ex.getMessage());
						}
					}
					break;
				case 2:
					enter = false;
					cod = Long.parseLong(JOptionPane.showInputDialog("Digite o código do hóspede: "));
					
					for(Hospede hospede : hospedes) {
						
						if(hospede.getCodigo() == cod){ 
							try {
								hospede.cadastrar();
							} catch (NullPointerException ex) {
								JOptionPane.showMessageDialog(null, "Objeto não foi cadastrado!");
							}
							enter = true;
							break;
						}
					}
					if(!enter) {
						JOptionPane.showMessageDialog(null, "Não existe um hóspede com este código");
					}
					break;
				case 3:
					enter = false;
					
					String cidadeOrig = JOptionPane.showInputDialog("Cidade origem: ");
					
					String cidadeDest = JOptionPane.showInputDialog("Cidade destino: ");
					
					cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do hóspede"));
									
					for(Hospede hospede : hospedes) {
						
						if(hospede.getCodigo().compareTo(cod) == 0) {
							try {
								hospede.getFichas().add(new Ficha(cidadeOrig, cidadeDest, hospedes.get(hospedes.indexOf(hospede)).getFichas().get(0).getIdRoom(), hospede));		
							}catch(NullPointerException ex) {
								JOptionPane.showMessageDialog(null, "Objeto não foi cadastrado!");
							}
							enter = true;
							break;
						}
					}
					if(!enter) {
						JOptionPane.showMessageDialog(null, "Não existe um hóspede com este código");
					}
					break;
				case 4: 
					enter = false;
					
					long idHospede = Long.parseLong(JOptionPane.showInputDialog("Digite o código do Hóspede"));
					
					for(Hospede hospede : hospedes) {
						
						if(hospede.getCodigo().compareTo(idHospede) == 0) {
							hotel.remover(hospedes.indexOf(hospede));
							enter = true;
							break;
						}
					}
					if(!enter) {
						JOptionPane.showMessageDialog(null, "Não existe um hóspede com este código");
					}
					break;
					
				default:
					break;
			}
			choose = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}
	}
}
