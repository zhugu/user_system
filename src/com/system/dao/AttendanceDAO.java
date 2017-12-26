package com.system.dao;

import com.system.model.Attendance;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 徐文倩
 * 2017.12.21
 */
public interface AttendanceDAO {
    /**
     * 根据工号查询学生的考勤信息
     * @param userid
     * @return
     * @throws SQLException
     */
    List<Attendance> getAttendance(String userid) throws SQLException;
}
