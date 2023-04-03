package com.test.jdbc.MySQLJDBC.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
/***
 *
 *
 *
 * User: alok
 * Date: 02/04/23
 *
 */
@Configuration
public class JDBCServices {
    public String url="jdbc:mysql://172.17.0.3/Employee_tracker";
    @Autowired
    private Environment env;
    @Lazy
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSource customDataSource() {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create();
        dsBuilder.driverClassName ("com.mysql.cj.jdbc.Driver");
        //CustomDatabaseSettings dbSettings = <….>//Here obtain the settings from whereever you need
        dsBuilder.url(url);
        dsBuilder.username("root");
        dsBuilder.password("root@123");
        return dsBuilder.build();
    }
    @Lazy
    @Qualifier("customJdbcTemplate")
    @Bean
    public JdbcTemplate customJdbcTemplate() {
        return new JdbcTemplate(customDataSource());
    }
    public void setUrl(String url){
        this.url=url;
    }
}
