package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Eleitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author paulo
 */
public class EleitorDAO {
    
    private Connection con = null;
    
    public  EleitorDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public boolean salvar(Eleitor eleitor){
        
        String sql = "INSERT INTO tbEleitor(nome, cpf, cep, rua, bairro, numero) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try{
            
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, eleitor.getNome());
            stmt.setString(2, eleitor.getCpf());
            stmt.setString(3, eleitor.getCep());
            stmt.setString(4, eleitor.getRua());
            stmt.setString(5, eleitor.getBairro());
            stmt.setString(6, eleitor.getNumero());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch(SQLException ex){
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
}