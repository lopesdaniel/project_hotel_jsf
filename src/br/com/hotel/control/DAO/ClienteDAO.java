package br.com.hotel.control.DAO;

import br.com.hotel.control.ConBanco;
import br.com.hotel.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;


public class ClienteDAO extends DaoGeneric{
    
    public static List<Cliente> listarTodosClientes() throws Exception{
		
		List<Cliente> lista_clientes = new ArrayList<Cliente>();
		try {
			ConBanco.abrirCon();
			Criteria crit = ConBanco.getSession().createCriteria(Cliente.class);
			lista_clientes = crit.list();
			
			return lista_clientes;	
		} catch (Exception e) {
			throw new Exception("Erro ao listar clientes: " + e);
        }
    }
    
    public static Cliente buscarClientePorId(Integer id) throws Exception{
    	Cliente cli = new Cliente();
    	try {
			ConBanco.abrirCon();
			Criteria crit = ConBanco.getSession().createCriteria(Cliente.class);
			cli = (Cliente) crit.add(Restrictions.idEq(id)).uniqueResult();
			
			return cli;
					
		} catch (Exception e) {
			throw new Exception("Erro ao buscar cliente: " + e);
		}
    }
    
}
