/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Disciplina;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    
        public static List<Disciplina> listar() throws Exception
    {
        Connection conexao = Conexao.getConnection();
        PreparedStatement ps;
        ArrayList<Disciplina> disciplina = new ArrayList<>();
        try{
            ps = conexao.prepareStatement("select * from disciplina"); // obtem apena uma única informação

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Disciplina d = new Disciplina (resultSet.getInt("id"), resultSet.getString("nome"));
                disciplina.add(d);
            }
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - listar disciplina",ex);
        }
        return disciplina;
    }
    public static boolean salvar(Disciplina disciplina) throws Exception {
        Connection conexao = Conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("insert into `platum`.`disciplina` iddisciplina=?, nomedisciplina=?");//FIXME
            ps.setInt (1, disciplina.getId());
            ps.setString (2, disciplina.getNome());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
        return false;
    }    
    private Connection conexao;
    public List<Disciplina> buscar() throws Exception {
        
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("select * from disciplina");
            ResultSet resultSet = ps.executeQuery();

            List<Disciplina> disciplinas = new ArrayList<Disciplina>();

            while (resultSet.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(resultSet.getInt("id"));
                disciplina.setNome(resultSet.getString("nome"));
                disciplinas.add(disciplina);
            }
            Conexao.closeConnection();
            return disciplinas;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
    }
}
