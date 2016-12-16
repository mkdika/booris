package com.mkdika.booris.ui.web.page;

import com.mkdika.booris.entity.TbUser;
import com.mkdika.booris.helper.AppUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author maikel
 */
public class MainPageVm {
    
    private String appInfo = "Booris (Book Rent Information System)";
    private Boolean menu01,menu02,menu03,menu04,menu05;
    private String selectedMenu;
    
    public MainPageVm() {
        
    }
    
    @Init
    public void init() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        TbUser tbuser = AppUtil.getWebService().getTbUserActiveByUid(user.getUsername());
        
        // set global session attribute for logged User
        // Visible authorized menu
        if (tbuser != null) {
            Sessions.getCurrent().setAttribute("user", tbuser);
            setAppInfo(getAppInfo()+" - USER: " + user.getUsername());
            
            setMenu01(tbuser.getAccessMenu01());
            setMenu02(tbuser.getAccessMenu02());
            setMenu03(tbuser.getAccessMenu03());
            setMenu04(tbuser.getAccessMenu04());
            setMenu05(tbuser.getAccessMenu05());
        }                        
        setSelectedMenu("/page/home.zul");
    }
    
    @Command
    public void logout() {
        Sessions.getCurrent().removeAttribute("user");
        Executions.sendRedirect("/j_spring_security_logout");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openHome() {
        setSelectedMenu("/page/home.zul");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openMenu01() {
        setSelectedMenu("/page/menu01.zul");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openMenu02() {
        setSelectedMenu("/page/menu02.zul");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openMenu03() {
        setSelectedMenu("/page/menu03.zul");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openMenu04() {
        setSelectedMenu("/page/menu04.zul");
    }
    
    @Command
    @NotifyChange({"selectedMenu"})
    public void openMenu05() {
        setSelectedMenu("/page/menu05.zul");
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Boolean getMenu01() {
        return menu01;
    }

    public void setMenu01(Boolean menu01) {
        this.menu01 = menu01;
    }

    public Boolean getMenu02() {
        return menu02;
    }

    public void setMenu02(Boolean menu02) {
        this.menu02 = menu02;
    }

    public Boolean getMenu03() {
        return menu03;
    }

    public void setMenu03(Boolean menu03) {
        this.menu03 = menu03;
    }

    public Boolean getMenu04() {
        return menu04;
    }

    public void setMenu04(Boolean menu04) {
        this.menu04 = menu04;
    }

    public Boolean getMenu05() {
        return menu05;
    }

    public void setMenu05(Boolean menu05) {
        this.menu05 = menu05;
    }

    public String getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(String selectedMenu) {
        this.selectedMenu = selectedMenu;
    }                    
}
