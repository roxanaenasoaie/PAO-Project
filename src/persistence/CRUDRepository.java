package persistence;


import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<E> {

    public void save(E elem) throws SQLException;

    List<E> getAll();

}
