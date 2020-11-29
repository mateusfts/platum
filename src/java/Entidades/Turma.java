package Entidades;

public class Turma {
    /* Atributos */
    private Integer disciplinaId;
    private String semestreId;
    private Integer Id;
    private Integer docenteId;
    private String nomeTurma;
            
    
    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(String semestreId) {
        this.semestreId = semestreId;
    }

    public Integer getId() {
        return Id;
    }

    public void setTurmaId(Integer turmaId) {
        this.Id = turmaId;
    }

    public Integer getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Integer docenteId) {
        this.docenteId = docenteId;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
}
