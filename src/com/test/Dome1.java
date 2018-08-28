package com.test;

import com.dao.PhoneInfoDAO;
import com.dao.PhoneInterface;
import com.entity.PhoneInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Dome1 {
    public static void main(String[] args) {
        PhoneInterface phoneInterface=new PhoneInfoDAO();
        List<PhoneInfo> phoneInfos= phoneInterface.getPhoneByName("魅蓝");
    }
}
