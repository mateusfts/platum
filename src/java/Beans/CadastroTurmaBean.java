package Beans;

import DAO.DisciplinaDAO;
import DAO.ProfissionalDAO;
import DAO.TurmaDAO;
import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Profissional;
import Entidades.Turma;
import java.io.Serializable;
import java.util.ArrayList;
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

@Named(value = "cadastroTurmaBean")
@ViewScoped
public class CadastroTurmaBean implements Serializable {

    Turma turma;
    TurmaDAO turmaDAO;
    DisciplinaDAO disciplinaDAO;
    List<String> disciplina;
    ProfissionalDAO profissionalDAO;
    List<String> profissional;
    List<Turma> turmas;

    public CadastroTurmaBean() {
        turmaDAO = new TurmaDAO();
        turma = new Turma();
        disciplina = null;
        disciplinaDAO = new DisciplinaDAO();
        profissionalDAO = new ProfissionalDAO();
        turmas = null;

    }

    @PostConstruct
    public void init() {
        
        buscarDisciplina();
        buscarDocente();
        buscar();
    }

    public void salvar() {
        try {
            turmaDAO.salvar(turma);
            addMessage("Dados inseridos com sucesso!");
        } catch (Exception ex) {
            addMessage("Dados não inseridos! " + ex);
            Logger.getLogger(CadastroTurmaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        buscar();
        atualizarComponente("form");
        turma = new Turma();

    }
    public void buscar(){
           try{
                turmas = turmaDAO.buscar();
           }catch(Exception ex){
               addMessage("Erro ao realizar a busca de Turmas!");
           }
    }
    public void deletar(Turma turma){
        try{
                turmaDAO.deletar(turma);
        }catch(Exception ex){
            addMessage("Não foi possível excluir!");
            return;
        }
        addMessage("Removido com sucesso!");
        buscar();
        atualizarComponente("form");
    }
    public void onRowEdit(RowEditEvent event){
            turma = (Turma) event.getObject();
            try{
                turmaDAO.salvar(turma);
            }catch(Exception ex){
                addMessage("Não foi possível atualizar");
                return;
            }
            addMessage("Dados atualizados!");
            turma = new Turma();
    }
    public void onRowCancel (RowEditEvent event){
            addMessage("Edição cancelada!");
    }

    public void buscarDisciplina() {
        try {
            List<Disciplina> disciplinas = disciplinaDAO.buscar();
            disciplina = new ArrayList<String>();
            for (int i = 0; i < disciplinas.size(); i++) {
                Disciplina d = disciplinas.get(i);
                String nome = d.getNome();
                disciplina.add(nome);
            }
        } catch (Exception ex) {
            addMessage("Erro ao realizar a busca de disciplinas!");
        }
    }
    public void buscarDocente() {
        try {
            List<Profissional> profissionais = profissionalDAO.buscar();
            profissional = new ArrayList<String>();
            for (int i = 0; i < profissionais.size(); i++) {
                Profissional d = profissionais.get(i);
                String nome = d.getNome();
                profissional.add(nome);
            }
        } catch (Exception ex) {
            addMessage("Erro ao realizar a busca de disciplinas!");
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

    public DisciplinaDAO getDisciplinaDAO() {
        return disciplinaDAO;
    }

    public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public List<String> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<String> disciplina) {
        this.disciplina = disciplina;
    }

    public ProfissionalDAO getProfissionalDAO() {
        return profissionalDAO;
    }

    public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
        this.profissionalDAO = profissionalDAO;
    }

    public List<String> getProfissional() {
        return profissional;
    }

    public void setProfissional(List<String> profissional) {
        this.profissional = profissional;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    

}
