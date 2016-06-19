package br.com.hotel.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.hotel.control.DAO.QuartoDAO;
import br.com.hotel.model.Quarto;

@FacesConverter("quartoConverter")
public class QuartoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		try {
			Integer id = Integer.parseInt(valor);
            Quarto q = QuartoDAO.buscarQuartoPorId(id);
			
            return q;
        } catch (Exception ex) {
            return null;
        }
	}

	@Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object objeto) {
        try {
        	Quarto q = (Quarto) objeto;
        	Integer id = q.getId();
        	return id.toString();

        } catch (RuntimeException ex) {
            return null;
        }
    }
	
}
