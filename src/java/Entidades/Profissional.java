
package Entidades;

import DAO.ProfissionalDAO;
import java.util.Date;

public class Profissional {
    /* Atributos */
    private Integer id;
    private String nome;
    private String matricula;
    private String CPF;
    private String RG;
    private String datanascimento;
    private String nomemae;
    private String sexo;
    private String telefone;
    
//    public Profissional (Integer id, String nome, String matricula, String CPF, String RG, Date datanascimento, String nomemae, String sexo,String telefone, String CEP, String logradouro, String numero, String bairro){        
//        this.nome = nome;
//        this.matricula = matricula;
//        this.CPF = CPF;
//        this.RG = RG;
//        this.datanascimento = datanascimento;
//        this.nomemae = nomemae;
//        this.sexo = sexo;
//        this.telefone = telefone;
//       
//    }
    
//    public static void Salvar(Profissional profissional) throws Exception {
//        ProfissionalDAO.salvar(profissional);
//    }
//
//    public Profissional() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

    
