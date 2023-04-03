package com.test.jdbc.MySQLJDBC;
import com.test.jdbc.MySQLJDBC.services.JDBCServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
/***
 *
 *
 *
 * User: alok
 * Date: 02/04/23
 *
 */
@RestController
public class JDBCController {
    @Autowired
    JDBCServices jdbcServices;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/getQueryData")
    public List<Map<String, Object>> getQueryData(){
        jdbcServices.setUrl ("jdbc:mysql://172.17.0.3/Employee_tracker");
        jdbcServices.customDataSource ();
        String query="select * from Employee_tracker.employee";

        return jdbcTemplate.queryForList(query);
    }
    @GetMapping("/getQueryDatastudent")
    public List<Map<String, Object>> getQueryDataStudent(){
        jdbcServices.setUrl ("jdbc:mysql://172.17.0.3/student_tracker");
        jdbcServices.customDataSource ();
        String query="select * from student_tracker.student";

        return jdbcTemplate.queryForList(query);
    }
}
