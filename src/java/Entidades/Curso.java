package Entidades;

public class Curso {
    /* Atributos */
    private Integer id;
    private String nome;
    
    public Curso (String nome) throws Exception{
        setNome(nome);
    }

    public Curso(int id, String nome) {
        setId(id);
        setNome(nome);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
