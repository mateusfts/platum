package Beans;

import DAO.AlunoDAO;
import Entidades.Aluno;
import Entidades.Profissional;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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

@Named(value = "CadastroAlunoBean")
@ViewScoped
public class CadastroAlunoBean implements Serializable {

    private Aluno aluno;
    AlunoDAO alunoDAO;
    List<Aluno> alunos;
    

    public CadastroAlunoBean() {
        alunoDAO = new AlunoDAO();
        aluno = new Aluno();
        alunos = null;
        
    }

    @PostConstruct
    public void init() {
        buscar();
            
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
        buscar();
        atualizarComponente("form");
        aluno = new Aluno();

    }
    public void buscar(){
           try{
                alunos = alunoDAO.buscar();
           }catch(Exception ex){
               addMessage("Erro ao realizar a busca de Alunos!");
           }
    }
    public void deletar(Aluno aluno){
        try{
                alunoDAO.deletar(aluno);
        }catch(Exception ex){
            addMessage("Não foi possível excluir!");
            return;
        }
        addMessage("Removido com sucesso!");
        buscar();
        atualizarComponente("form");
    }
    public void onRowEdit(RowEditEvent event){
            aluno = (Aluno) event.getObject();
            try{
                alunoDAO.salvar(aluno);
            }catch(Exception ex){
                addMessage("Não fopi possível atualizar");
                return;
            }
            addMessage("Dados atualizados!");
            aluno = new Aluno();
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }    
    

    
 
}
