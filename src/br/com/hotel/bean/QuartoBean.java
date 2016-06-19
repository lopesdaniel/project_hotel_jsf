package br.com.hotel.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.control.DAO.QuartoDAO;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Quarto;

@ManagedBean(name = "quartoBean")
@SessionScoped
public class QuartoBean {
	
	private Quarto quarto = new Quarto();
	private DataModel<Quarto> quartos;
	
	public String addQuarto(){
		String retorno = "listarQuartos";
		try{
			QuartoDAO.adicionar(quarto);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String delQuarto(){
		String retorno = "listarQuartos";
		try {
			QuartoDAO.deletar(quarto);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String updateQuarto(){
		String retorno = "listarQuartos";
		
		try{
			QuartoDAO.atualizar(quarto);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public DataModel<Quarto> getQuartos() {
		try{
			List<Quarto> lista = new ArrayList<Quarto>();
			lista = QuartoDAO.listarTodosQuartos();
			
			quartos = new ListDataModel<Quarto>(lista);
		} catch(Exception e){
			e.printStackTrace();
		}
		return quartos;
	}
	public void setQuartos(DataModel<Quarto> quartos) {
		this.quartos = quartos;
	}
	
	public void selecionarReg(){
		this.quarto = quartos.getRowData();
	}
	
	public void novoReg(){
		this.quarto = new Quarto();
	}
	
	

}
