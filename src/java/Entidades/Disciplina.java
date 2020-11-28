
package Entidades;

public final class Disciplina {
    /* Atributos */
    private Integer id;
    private String codigo;
    private String nome;
    private Integer cargaHoraria;
    
    
    public Disciplina (String nome) throws Exception{
        setNome(nome);
    }

    public Disciplina(int id, String codigo, String nome, Integer cargahoraria) {
        setId(id);
        setCodigo(codigo);
        setNome(nome);
        setCargahoraria (cargahoraria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargahoraria() {
        return cargaHoraria;
    }

    public void setCargahoraria(Integer cargahoraria) {
        this.cargaHoraria = cargahoraria;
    }
}
