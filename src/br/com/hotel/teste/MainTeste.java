package br.com.hotel.teste;

import br.com.hotel.control.ConBanco;
import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.control.DAO.QuartoDAO;
import br.com.hotel.control.DAO.ReservaDAO;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Quarto;
import br.com.hotel.model.Reserva;

public class MainTeste {

	public static void main(String[] args) {
		
		try {
			ConBanco.abrirCon();
			
//			Cliente c1 = new Cliente();
//			c1.setNome("Ricardo Alves Teixeira");
//			c1.setRg("30.421.894-7");
//			c1.setTelefone("(77) 3568-6229");
//			c1.setEmail("r.alves@gmail.com");
//			
//			ClienteDAO.adicionar(c1);
//			
//			Cliente c2 = new Cliente();
//			c2.setNome("César Erick Carvalho");
//			c2.setRg("35.199.612-6");
//			c2.setTelefone("(47) 9275-0991");
//			c2.setEmail("cesar_e_carvalho@aircominternational.com");
//			
//			ClienteDAO.adicionar(c2);
//			
//			Cliente c3 = new Cliente();
//			c3.setNome("Alana Melissa Gomes");
//			c3.setRg("50.190.160-7");
//			c3.setTelefone("(69) 2638-8391");
//			c3.setEmail("amgomes@officetectecnologia.com.br");
//			
//			ClienteDAO.adicionar(c3);
//			
//			for(Cliente cli : ClienteDAO.listarTodosClientes()){
//				System.out.println("Id: " + cli.getId());
//				System.out.println("Nome: "+ cli.getNome());
//				System.out.println("Rg: " + cli.getRg());
//				System.out.println("Telefone: " + cli.getTelefone());
//				System.out.println("Email: " + cli.getEmail());
//				System.out.println("---------------------------------------------------------");
//				System.out.println("");
//			}
	
//			Quarto q1 = new Quarto();
//			q1.setNumero("001");
//			q1.setTipo("Casal");
//			q1.setValor(200.0);
//			q1.setDisponivel(true);
//			
//			QuartoDAO.adicionar(q1);
//			
//			Quarto q2 = new Quarto();
//			q2.setNumero("002");
//			q2.setTipo("Individual");
//			q2.setValor(350.0);
//			q2.setDisponivel(false);
//			
//			QuartoDAO.adicionar(q2);
//			
//			for(Quarto q : QuartoDAO.listaQuartosDiposniveis()){
//				System.out.println("Id : " + q.getId());
//				System.out.println("Número: " + q.getNumero());
//				System.out.println("Tipo : " + q.getTipo());
//				System.out.println("Disponível ? " + q.getDisponivel());
//				System.out.println("Valor : " + q.getValor());
//				System.out.println("--------------------------");
//			}
//			
//			Cliente c = new Cliente();
//			
//			c = ClienteDAO.buscarClientePorId(2);
//			
//			System.out.println("Nome do cliente: " + c.getNome());
//			
//			Quarto q = new Quarto();
//			q = QuartoDAO.buscarQuartoPorId(1);
//			
//			Reserva r = new Reserva();
//			
//			r.setCliente(c);
//			r.setQuarto(q);
//			r.setDataEnt("08/06/2016");
//			r.setDataSai("12/06/2016");
//			r.setValorFinal(900.0);
//			
//			ReservaDAO.adicionar(r);
			
//			Quarto q = new Quarto();
			
//		Double v = q.setValor(QuartoDAO.buscarValorQuartoPorId(1));
			
//			System.out.println();
			
			
			
		} catch (Exception e) {
			System.err.println("Erro no teste " + e.getMessage());
		}finally {
			ConBanco.fecharCon();
		}

	}

}
