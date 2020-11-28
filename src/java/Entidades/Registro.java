package Entidades;

public class Registro {
    /* Atributos */
    private Integer idSemestre;
    private Integer idDisciplina;
    private Integer idDocente;
    
    public Registro (Integer idsemestre, Integer iddisciplina, Integer iddocente) throws Exception {
       setIdSemestre(idsemestre) ;
       setIdDisciplina (iddisciplina) ;
       setIdDocente (iddocente) ;
    }
    
    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }
}
