package br.com.hotel.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.model.Cliente;

@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	public String delCliente(){
		String retorno = "listarClientes";
		try {
			ClienteDAO.deletar(cliente);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String updateCliente(){
		String retorno = "listarClientes";
		
		try{
			ClienteDAO.atualizar(cliente);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String addCliente(){
		String retorno = "listarClientes";
		try{
			ClienteDAO.adicionar(cliente);
		} catch (Exception e) {
			retorno = "erro";
			e.printStackTrace();
		}
		
		return retorno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	public void selecionarReg(){
		this.cliente = clientes.getRowData();
	}
	
	public void novoReg(){
		this.cliente = new Cliente();
	}

}
