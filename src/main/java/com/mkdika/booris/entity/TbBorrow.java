package com.mkdika.booris.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OptimisticLock;

/**
 *
 * @author maikel
 */
@Entity
@Table(name = "tb_borrow", catalog = "booris", schema = "")
public class TbBorrow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Transaction Date cant null.")
    @Column(name = "transaction_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    
    /*
        Transaction Type:
        0 = Return Book
        1 = Borrow Book
    */
    @NotNull(message = "Transaction Type cant null.")
    @Column(name = "transaction_type")
    private Integer transactionType;
    
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    
    /*
        Uni-directional relation to class TbCustomer
    */
    @JoinColumn(name = "customerid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TbCustomer customer;
    
    /*
        Bi-directional relation to class TbBook
    */
    @OptimisticLock(excluded = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "borrowid")    
    private List<TbBorrowBook> borrowBookList;
    
    /*
        Record logging field
        Uni-directional relation to class TbBookAuthor
     */
    @JoinColumn(name = "inputby", referencedColumnName = "uid")
    @ManyToOne(fetch = FetchType.EAGER)
    private TbUser inputby;
    
    @Column(name = "inputdt")
    @Temporal(TemporalType.TIMESTAMP)
    public Date inputdate;

    public TbBorrow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TbCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TbCustomer customer) {
        this.customer = customer;
    }

    public List<TbBorrowBook> getBorrowBookList() {
        return borrowBookList;
    }

    public void setBorrowBookList(List<TbBorrowBook> borrowBookList) {
        this.borrowBookList = borrowBookList;
    }

    public TbUser getInputby() {
        return inputby;
    }

    public void setInputby(TbUser inputby) {
        this.inputby = inputby;
    }
   
    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }        
}
