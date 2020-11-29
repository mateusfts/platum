package Entidades;

public class Turma {
    /* Atributos */
    private String disciplinaId;
    private String semestreId;
    private Integer Id;
    private String docenteId;
    private String nomeTurma;
            
    
    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
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

    public String getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(String docenteId) {
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
