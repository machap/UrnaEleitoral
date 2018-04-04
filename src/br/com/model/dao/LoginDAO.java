package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paulo
 */
public class LoginDAO {
    
    private Connection con = null;
    
    public LoginDAO(){
        
        con = ConnectionFactory.getConnection();
    }
    
    public boolean checkLogin(String login, String senha){
        
        String sql = "SELECT login FROM tbUsuario WHERE login = ? AND senha = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
           
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return false;
    }
}
