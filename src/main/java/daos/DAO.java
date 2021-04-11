package daos;

import java.util.List;

public interface DAO<T> {

    public Car findById(int id);
    public List findAll();
    public Car update(Car dto);
    public Car create(Car dto);
    public void delete(int id);
}
