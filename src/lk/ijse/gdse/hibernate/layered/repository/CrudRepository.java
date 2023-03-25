package lk.ijse.gdse.hibernate.layered.repository;

public interface CrudRepository<T, ID> extends SuperRepository{

    ID save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);
}
