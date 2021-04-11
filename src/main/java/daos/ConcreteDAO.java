package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcreteDAO implements DAO {

    Connection connection;

    public ConcreteDAO(){
        connection = ConnectionFactory.getConnection();
    }


    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));

        return car;
    }

    public Car findById(int id) {

        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM car WHERE id = ?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                return extractCarFromResultSet(rs);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public List findAll() {
        List<Car> carList = new ArrayList<Car>();

        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM car ORDER BY id");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Car car = extractCarFromResultSet(rs);
                carList.add(car);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return carList;
    }

    public Car update(Car car) {
        try {
            String id = "";
            id += car.getId();

            PreparedStatement pstmt = connection.prepareStatement("UPDATE car SET id = ?,make = ?, model = ?, year = ?, color = ?, vin = ? WHERE id = "+id);
            pstmt.setInt(1,car.getId());
            pstmt.setString(2,car.getMake());
            pstmt.setString(3,car.getModel());
            pstmt.setInt(4,car.getYear());
            pstmt.setString(5,"Yellow");
            pstmt.setString(6,car.getVin());
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Car create(Car car) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO car(id,make,model,year,color,vin) VALUES(?,?,?,?,?,?)");
            pstmt.setInt(1,car.getId());
            pstmt.setString(2,car.getMake());
            pstmt.setString(3,car.getModel());
            pstmt.setInt(4,car.getYear());
            pstmt.setString(5,car.getColor());
            pstmt.setString(6,car.getVin());
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {

        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM car WHERE id = ?");
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
