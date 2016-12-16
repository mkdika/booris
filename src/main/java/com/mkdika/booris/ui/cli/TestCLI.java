package com.mkdika.booris.ui.cli;

import com.mkdika.booris.helper.AppUtil;

/**
 *
 * @author maikel
 */
public class TestCLI {

    public static void main(String[] args) {
        // init DDL to database
        AppUtil.getService().triggerInitDB();
        
        // CLEAR EXISTING DB DATA MANUALLY
        if (AppUtil.getService().truncateDB()) {
            System.out.println("Truncate existing DB Data done!");
        }
        System.out.println("");
        
        // CREATE DEFAULT USER
        // USER: admin
        // PASSWORD: admin
        AppUtil.getService().createDefaultUser();

    }
}
