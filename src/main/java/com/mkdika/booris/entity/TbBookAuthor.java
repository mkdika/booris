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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author maikel
 */
@Entity
@Table(name = "tb_book_author", catalog = "booris", schema = "")
public class TbBookAuthor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Author Name cant null.")
    @NotEmpty(message = "Author Name cant empty.")
    @Size(min = 1, max = 100)
    @Column(name = "authorname")
    private String authorname;

    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "disable")
    private Boolean disable = false;

    /*
        Bi-directional relation to class TbBook
     */
    @OptimisticLock(excluded = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "bookauthor")
    private List<TbBook> books;

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

    public TbBookAuthor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public List<TbBook> getBooks() {
        return books;
    }

    public void setBooks(List<TbBook> books) {
        this.books = books;
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
