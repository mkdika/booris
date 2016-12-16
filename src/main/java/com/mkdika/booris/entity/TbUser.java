package com.mkdika.booris.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author maikel
 */
@Entity
@Table(name = "tb_user", catalog = "booris", schema = "")
public class TbUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id    
    @NotNull(message = "User ID cant null.")
    @NotEmpty(message = "User ID cant empty.")
    @Size(min = 1, max = 100)
    @Column(name = "uid")
    private String uid;
    
    @NotNull(message = "Password cant null.")
    @NotEmpty(message = "Password cant empty.")
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "disable")
    private Boolean disable;
    
    public TbUser() {}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }                
}
