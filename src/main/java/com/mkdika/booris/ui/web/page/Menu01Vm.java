package com.mkdika.booris.ui.web.page;

import com.mkdika.booris.ui.web.template.CrudFormTemplate;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author maikel
 */
public class Menu01Vm extends CrudFormTemplate {

    public Menu01Vm() {

    }

    @Init()
    public void init() {

    }

    @Command()
    public void pushme() {
        Map<String, Object> args = new HashMap<>();
        args.put("message", "Hello World!");
        args.put("price", 3_500_750);
        Executions.createComponents("/component/popmsg.zul", null, args);
    }
}
