package Beans;

import DAO.DisciplinaDAO;
import DAO.ProfissionalDAO;
import DAO.RelatorioDAO;
import Entidades.Disciplina;
import Entidades.Profissional;
import Entidades.Relatorio;
import java.io.Serializable;
import java.util.ArrayList;
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
//    String turma,disciplina,docente;
    
    DisciplinaDAO disciplinaDAO;
    List<String> disc;
    List<String> prof;
    ProfissionalDAO profissionalDAO;
            
    public RelatorioBean() {
    
       relatorioDAO = new RelatorioDAO();
       relatorios = null; 
       relatorio = new Relatorio();
       disciplinaDAO = new DisciplinaDAO();
       disc = null;
    }
    
    @PostConstruct
    public void init() {
       
            
    }
    
    

    public void pesquisar(){
        try{
                relatorios = relatorioDAO.buscar(relatorio);
        }catch(Exception ex){
            
                addMessage("Erro ao realizar consulta!");
        }
    }
    public void buscarDisciplina() {
        try {
            List<Disciplina> disciplinas = disciplinaDAO.buscar();
            disc = new ArrayList<String>();
            for (int i = 0; i < disciplinas.size(); i++) {
                Disciplina d = disciplinas.get(i);
                String nome = d.getNome();
                disc.add(nome);
            }
        } catch (Exception ex) {
            addMessage("Erro ao realizar a busca de disciplinas!");
        }
    }
    public void buscarDocente() {
        try {
            List<Profissional> profissionais = profissionalDAO.buscar();
            prof = new ArrayList<String>();
            for (int i = 0; i < profissionais.size(); i++) {
                Profissional d = profissionais.get(i);
                String nome = d.getNome();
                prof.add(nome);
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

//    public String getTurma() {
//        return turma;
//    }
//
//    public void setTurma(String turma) {
//        this.turma = turma;
//    }
//
//    public String getDisciplina() {
//        return disciplina;
//    }
//
//    public void setDisciplina(String disciplina) {
//        this.disciplina = disciplina;
//    }
//
//    public String getDocente() {
//        return docente;
//    }
//
//    public void setDocente(String docente) {
//        this.docente = docente;
//    }

    public DisciplinaDAO getDisciplinaDAO() {
        return disciplinaDAO;
    }

    public void setDisciplinaDAO(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    public List<String> getDisc() {
        return disc;
    }

    public void setDisc(List<String> disc) {
        this.disc = disc;
    }

    public List<String> getProf() {
        return prof;
    }

    public void setProf(List<String> prof) {
        this.prof = prof;
    }

    public ProfissionalDAO getProfissionalDAO() {
        return profissionalDAO;
    }

    public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
        this.profissionalDAO = profissionalDAO;
    }
    
    
    
}