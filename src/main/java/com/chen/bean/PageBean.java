package com.chen.bean;

import lombok.Data;

import java.util.Map;

@Data
public class PageBean {

    private Map<String,Object> map;
    private Integer currentPage = Integer.valueOf(1);
    private Integer pageSize = Integer.valueOf(10);
    private Integer totalCount;
}
