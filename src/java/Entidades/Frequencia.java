package Entidades;

import java.util.Date;

public class Frequencia {
    /* Atributos */
    private Integer id;
    private String status;
    private Date data;
    private Integer idTurma;
    private Integer idAluno;

    public Frequencia(Integer id, String status, Date data, Integer idTurma, Integer idAluno) throws Exception {
        setStatus(status);
        setData(data);
        setIdTurma(idTurma);
        setIdAluno(idAluno);
    }
    
    public static void Salvar(Frequencia frequencia) {
        //chamar o metodo FrequenciaDAO.salvar
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }
}
