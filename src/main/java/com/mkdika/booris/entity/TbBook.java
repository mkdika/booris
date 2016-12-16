package com.mkdika.booris.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author maikel
 */
@Entity
@Table(name = "tb_book", catalog = "booris", schema = "")
public class TbBook implements Serializable {

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
    @JoinColumn(name = "bookauthor", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private TbBookAuthor bookauthor;

    @NotNull(message = "Book Title cant null.")
    @NotEmpty(message = "Book Title cant empty.")
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;

    @NotNull(message = "Book ISBN cant null.")
    @NotEmpty(message = "Book ISBN cant empty.")
    @Size(min = 1, max = 50)
    @Column(name = "isbn")
    private String isbn;

    @NotNull(message = "Book Pages cant null.")
    @Column(name = "pages")
    private Integer pages;

    @Size(max = 100)
    @Column(name = "image")
    private String image;

    @NotNull(message = "Book QTY cant null.")
    @Column(name = "qty")
    private Integer qty;

    @NotNull
    @Column(name = "disable")
    private Boolean disable = false;

    /*
        Record logging field
     */
    @Column(name = "inputby")
    private String inputby;

    @Column(name = "inputdt")
    @Temporal(TemporalType.TIMESTAMP)
    public Date inputdate;

    public TbBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public TbBookAuthor getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(TbBookAuthor bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getInputby() {
        return inputby;
    }

    public void setInputby(String inputby) {
        this.inputby = inputby;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }
}
