package daos;

import java.sql.SQLException;
import java.util.List;

public class MainApp {


    public static void main(String[] args) {
        ConcreteDAO dao = new ConcreteDAO();

//        Car car1 = new Car(2,"Nissan","Altima",2021,"Orange","WWW123");
//        dao.create(car1);

        //dao.delete(7);

        Car car2  = dao.findById(2);
//        System.out.println(car2.toString()+"\n\n");

        dao.update(car2);

        List<Car> carList = dao.findAll();
        for(int i=0;i<carList.size();i++) {
            System.out.println(carList.get(i).toString());
        }


    }
}
