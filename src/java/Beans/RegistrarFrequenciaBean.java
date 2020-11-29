package Beans;

import DAO.FrequenciaDAO;
import DAO.TurmaDAO;
import Entidades.Frequencia;
import Entidades.Profissional;
import Entidades.Turma;
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

@Named(value = "registrarFrequenciaBean")
@ViewScoped
public class RegistrarFrequenciaBean implements Serializable {

    private Integer id;
    private String idturma;
    private String idaluno;
    private String data;
    private String status;
    List<String> turma;
    TurmaDAO turmaDAO;
    Frequencia frequencia;
    FrequenciaDAO frequenciaDAO;
    
   
    public RegistrarFrequenciaBean() {
        
        turmaDAO = new TurmaDAO();
        frequencia = new Frequencia();
        frequenciaDAO = new FrequenciaDAO();
    }

    @PostConstruct
    public void init() {
        buscarTurma();
    }

    public void salvar() {
        try {
            frequenciaDAO.salvar(frequencia);
            addMessage("Registrado com Sucesso!");
        } catch (Exception ex) {
            addMessage("Erro ao registrar!");
            Logger.getLogger(CadastroProfissionalBean.class.getName()).log(Level.SEVERE, null, ex);
           return;
        }
        frequencia = new Frequencia();

    }
    public void buscarTurma() {
        try {
            List<Turma> turmas = turmaDAO.buscar();
            turma = new ArrayList<String>();
            for (int i = 0; i < turmas.size(); i++) {
                Turma d = turmas.get(i);
                String nomeTurmma = d.getNomeTurma();
                turma.add(nomeTurmma);
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

    public Integer getId() {
        return id;
    }

    public String getidturma() {
        return idturma;
    }

    public void setidturma(String idturma) {
        this.idturma = idturma;
    }

    public String getidaluno() {
        return idaluno;
    }

    public void setidaluno(String idaluno) {
        this.idaluno = idaluno;
    }
    public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getIdturma() {
        return idturma;
    }

    public void setIdturma(String idturma) {
        this.idturma = idturma;
    }

    public String getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(String idaluno) {
        this.idaluno = idaluno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTurma() {
        return turma;
    }

    public void setTurma(List<String> turma) {
        this.turma = turma;
    }

    public TurmaDAO getTurmaDAO() {
        return turmaDAO;
    }

    public void setTurmaDAO(TurmaDAO turmaDAO) {
        this.turmaDAO = turmaDAO;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public FrequenciaDAO getFrequenciaDAO() {
        return frequenciaDAO;
    }

    public void setFrequenciaDAO(FrequenciaDAO frequenciaDAO) {
        this.frequenciaDAO = frequenciaDAO;
    }
    
}
