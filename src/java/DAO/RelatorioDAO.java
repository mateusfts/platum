package DAO;


import Entidades.Relatorio;
import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RelatorioDAO {
        
    Connection conexao;
    PreparedStatement ps;
    
    
    public List<Relatorio> buscar() throws Exception {
        try {
            conexao = Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT *  FROM aluno WHERE idprofissional = \"Leandro\" AND iddisciplina = \"Estrutura de Dados\"");
            ResultSet resultSet = ps.executeQuery();

            List<Relatorio> relatorios = new ArrayList<Relatorio>();

            while (resultSet.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setIdsemestre(resultSet.getString("idsemestre"));
                relatorio.setIddisciplina(resultSet.getString("iddisciplina"));
                relatorio.setIddocente(resultSet.getString("idprofissional"));
                
                relatorios.add(relatorio);
            }
            Conexao.closeConnection();
            return relatorios;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
    }
    
}
