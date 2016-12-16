package com.mkdika.booris.service;

import com.mkdika.booris.entity.TbBook;
import com.mkdika.booris.entity.TbBookAuthor;
import com.mkdika.booris.entity.TbBorrow;
import com.mkdika.booris.entity.TbCustomer;
import com.mkdika.booris.entity.TbUser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author maikel
 */
@Service("serviceDao")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = false)
    public boolean save(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Object obj) {
        getCurrentSession().delete(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean truncateDB() {
        getCurrentSession().createSQLQuery("DELETE FROM booris.tb_borrow_book;").executeUpdate();
        getCurrentSession().createSQLQuery("DELETE FROM booris.tb_borrow;").executeUpdate();
        getCurrentSession().createSQLQuery("DELETE FROM booris.tb_customer;").executeUpdate();
        getCurrentSession().createSQLQuery("DELETE FROM booris.tb_book;").executeUpdate();
        getCurrentSession().createSQLQuery("DELETE FROM booris.tb_book_author;").executeUpdate();
        return true;
    }

    @Override
    public boolean triggerInitDB() {
        getCurrentSession();
        return true;
    }

    @Override
    public List<TbBookAuthor> getTbBookAuthors() {
        List<TbBookAuthor> list = getCurrentSession()
                .createQuery("FROM TbBookAuthor a ORDER BY a.authorname ASC").list();
        return list;
    }

    @Override
    public List<TbBookAuthor> getTbBookAuthorActive() {
        List<TbBookAuthor> list = getCurrentSession()
                .createQuery("FROM TbBookAuthor a WHERE a.disable = false ORDER BY a.authorname ASC").list();
        return list;
    }

    @Override
    public List<TbBook> getTbBooks() {
        List<TbBook> list = getCurrentSession()
                .createQuery("FROM TbBook a ORDER BY a.title ASC").list();
        return list;
    }

    @Override
    public List<TbBook> getTbBookActive() {
        List<TbBook> list = getCurrentSession()
                .createQuery("FROM TbBook a WHERE a.disable = false ORDER BY a.title ASC").list();
        return list;
    }

    @Override
    public List<TbCustomer> getTbCustomers() {
        List<TbCustomer> list = getCurrentSession()
                .createQuery("FROM TbCustomer a ORDER BY a.customername ASC").list();
        return list;
    }

    @Override
    public List<TbCustomer> getTbCustomerActive() {
        List<TbCustomer> list = getCurrentSession()
                .createQuery("FROM TbCustomer a WHERE a.disable = false ORDER BY a.customername ASC").list();
        return list;
    }

    @Override
    public List<TbBorrow> getTbBorrows() {
        List<TbBorrow> list = getCurrentSession()
                .createQuery("FROM TbBorrow a ORDER BY a.transactionDate ASC").list();
        return list;
    }

    @Override
    public List<TbUser> getTbUsers() {
        List<TbUser> list = getCurrentSession()
                .createQuery("FROM TbUser a ORDER BY a.uid ASC").list();
        return list;
    }

    @Override
    public TbUser getTbUserActiveByUid(String uid) {
        List<TbUser> list = getCurrentSession()
                .createQuery("FROM TbUser a WHERE a.uid = :uid AND a.disable = false")
                .setParameter("uid", uid)
                .list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = false)
    public boolean createDefaultUser() {
        if (getTbUserActiveByUid("admin") == null) {
            TbUser t = new TbUser();
            t.setUid("admin");
            t.setPassword("ceb4f32325eda6142bd65215f4c0f371"); // admin
            t.setDisable(false);
            t.setAccessMenu01(true);
            t.setAccessMenu02(true);
            t.setAccessMenu03(true);
            t.setAccessMenu04(true);
            t.setAccessMenu05(true);
            save(t);
            return true;
        }
        return false;
    }
}
