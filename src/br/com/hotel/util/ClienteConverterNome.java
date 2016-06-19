package br.com.hotel.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.model.Cliente;

@FacesConverter("clienteConverterNome")
public class ClienteConverterNome implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		try {
			Integer id = Integer.parseInt(valor);
			Cliente c = ClienteDAO.buscarClientePorId(id);
            
            return c;
        } catch (Exception ex) {
            return null;
        }
	}

	@Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object objeto) {
        try {
        	Cliente c = (Cliente) objeto;
        	String nome = c.getNome();
     
        	return nome;
        } catch (RuntimeException ex) {
            return null;
        }
    }
	
}
