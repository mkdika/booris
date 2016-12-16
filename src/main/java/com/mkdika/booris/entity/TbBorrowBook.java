package com.mkdika.booris.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maikel
 */
@Entity
@Table(name = "tb_borrow_book", catalog = "booris", schema = "")
public class TbBorrowBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    /*
        Bi-directional relation to class TbBookAuthor
     */
    @NotNull(message = "Book Author cant null.")
    @JoinColumn(name = "borrowid", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private TbBorrow borrowid;

    /*
        Uni-directional relation to class TbBook
     */
    @JoinColumn(name = "bookid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TbBook book;

    @NotNull(message = "QTY cant null.")
    @Column(name = "qty")
    private Integer qty;

    public TbBorrowBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TbBorrow getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(TbBorrow borrowid) {
        this.borrowid = borrowid;
    }

    public TbBook getBook() {
        return book;
    }

    public void setBook(TbBook book) {
        this.book = book;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
