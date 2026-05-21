package Interfaces;
import java.util.List;
public class Manageable {
    void add(Object entity);
    void remove(String id);
    List<?> getAll();
}
