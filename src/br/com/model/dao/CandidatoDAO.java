package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author paulo
 */
public class CandidatoDAO {
    
    private Connection con = null;

    public CandidatoDAO() {
        con = ConnectionFactory.getConnection();
        
    }
      
    
}
