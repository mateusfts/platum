package DAO;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Profissional;
import Entidades.Usuario;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
   
    public List<Profissional> buscar() throws Exception {
        
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("select * from profissional");
            ResultSet resultSet = ps.executeQuery();

            List<Profissional> profissionais = new ArrayList<Profissional>();

            while (resultSet.next()) {
                Profissional profissional = new Profissional();
                profissional.setId(resultSet.getInt("id"));
                profissional.setNome(resultSet.getString("nome"));
                profissional.setMatricula(resultSet.getString("matricula"));
                profissional.setCPF(resultSet.getString("cpf"));
                profissional.setRG(resultSet.getString("rg"));
                profissional.setDatanascimento(resultSet.getString("datanasc"));
                profissional.setNomemae(resultSet.getString("nomemae"));
                profissional.setSexo(resultSet.getString("sexo"));
                profissional.setTelefone(resultSet.getString("telefone"));
                profissionais.add(profissional);
            }
            Conexao.closeConnection();
            return profissionais;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de profissionais", ex);
        }
    }
    public void deletar(Profissional profissional) throws Exception{
        conexao = Conexao.getConnection();
        try{
            ps = conexao.prepareStatement("delete from profissional where id=?");
            ps.setInt(1, profissional.getId());
            ps.execute();
        }catch(SQLException ex){
            throw new Exception("Não foi possível excluir!" + ex);
        }
    }
        
    
}


