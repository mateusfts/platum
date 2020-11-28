package Beans;

import Entidades.Frequencia;
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

@Named(value = "registrarFrequenciaBean")
@ViewScoped
public class RegistrarFrequenciaBean implements Serializable {

    private Integer id;
    private String idturma;
    private String idaluno;
    private String data;
    private String status;
   
    public RegistrarFrequenciaBean() {

    }

    @PostConstruct
    public void init() {

    }

    public void salvar() {
//        Frequencia frequencia = new Frequencia();
//        
//        try {
//            Frequencia.Salvar(frequencia);
//        } catch (Exception e) {
//        }

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

}
