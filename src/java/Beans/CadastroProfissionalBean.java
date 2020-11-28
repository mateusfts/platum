package Beans;

import DAO.ProfissionalDAO;
import Entidades.Aluno;
import Entidades.Profissional;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "cadastroProfissionalBean")
@ViewScoped
public class CadastroProfissionalBean implements Serializable {
      private Profissional prof;
      ProfissionalDAO profissionalDAO;
//    private Integer id;
//    private String nome;
//    private String matricula;
//    private String CPF;
//    private String RG;
//    private String datanascimento;
//    private String nomemae;
//    private String sexo;
//    private Integer telefone;
//    private Profissional Profissional;
   
    public CadastroProfissionalBean() {
        profissionalDAO = new ProfissionalDAO();
        prof = new Profissional();
    }

    @PostConstruct
    public void init() {

    }

     public void salvar() {
        try {
            profissionalDAO.salvar(prof);
            addMessage("Dados inseridos com sucesso!");
        } catch (Exception ex) {
            addMessage("Dados não inseridos " + ex);
            Logger.getLogger(CadastroProfissionalBean.class.getName()).log(Level.SEVERE, null, ex);
           return;
        }
        
        atualizarComponente("formProfissional");
        prof = new Profissional();

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
        return prof;
    }

    public void setProfissional(Profissional profissional) {
        this.prof = profissional;
    }

    public ProfissionalDAO getProfissionalDAO() {
        return profissionalDAO;
    }

    public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
        this.profissionalDAO = profissionalDAO;
    }

}
