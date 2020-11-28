package DAO;

import Entidades.Curso;
import Entidades.Usuario;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    
        public static List<Curso> listar() throws Exception
    {
        Connection conexao = Conexao.getConnection();
        PreparedStatement ps;
        ArrayList<Curso> cursos = new ArrayList<>();
        try{
            ps = conexao.prepareStatement("select * from curso"); // obtem apena uma única informação

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Curso c = new Curso(resultSet.getInt("id"), resultSet.getString("nome"));
                cursos.add(c);
            }
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - listar cursos",ex);
        }
        return cursos;
    }
           public static boolean salvar(Curso curso) throws Exception {
        Connection conexao = Conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("insert into `platum`.`curso` idcurso=?, descricaocurso=?");//FIXME
            ps.setInt (1, curso.getId());
            ps.setString (2, curso.getNome());
           
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
        return false;
    }
}


