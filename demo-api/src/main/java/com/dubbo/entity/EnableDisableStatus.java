package com.dubbo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by lkp on 2014/6/23.
 */
public enum EnableDisableStatus {
    DISABLE(0, "无效"),
    ENABLE(1, "有效"),
    ALL(2, "全部");

    private static Logger logger = LoggerFactory.getLogger(EnableDisableStatus.class);

    private static final Map<Integer, EnableDisableStatus> _MAP = new HashMap<Integer, EnableDisableStatus>();
    private static List<EnableDisableStatus> _LIST = new ArrayList<EnableDisableStatus>();
    private static List<EnableDisableStatus> _ALLLIST = new ArrayList<EnableDisableStatus>();
    static {
        for(EnableDisableStatus enableDisableStatus : EnableDisableStatus.values()){
            _MAP.put(enableDisableStatus.getValue(), enableDisableStatus);
            _ALLLIST.add(enableDisableStatus);
            if (!enableDisableStatus.equals(ALL)) {
                _LIST.add(enableDisableStatus);
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

    private EnableDisableStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }

    public static EnableDisableStatus get(int value){
        try{
            return _MAP.get(value);
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static List<EnableDisableStatus> list() {
        return _LIST;
    }

    public static List<EnableDisableStatus> listAll() {
        return _ALLLIST;
    }
}
