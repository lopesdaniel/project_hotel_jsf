package br.com.hotel.control.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.hotel.control.ConBanco;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Quarto;

public class QuartoDAO extends DaoGeneric{
	
	 public static List<Quarto> listarTodosQuartos() throws Exception{
			
			List<Quarto> lista_quartos = new ArrayList<Quarto>();
			try {
				ConBanco.abrirCon();
				Criteria crit = ConBanco.getSession().createCriteria(Quarto.class);
				lista_quartos = crit.list();
				
				return lista_quartos;			
			} catch (Exception e) {
				throw new Exception("Erro ao listar quartos: " + e);
	        }
	    }
	 
	 
	 public static Quarto buscarQuartoPorId(Integer id) throws Exception{
	    	Quarto q = new Quarto();
	    	try {
				ConBanco.abrirCon();
				Criteria crit = ConBanco.getSession().createCriteria(Quarto.class);
				q = (Quarto) crit.add(Restrictions.idEq(id)).uniqueResult();
				
				return q;
						
			} catch (Exception e) {
				throw new Exception("Erro ao buscar cliente: " + e);
			}
	    }
	 
	 public static List<Quarto> listaQuartosDiposniveis() throws Exception{
		 List<Quarto> lista_quartos = new ArrayList<Quarto>();
			try {
				ConBanco.abrirCon();
				Criteria crit = ConBanco.getSession().createCriteria(Quarto.class);
				lista_quartos = crit.add(Restrictions.eqOrIsNull("disponivel", true)).list();
				
				return lista_quartos;			
			} catch (Exception e) {
				throw new Exception("Erro ao listar quartos: " + e);
	        }
	 }
	 
	 public static Double buscarValorQuartoPorId(Integer id) throws Exception{
	    	Quarto q = new Quarto();
	    	try {
				ConBanco.abrirCon();
				Criteria crit = ConBanco.getSession().createCriteria(Quarto.class);
				q = (Quarto) crit.add(Restrictions.idEq(id)).uniqueResult();
				
				double valorQuarto = q.getValor(); 
				
				return valorQuarto;
						
			} catch (Exception e) {
				throw new Exception("Erro ao buscar cliente: " + e);
			}
	    }

}
