package br.com.hotel.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.hotel.model.Usuario;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	
	private Usuario usuario = new Usuario();

	public String efetuarLogin() {
	    if("admin".equals(usuario.getLogin()) &&
	       "123".equals(usuario.getSenha())) {
	      /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
	      return "home";
	    }
	    	/* Cria uma mensagem. */
	      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
	      	/* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
	      FacesContext.getCurrentInstance().addMessage("erro", msg);
	    return null;
	  }

	  public Usuario getUsuario() {
	    return usuario;
	  }

	  public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	  }
	
}
