package com.meandbooksteam2.shoppingmall.service.main;

import java.util.HashMap;
import java.util.List;

public interface MainService<E> {
    public int insert(HashMap<String, String> param);
    public List<E> read(HashMap<String, String> param);
    public int update(HashMap<String, String> param);
    public int delete(HashMap<String, String> param);
}
