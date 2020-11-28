package Beans;

import DAO.AlunoDAO;
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

@Named(value = "CadastroAlunoBean")
@ViewScoped
public class CadastroAlunoBean implements Serializable {

    private Aluno aluno;
    AlunoDAO alunoDAO;

    public CadastroAlunoBean() {
        alunoDAO = new AlunoDAO();
        aluno = new Aluno();
    }

    @PostConstruct
    public void init() {
    }

    public void salvar() {
        try {
            alunoDAO.salvar(aluno);
            addMessage("Dados inseridos com sucesso!");
        } catch (Exception ex) {
            addMessage("Dados não inseridos " + ex);
            Logger.getLogger(CadastroAlunoBean.class.getName()).log(Level.SEVERE, null, ex);
           return;
        }
        atualizarComponente("formAluno");
        aluno = new Aluno();

    }

    public void addMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        atualizarComponente("msg"); // atualiza o componente de mensagens 
    }

    public void atualizarComponente(String id) {
        RequestContext.getCurrentInstance().update(id);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

 
}
