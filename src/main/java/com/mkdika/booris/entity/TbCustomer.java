package com.mkdika.booris.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tb_customer", catalog = "booris", schema = "")
public class TbCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Customer Name cant null.")
    @NotEmpty(message = "Customer Name cant empty.")
    @Size(min = 1, max = 100)
    @Column(name = "customername")
    private String customername;

    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "disable")
    private Boolean disable = false;

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

    public TbCustomer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
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
