package DAO;

import Entidades.Usuario;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    /* Métodos */
    public static Usuario buscar(String login, String senha) throws Exception
    {
        Connection conexao = Conexao.getConnection();
        PreparedStatement ps;
        try{
            ps = conexao.prepareStatement("select * from usuario where login=?, and senha=?"); // obtem apena uma única informação
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getString("nome"), resultSet.getString("login"), 
                                                resultSet.getString("senha"), resultSet.getInt("tipousuario"));
                return usuario;
            }
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - busca de usuário",ex);
        }
        return null;
    }
}
