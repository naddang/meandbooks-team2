package com.meandbooksteam2.shoppingmall.dao.admin;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageBookServiceDao<E> {

     int insert(HashMap<String,String> param);

     List<E> read(HashMap<String,String> param);

     int update(HashMap<String,String> param);

     int delete(HashMap<String,String> param);
}
