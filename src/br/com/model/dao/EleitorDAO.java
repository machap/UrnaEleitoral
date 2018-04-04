package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Eleitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Eleitor> retornarDados(){
        
        String sql = "SELECT * FROM tbEleitor";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Eleitor> eleitores = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Eleitor eleitor  = new Eleitor();

                eleitor.setId(rs.getInt("id"));
                eleitor.setNome(rs.getString("nome"));
                eleitor.setCpf(rs.getString("cpf"));
                eleitor.setCep(rs.getString("cep"));
                eleitor.setRua(rs.getString("rua"));
                eleitor.setBairro(rs.getString("bairro"));
                eleitor.setNumero(rs.getString("numero"));
                
                eleitores.add(eleitor);

            }
        } catch (SQLException ex) {

            System.err.println("Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return eleitores;
    }
        
}