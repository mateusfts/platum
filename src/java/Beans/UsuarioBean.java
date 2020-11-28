package Beans;

import Entidades.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    /* Atributos */
    Usuario usuario;
    
    public UsuarioBean(){
//        usuario = new Usuario();
    }
    
        @PostConstruct
    public void init(){
//        try {
//            usuario = usuarioDAO.buscar(1);
//            if(usuario==null){
//                addMessage("Usuário inexistente!");
//            }         
//        } catch (Exception e) {
//            addMessage(e.getMessage());
//        }
    }
    
    public void addMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }

    public void atualizarComponente(String id) {
        RequestContext.getCurrentInstance().update(id);
    }
}
