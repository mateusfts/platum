package DAO;

import Entidades.Aluno;
import Entidades.Turma;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    Connection conexao;
    PreparedStatement ps;
        
    /* Métodos */
    public void salvar (Turma turma) throws Exception {
        try {
            conexao = Conexao.getConnection();
            if (turma.getId() == null) {
                ps = conexao.prepareStatement("insert into turma(iddisciplina, iddocente, idsemestre, nome) values(?, ?, ?, ?)");

            } else {
                ps = conexao.prepareStatement("UPDATE turma set iddisciplina=?, iddocente=?, idsemestre=?, nome=? where id=?");
                ps.setString(5, turma.getId().toString());
            }
            ps.setInt(1, turma.getDisciplinaId());
            ps.setInt(2, turma.getDocenteId());
            ps.setString(3,  turma.getSemestreId());
            ps.setString(4, turma.getNomeTurma());
        
            

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
     public List<Turma> buscar() throws Exception {
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("select * from turma");
            ResultSet resultSet = ps.executeQuery();

            List<Turma> turmas = new ArrayList<Turma>();

            while (resultSet.next()) {
                Turma turma = new Turma();
                turma.setId (resultSet.getInt("id"));
                turma.setNomeTurma(resultSet.getString("nome"));
                turma.setSemestreId(resultSet.getString("idsemestre"));
                turma.setDocenteId(resultSet.getInt("iddocente"));
                turma.setDisciplinaId(resultSet.getInt("iddisciplina"));
                
                turmas.add(turma);
            }
            Conexao.closeConnection();
            return turmas;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de tumas", ex);
        }
    }
     public void deletar(Turma turma) throws Exception{
        conexao = Conexao.getConnection();
        try{
            ps = conexao.prepareStatement("delete from turma where id=?");
            ps.setInt(1, turma.getId()); 
            ps.execute();
        }catch(Exception ex){
            throw new Exception("Não foi possível excluir!" + ex);
        }
    }
}
