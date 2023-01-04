package com.shabatura.module3;

import com.shabatura.module3.config.FlywayUtil;
import com.shabatura.module3.service.ServiceMenu;

public class Main {
    public static void main(String[] args) {
        FlywayUtil flywayUtil = new FlywayUtil();
        flywayUtil.migrate();
        ServiceMenu menuService = new ServiceMenu();
        menuService.actionMenu();
    }
}
