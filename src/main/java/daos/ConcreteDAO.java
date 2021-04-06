package daos;

import java.sql.*;
import java.util.List;

public class ConcreteDAO<T> implements DAO<T>{
    String dbUrl;
    String username;
    String password;
    Connection connection = null;

    public ConcreteDAO(String dbURL,String username, String password){
        this.dbUrl = dbURL;
        this.username = username;
        this.password = password;
    }

    public T findById(int id) {

        try{
            connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM car WHERE id = ?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            return (T) rs; //NO IDEA IF THIS IS CORRECT LOL
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public List findAll() {
        return null;
    }

    public T update(T dto) {
        return null;
    }

    public T create(T dto) {
        return null;
    }

    public void delete(int id) {

    }
}
