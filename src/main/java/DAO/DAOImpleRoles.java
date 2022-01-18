package DAO;

import bd.RolesEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class DAOImpleRoles {

    public void saveRoles(RolesEntity rolesEntity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rolesEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<RolesEntity> getAllRoles(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RolesEntity> listR=session.createQuery("FROM RolesEntity ").list();
        session.getTransaction().commit();
        session.close();
        return listR;
    }

    public void updateRoles(RolesEntity rolesEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(rolesEntity);
        session.getTransaction().commit();
        session.close();
    }
    public RolesEntity getRolesId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from RolesEntity where id=:id");
        query.setInteger("id", id);
        RolesEntity rolesEntity = (RolesEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return rolesEntity;
    }
    public void deleteRoles(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from RolesEntity where id=:id");
        query.setInteger("id",id);
        RolesEntity rolesEntity = (RolesEntity) query.uniqueResult();
        session.delete(rolesEntity);
        session.getTransaction().commit();
        session.close();
    }






}
