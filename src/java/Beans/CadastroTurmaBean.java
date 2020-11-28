package Beans;

import DAO.TurmaDAO;
import Entidades.Turma;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named(value = "cadastroTurmaBean")
@ViewScoped
public class CadastroTurmaBean implements Serializable {

    private Turma turma;
    TurmaDAO turmaDAO;

    public CadastroTurmaBean() {
        turmaDAO = new TurmaDAO();
        turma = new Turma();
    }

    @PostConstruct
    public void init() {

    }

    public void salvar() {
        try {
            turmaDAO.salvar(turma);
            addMessage("Dados inseridos com sucesso!");
        } catch (Exception ex) {
            addMessage("Dados não inseridos! " + ex);
            Logger.getLogger(CadastroTurmaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarComponente("formTurma");
        turma = new Turma();
        
    }

    public void addMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }

    public void atualizarComponente(String id) {
        RequestContext.getCurrentInstance().update(id);
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public TurmaDAO getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

   
       
}
