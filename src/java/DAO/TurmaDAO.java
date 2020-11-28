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
                ps = conexao.prepareStatement("insert into turma(iddisciplina, iddocente, idsemestre, nometurma) values(?, ?, ?, ?)");

            } else {
                ps = conexao.prepareStatement("update set turma(iddisciplina=?, iddocente=?, idsemestre=?, nometurma=? where id=?)");
                ps.setString(8, turma.getId().toString());
            }
            ps.setInt(1, turma.getDisciplinaId());
            ps.setInt(2, turma.getDocenteId());
            ps.setInt(3,  turma.getSemestreId());
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
}
