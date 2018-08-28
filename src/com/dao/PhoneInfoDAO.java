package com.dao;

import com.entity.PhoneInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneInfoDAO implements PhoneInterface{
    @Override
    public List<PhoneInfo> listAll() {
        String sql="select * from PhoneInfo";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<PhoneInfo> models=new ArrayList<>();
        PhoneInfo model=null;
        try {
            while (rs.next()){
                model=new PhoneInfo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("brand")
                );
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return models;
    }

    @Override
    public PhoneInfo getPhoneById(int id) {
        String sql="select * from PhoneInfo where id=?";
        Object[] in={id};
        ResultSet rs= DBUtil.executeQuery(sql,in);
        PhoneInfo model=null;
        try {
            while (rs.next()){
                model=new PhoneInfo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("brand")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return model;
    }

    @Override
    public List<PhoneInfo> getPhoneByName(String name) {
        String sql="select * from PhoneInfo where name like '%"+name+"%'";
        ResultSet rs= DBUtil.executeQuery(sql);
        List<PhoneInfo> models=new ArrayList<>();
        PhoneInfo model=null;
        try {
            while (rs.next()){
                model=new PhoneInfo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("brand")
                );
            }
            models.add(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return models;
    }

    @Override
    public int update(PhoneInfo phoneInfo) {
        String sql="update PhoneInfo set name=?,price=?,brand=? where id=?";
        Object[] in={phoneInfo.getName(),phoneInfo.getPrice(),phoneInfo.getBrand(),phoneInfo.getId()};
        return DBUtil.executeUpdate(sql,in);
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from PhoneInfo where id=?";
        Object[] in={id};
        DBUtil.executeUpdate(sql,in);
        return false;
    }

    @Override
    public int add(PhoneInfo phoneInfo) {
        String sql="insert into PhoneInfo values(?,?,?,?)";
        Object[] in={phoneInfo.getId(),phoneInfo.getName(),phoneInfo.getPrice(),phoneInfo.getBrand()};
        return DBUtil.executeUpdate(sql,in);
    }
}
