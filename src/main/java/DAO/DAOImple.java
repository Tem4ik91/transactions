package DAO;

import bd.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.Queue;

public class DAOImple {

    public void saveUsers(UsersEntity usersEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(usersEntity);
        tx1.commit();
        session.close();
    }

    public List<UsersEntity> getAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<UsersEntity> list= session.createQuery("FROM UsersEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void update(UsersEntity usersEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usersEntity);
        session.getTransaction().commit();
        session.close();
    }

    public UsersEntity getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM UsersEntity WHERE id =:id");
        query.setInteger("id", id);
        UsersEntity usersEntity = (UsersEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return usersEntity;
    }

    public void deleteUsers(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM UsersEntity WHERE id =: id");
        query.setInteger("id", id);
        UsersEntity usersEntity = (UsersEntity) query.uniqueResult();
        session.delete(usersEntity);
        session.getTransaction().commit();
        session.close();
    }


}
