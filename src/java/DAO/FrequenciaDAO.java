package DAO;

import Entidades.Frequencia;
import Entidades.Turma;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FrequenciaDAO {
    
    Connection conexao;
    PreparedStatement ps;
    
    public void salvar (Frequencia frequencia) throws Exception {
        try {
            conexao = Conexao.getConnection();
            if (frequencia.getId() == null) {
                ps = conexao.prepareStatement("insert into frequencia(status, data, idturma, nomealuno, iddisciplina, matriculaAluno, nomeDocente) values(?, ?, ?, ?, ?, ?, ?)");

            } else {
                ps = conexao.prepareStatement("UPDATE frequencia set status=?, data=?, idturma=?, idaluno=?, iddisciplina=?, matriculaAluno=?, nomeDocente=?   where id=?");
                ps.setString(8, frequencia.getId().toString());
            }
            ps.setString(1, frequencia.getStatus());
            ps.setString(2, frequencia.getData());
            ps.setString(3, frequencia.getIdTurma());
            ps.setString(4, frequencia.getNomeAluno());
            ps.setString(5, frequencia.getIdDisciplina());
            ps.setString(6, frequencia.getMatricula());
            ps.setString(7, frequencia.getNomeDocente());
            
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - registro", ex);
        }
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sqle) {
            throw new Exception("Erro na execução do SQL - rodar query", sqle);
        }
    }
    
}
