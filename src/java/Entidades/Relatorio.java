package Entidades;

public class Relatorio {
    /* Atributos */
    private String idturma;
    private String iddisciplina;
    private String iddocente;
    private String nomeAluno;
    private String matricula;
    
//    public Registro (Integer idsemestre, Integer iddisciplina, Integer iddocente) throws Exception {
//       setIdSemestre(idsemestre) ;
//       setIdDisciplina (iddisciplina) ;
//       setIdDocente (iddocente) ;
//    }

    public String getIdturma() {
        return idturma;
    }

    public void setIdturma(String idturma) {
        this.idturma = idturma;
    }

    public String getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(String iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getIddocente() {
        return iddocente;
    }

    public void setIddocente(String iddocente) {
        this.iddocente = iddocente;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
        
    
    
}
