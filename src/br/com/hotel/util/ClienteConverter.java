package br.com.hotel.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hotel.control.DAO.ClienteDAO;
import br.com.hotel.model.Cliente;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{

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
        	Integer id = c.getId();
        	return id.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }

}
