package daos;

public class MainApp {


    public static void main(String[] args) {

        Car car = new Car(7,"Nissan","Altima",2021,"Orange","WWW123");
        ConcreteDAO dao = new ConcreteDAO();
        dao.create(car);


    }
}
