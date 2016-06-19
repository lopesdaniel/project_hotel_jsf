package br.com.hotel.control.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import br.com.hotel.control.ConBanco;
import br.com.hotel.model.Reserva;

public class ReservaDAO extends DaoGeneric{
	
	 public static List<Reserva> listarTodasReservas() throws Exception{
			
			List<Reserva> lista_reservas = new ArrayList<Reserva>();
			try {
				ConBanco.abrirCon();
				Criteria crit = ConBanco.getSession().createCriteria(Reserva.class);
				lista_reservas = crit.list();
				
				return lista_reservas;			
			} catch (Exception e) {
				throw new Exception("Erro ao listar reservas: " + e);
	        }
	    }
	
	
}
