package lk.ijse.gdse.hibernate.layered.repository;

import org.hibernate.Session;

public interface SuperRepository {

    void setSession(Session session);
}
