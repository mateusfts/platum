package Entidades;

import java.util.Date;

public class Turma {
    /* Atributos */
    private Integer disciplinaId;
    private Integer semestreId;
    private Integer turmaId;
    private Integer docenteId;
    private String nomeTurma;
            
    public Turma (Integer disciplina, Integer semestre, Integer codturma, Integer docente, String nomeTurma) throws Exception {
        setDisciplinaId(disciplina) ;
        setSemestreId(semestre) ;
        setTurmaId(codturma) ;
        setDocenteId(docente) ;
        setNomeTurma(nomeTurma);
    } 

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Integer getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Integer semestreId) {
        this.semestreId = semestreId;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
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
}
