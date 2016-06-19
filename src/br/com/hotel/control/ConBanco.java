package br.com.hotel.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.hotel.util.HibernateUtil;

public class ConBanco {

	private static Session session;
	private static Transaction transaction;
	
	public static void abrirCon() throws Exception{
		try {
			ConBanco.session = HibernateUtil.getSessionFactory().openSession();
			ConBanco.transaction = ConBanco.session.beginTransaction();
			System.out.println("Abriu o banco !");
		} catch (Exception e) {
			System.err.println("Erro ao abrir conexão com o banco: " + e.getMessage());
		}
	}
	
	public static void fecharCon(){
		if(ConBanco.session != null && ConBanco.session.isOpen()){
			HibernateUtil.getSessionFactory().close();
			System.out.println("Fechou o banco !");
		}
	}

	public static Session getSession() {
		return session;
	}

	public static Transaction getTransaction() {
		return transaction;
	}
	
}
