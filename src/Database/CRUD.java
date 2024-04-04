package Database;

import java.util.List;

public interface CRUD {

    public Object create(Object object);

    public boolean update(Object object);

    public boolean delete(Object object);

    public Object findBYid(int id);

    public List<Object> readAll();



}
