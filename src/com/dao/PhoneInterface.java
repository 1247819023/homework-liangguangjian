package com.dao;

import com.entity.PhoneInfo;

import java.util.List;

public interface PhoneInterface {
    List<PhoneInfo> listAll();
    PhoneInfo getPhoneById(int id);
    List<PhoneInfo> getPhoneByName(String name);
    int update(PhoneInfo phoneInfo);
    boolean delete(int id);
    int add(PhoneInfo phoneInfo);
}
