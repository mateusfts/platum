package DAO;

import Entidades.Aluno;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    Connection conexao;
    PreparedStatement ps;

    /* Métodos */
    public void salvar(Aluno aluno) throws Exception {
        try {
            conexao = Conexao.getConnection();
            if (aluno.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO aluno(cpf,nome,datanasc,nomemae,nomepai,sexo,telefone,matAluno) values(?,?,?,?,?,?,?,?)");

            } else {
                ps = conexao.prepareStatement("UPDATE aluno set cpf=?, nome=?, datanasc=?, nomemae=?, nomepai=?, sexo=?, telefone=?, matAluno=? where id=?");
                ps.setString(9, aluno.getId().toString());
            }
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNomecompleto());
            ps.setString(3, aluno.getDatadenascimento());
            ps.setString(4, aluno.getNomeMae());
            ps.setString(5, aluno.getNomePai());
            ps.setString(6, aluno.getIdSexo());
            ps.setString(7, aluno.getTelefone());
            ps.setString(8, aluno.getMatAluno());
            

        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - inserção", ex);
        }
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sqle) {
            throw new Exception("Erro na execução do SQL - rodar query", sqle);
        }
    }

    public List<Aluno> buscar() throws Exception {
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("select * from aluno");
            ResultSet resultSet = ps.executeQuery();

            List<Aluno> alunos = new ArrayList<Aluno>();

            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getInt("id"));
                aluno.setCpf(resultSet.getString("cpf"));
                aluno.setDatadenascimento(resultSet.getString("datanasc"));
                aluno.setIdSexo(resultSet.getString("sexo"));
                aluno.setNomeMae(resultSet.getString("nomemae"));
                aluno.setNomePai(resultSet.getString("nomepai"));
                aluno.setNomecompleto(resultSet.getString("nome"));
                aluno.setTelefone(resultSet.getString("telefone"));
                aluno.setMatAluno(resultSet.getString("matAluno"));
                alunos.add(aluno);
            }
            Conexao.closeConnection();
            return alunos;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
    }
    
    public void deletar(Aluno aluno) throws Exception{
        conexao = Conexao.getConnection();
        try{
            ps = conexao.prepareStatement("delete from aluno where id=?");
            ps.setInt(1, aluno.getId()); 
            ps.execute();
        }catch(Exception ex){
            throw new Exception("Não foi possível excluir!" + ex);
        }
    }

}
