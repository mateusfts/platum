package DAO;

import Entidades.Profissional;
import Entidades.Usuario;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfissionalDAO {
    
    Connection conexao;
    PreparedStatement ps;
    
    public void salvar(Profissional prof) throws Exception{
        try{
            conexao = Conexao.getConnection();
            if (prof.getId() == null) {                
                ps = conexao.prepareStatement("INSERT INTO profissional (nome, matricula, cpf, rg, datanasc, nomemae, sexo, telefone) values(?,?,?,?,?,?,?,?)");  // obtem apena uma única informação
            }else{
                ps = conexao.prepareStatement("UPDATE profissional set nome=?, matricula=?, cpf=?, rg=?, datanasc=?, nomemae=?, sexo=?, telefone=? where id=?");
                ps.setString(9, prof.getId().toString());
            }
        
             
            ps.setString(1, prof.getNome());
            ps.setString(2, prof.getMatricula());
            ps.setString(3, prof.getCPF());
            ps.setString(4, prof.getRG());
            ps.setString(5, prof.getDatanascimento()); //FIXMe
            ps.setString(6, prof.getNomemae());
            ps.setString(7, prof.getSexo());
            ps.setString(8, prof.getTelefone());
            
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - Inserção",ex);
        }
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sqle) {
            throw new Exception("Erro na execução do SQL - rodar query", sqle);
        }
    }
        
    
}


