package Beans;

import DAO.ProfissionalDAO;
import Entidades.Aluno;
import Entidades.Profissional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

@Named(value = "cadastroProfissionalBean")
@ViewScoped
public class CadastroProfissionalBean implements Serializable {
      private Profissional profissional;
      ProfissionalDAO profissionalDAO;
      List<Profissional> profissionais;

   
    public CadastroProfissionalBean() {
        profissionalDAO = new ProfissionalDAO();
        profissionais = null;
        profissional = new Profissional();
    }

    @PostConstruct
    public void init() {
        buscar();
    }

     public void salvar() {
        try {
            profissionalDAO.salvar(profissional);
            addMessage("Dados inseridos com sucesso!");
        } catch (Exception ex) {
            addMessage("Dados não inseridos " + ex);
            Logger.getLogger(CadastroProfissionalBean.class.getName()).log(Level.SEVERE, null, ex);
           return;
        }
        
        buscar();
        atualizarComponente("form");
        profissional = new Profissional();

    }
    public void buscar(){
           try{
                profissionais = profissionalDAO.buscar();
           }catch(Exception ex){
               addMessage("Erro ao realizar a busca de Alunos!");
           }
    }
    
    public void deletar(Profissional profissional){
        try{
                profissionalDAO.deletar(profissional);
        }catch(Exception ex){
            addMessage("Não foi possível excluir!");
            return;
        }
        addMessage("Removido com sucesso!");
        buscar();
        atualizarComponente("form");
    }
    
    public void onRowEdit(RowEditEvent event){
            profissional = (Profissional) event.getObject();
            try{
                profissionalDAO.salvar(profissional);
            }catch(Exception ex){
                addMessage("Não foi possível atualizar");
                return;
            }
            addMessage("Dados atualizados!");
            profissional = new Profissional();
    }
    public void onRowCancel (RowEditEvent event){
            addMessage("Edição cancelada!");
    }

    public void addMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }

    public void atualizarComponente(String id) {
        RequestContext.getCurrentInstance().update(id);
    }
    
    
    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public ProfissionalDAO getProfissionalDAO() {
        return profissionalDAO;
    }

    public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
        this.profissionalDAO = profissionalDAO;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }
    

}
