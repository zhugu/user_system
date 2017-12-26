package com.system.service;

import com.system.factory.ServiceFactory;
import com.system.model.Attendance;
import com.system.model.Republish;
import com.system.model.User;
import com.system.model.Wages;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author 徐文倩，缪瑞祥
 */
public class UserServiceTest {
    private UserService userService;
    private static String phone = null;
    private static String captcha = null;

    @Before
    public void setUp() throws Exception {
        userService = ServiceFactory.getUserServiceInstance();
    }

    @Test
    public void userLogin() throws Exception {
        Map<String, Object> map = userService.userLogin("101001", "001");
        //输出登陆成功与否的信息
        System.out.println(map.get("info").toString());
        System.out.println(map.get("user"));
        //取得该用户的权限组和相应权限项
        Map<String, List<String>> userPermissionMap = (Map<String, List<String>>) map.get("userPermissionMap");
        for (Map.Entry<String, List<String>> entry : userPermissionMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception{
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for (int i = 0;i<6;i ++){
            str.append(random.nextInt(10));
        }
        captcha = str.toString();
        phone = "15195226887";
        System.out.println(phone);
        System.out.println(captcha);
    }

    @Test
    public void phoneLogin() throws Exception {
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for (int i = 0;i<6;i ++){
            str.append(random.nextInt(10));
        }
        captcha = str.toString();
        phone = "15195226887";
        String number = captcha.toString();
        System.out.println(phone);
        System.out.println(captcha);
        Map<String, Object> map = userService.phoneLogin(phone,number,captcha);
        //输出登陆成功与否的信息
        System.out.println(map.get("info").toString());
        System.out.println(map.get("user"));
        //取得该用户的权限组和相应权限项
        Map<String, List<String>> userPermissionMap = (Map<String, List<String>>) map.get("userPermissionMap");
        for (Map.Entry<String, List<String>> entry : userPermissionMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + ", value= " + entry.getValue());
        }
    }
    @Test
    public void getUser() throws Exception {
        User user = userService.getUser("101001");
        System.out.println(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = userService.getUser("101008");
        user.setTel("13951011567");
        boolean flag = userService.updateUser(user);
        assertEquals(true,flag);
    }

    @Test
    public void getAttendance() throws Exception{
        List<Attendance> list = userService.getAttendance("101001");
        list.forEach(attendance -> System.out.println(attendance));
    }
    @Test
    public void getRP()throws Exception{
        List<Republish> list = userService.getRP("101003");
        list.forEach(republish -> System.out.println(republish));
    }
    @Test
    public void getWages()throws Exception{
        Wages wages = userService.getWages("101004");
       System.out.println(wages);
    }

}