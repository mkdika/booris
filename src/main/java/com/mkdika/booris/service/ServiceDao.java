package com.mkdika.booris.service;

import com.mkdika.booris.entity.TbBook;
import com.mkdika.booris.entity.TbBookAuthor;
import com.mkdika.booris.entity.TbBorrow;
import com.mkdika.booris.entity.TbCustomer;
import java.util.List;

/**
 *
 * @author maikel
 */
public interface ServiceDao {
    
    /*
        Generic Method:
        - Save (update)
        - Delete
    */
    public boolean save(Object obj);
    
    public boolean delete(Object obj);
    
    /*
        To truncate/ clear all data from tables
    */
    public boolean truncateDB();
    
    /*
        To init DDL to database
    */
    public boolean triggerInitDB();
    
    public List<TbBookAuthor> getTbBookAuthors();
    
    public List<TbBookAuthor> getTbBookAuthorActive();
    
    public List<TbBook> getTbBooks();
    
    public List<TbBook> getTbBookActive();
    
    public List<TbCustomer> getTbCustomers();
    
    public List<TbCustomer> getTbCustomerActive();
    
    public List<TbBorrow> getTbBorrows();
    
}
