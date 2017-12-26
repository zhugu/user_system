package com.system.daoimpl;

import com.system.dao.AttendanceDAO;
import com.system.model.Attendance;
import com.system.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 徐文倩
 * 2017.12.21
 * 考勤管理部分功能的实现
 */
public class AttendanceDAOImpl implements AttendanceDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    @Override
    public List<Attendance> getAttendance(String userid) throws SQLException {
        String sql = "SELECT * FROM t_attendance WHERE userid = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{userid});
        return getAttendanceList(list);
    }

    private List<Attendance> getAttendanceList(List<Object> list){
        List<Attendance> attendanceList = new ArrayList<>();
        for(Object object : list){
            Map<String,Object> map = (Map<String, Object>) object;
            Attendance attendance = new Attendance((Integer)map.get ("id"),map.get("userid").toString(),(Date)map.get("date"),map.get("attendance").toString());
            attendance.setId((Integer)map.get("id"));
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
}
