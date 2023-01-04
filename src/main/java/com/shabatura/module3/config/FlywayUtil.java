package com.shabatura.module3.config;

import org.flywaydb.core.Flyway;

public class FlywayUtil {
    public void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module3", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}
