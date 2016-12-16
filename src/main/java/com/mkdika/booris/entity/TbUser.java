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

    @Column(name = "access_menu01")
    private Boolean accessMenu01;

    @Column(name = "access_menu02")
    private Boolean accessMenu02;

    @Column(name = "access_menu03")
    private Boolean accessMenu03;

    @Column(name = "access_menu04")
    private Boolean accessMenu04;

    @Column(name = "access_menu05")
    private Boolean accessMenu05;

    public TbUser() {
    }

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

    public Boolean getAccessMenu01() {
        return accessMenu01;
    }

    public void setAccessMenu01(Boolean accessMenu01) {
        this.accessMenu01 = accessMenu01;
    }

    public Boolean getAccessMenu02() {
        return accessMenu02;
    }

    public void setAccessMenu02(Boolean accessMenu02) {
        this.accessMenu02 = accessMenu02;
    }

    public Boolean getAccessMenu03() {
        return accessMenu03;
    }

    public void setAccessMenu03(Boolean accessMenu03) {
        this.accessMenu03 = accessMenu03;
    }

    public Boolean getAccessMenu04() {
        return accessMenu04;
    }

    public void setAccessMenu04(Boolean accessMenu04) {
        this.accessMenu04 = accessMenu04;
    }

    public Boolean getAccessMenu05() {
        return accessMenu05;
    }

    public void setAccessMenu05(Boolean accessMenu05) {
        this.accessMenu05 = accessMenu05;
    }
}
