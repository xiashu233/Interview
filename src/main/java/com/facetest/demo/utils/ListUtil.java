package com.facetest.demo.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListUtil implements Serializable {

    /**
     * 集合分页工具
     * @param list 集合
     * @param pageSize 分页大小
     * @return 分页后的集合
     */
    public static final List subList(List list, int pageSize){
        int pageCount = list.size();
        List subList = new ArrayList();
        List subTo;
        for (int i = 0; i < pageCount; i+= pageSize) {
            subTo = i + pageSize > pageCount? list.subList(i,i + (pageCount%pageSize)): list.subList(i,i+pageSize);
            subList.add(subTo);
        }
        return subList;
    }
}
