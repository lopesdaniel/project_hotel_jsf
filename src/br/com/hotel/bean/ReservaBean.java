package br.com.hotel.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.control.DAO.QuartoDAO;
import br.com.hotel.control.DAO.ReservaDAO;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Quarto;
import br.com.hotel.model.Reserva;

@ManagedBean(name="reservaBean")
@SessionScoped
public class ReservaBean {
	
	private Reserva reserva;
	private Quarto quarto;
	
	private DataModel<Reserva> reservas;
	private DataModel<Cliente> clientes;
	private DataModel<Quarto> quartos;
	
	public String delReserva(){
		String retorno = "listarReservas";
		try {
			ReservaDAO.deletar(reserva);
			mudarStatusQuartoT();
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String updateReserva(){
		String retorno = "listarReservas";
		
		try{
			ReservaDAO.atualizar(reserva);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String addReserva(){
		String retorno = "listarReservas";
		try{
			ReservaDAO.adicionar(reserva);
			mudarStatusQuartoF();
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public DataModel<Reserva> getReservas() {
		
		try{
			List<Reserva> lista = new ArrayList<Reserva>();
			lista = ReservaDAO.listarTodasReservas();
			
			reservas = new ListDataModel<Reserva>(lista);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return reservas;
	}

	public void setReservas(DataModel<Reserva> reservas) {
		this.reservas = reservas;
	}

	public DataModel<Cliente> getClientes() {
		
		try{
			List<Cliente> lista = new ArrayList<Cliente>();
			lista = ClienteDAO.listarTodosClientes();
			
			clientes = new ListDataModel<Cliente>(lista);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public DataModel<Quarto> getQuartos() {
		try{
			List<Quarto> lista = new ArrayList<Quarto>();
			lista = QuartoDAO.listaQuartosDiposniveis();
			
			quartos = new ListDataModel<Quarto>(lista);
		} catch(Exception e){
			e.printStackTrace();
		}
		return quartos;
	}
	public void setQuartos(DataModel<Quarto> quartos) {
		this.quartos = quartos;
	}
	
	public void valorQuarto() {
        
    }
	
	public void calcular(){
		double v1 = this.reserva.getQuarto().getValor();
		double v2 = this.reserva.getDias();
		
		double mult = (v1*v2);
		
		this.reserva.setValorFinal(mult);
		
		//System.out.println("Valor da multiplicação: "+mult);
	}
	
	private void mudarStatusQuartoF(){
		Quarto q1 = new Quarto();
		
		try {
			int idQuarto = this.reserva.getQuarto().getId();
			q1 = QuartoDAO.buscarQuartoPorId(idQuarto);
			
			q1.setDisponivel(false);
			
			QuartoDAO.atualizar(q1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void mudarStatusQuartoT(){
		Quarto q1 = new Quarto();
		
		try {
			int idQuarto = this.reserva.getQuarto().getId();
			q1 = QuartoDAO.buscarQuartoPorId(idQuarto);
			
			q1.setDisponivel(true);
			
			QuartoDAO.atualizar(q1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void selecionarReg(){
		this.reserva = reservas.getRowData();
	}
	
	public void novoReg(){
		this.reserva = new Reserva();
	}
	
	
	
}
