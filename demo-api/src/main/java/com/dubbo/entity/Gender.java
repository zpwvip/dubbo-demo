package com.dubbo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by kunpeng on 2017/5/25.
 */
public enum Gender {
    ALL(0, "全部"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private static Logger logger = LoggerFactory.getLogger(Gender.class);

    private static final Map<Integer, Gender> _MAP = new HashMap<Integer, Gender>();
    private static List<Gender> _LIST = new ArrayList<Gender>();
    private static List<Gender> _ALLLIST = new ArrayList<Gender>();
    static {
        for(Gender gender : Gender.values()){
            _MAP.put(gender.getValue(), gender);
            _ALLLIST.add(gender);
            if (!gender.equals(ALL)) {
                _LIST.add(gender);
            }
        }

        synchronized (_LIST) {
            _LIST = Collections.unmodifiableList(_LIST);
        }
        synchronized (_ALLLIST) {
            _ALLLIST = Collections.unmodifiableList(_ALLLIST);
        }
    }

    private String name;
    private int value;

    private Gender(int value, String name){
        this.value = value;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Gender get(int value){
        try{
            return _MAP.get(value);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<Gender> list() {
        return _LIST;
    }

    public static List<Gender> listAll() {
        return _ALLLIST;
    }
}
