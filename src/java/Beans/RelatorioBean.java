package Beans;

import DAO.RelatorioDAO;
import Entidades.Relatorio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "RelatorioBean")
@ViewScoped
public class RelatorioBean implements Serializable {

    RelatorioDAO relatorioDAO;
    List<Relatorio> relatorios;
    private Relatorio relatorio;
    
    public RelatorioBean() {
    
       relatorioDAO = new RelatorioDAO();
       relatorios = null; 
       relatorio = new Relatorio();
    }
    
    @PostConstruct
    public void init() {
       pesquisar();
            
    }
    
    

    public void pesquisar(){
        try{
                relatorios = relatorioDAO.buscar();
        }catch(Exception ex){
            
                addMessage("Erro ao realizar consulta!");
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

    public RelatorioDAO getRelatorioDAO() {
        return relatorioDAO;
    }

    public void setRelatorioDAO(RelatorioDAO relatorioDAO) {
        this.relatorioDAO = relatorioDAO;
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }
    
    
}