package Beans;

import Entidades.Usuario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {
    private String login;
    private String senha;
    
    public LoginBean(){
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    public String acessar() {
        try {
            //tratar o que o usuario digitou
            //chamar o model para pesquisar o usuario
            Usuario usuario = Usuario.pesquisarUsuario(login,senha);
            if(usuario != null)
                return "home";
            else
                addMessage("Usuário ou senha incorretos.");
                return null;
            //retornar erro ou direcionar para a pagina do menu principal
        } catch (Exception ex) {
            addMessage("Alguma coisa deu errado!");
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void addMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }
    
    public void atualizarComponente(String id) {
        RequestContext.getCurrentInstance().update(id);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
