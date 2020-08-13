package com.chen.pojo;



import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
//@Table(name="student")
public class Student implements Serializable {
//    @Id
    private int id     ;
    private int age    ;
    private String name   ;
    private String sex    ;
    private String address;
    private String classs  ;
}
