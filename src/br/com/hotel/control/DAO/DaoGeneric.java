/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.control.DAO;

import br.com.hotel.control.ConBanco;

/**
 *
 * @author User
 */
public class DaoGeneric {
    
    public static void adicionar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().save(obj);
			ConBanco.getTransaction().commit();			
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao salvar objeto... " + e.getMessage());	
		}
	}
	
	public static void deletar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().delete(obj);
			ConBanco.getTransaction().commit();
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao deletar objeto... " + e.getMessage());
		}
	}
	
	public static void atualizar(Object obj){
		try {
			ConBanco.abrirCon();
			ConBanco.getSession().update(obj);
			ConBanco.getTransaction().commit();
		} catch (Exception e) {
			ConBanco.getTransaction().rollback();
			System.err.println("Erro ao atualizar objeto... " + e.getMessage());
		}
	}
    
}
