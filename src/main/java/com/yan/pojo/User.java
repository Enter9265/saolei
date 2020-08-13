package com.yan.pojo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private int[][] map;//雷图
    private int x = 0;//雷图
    private int y = 0;//雷图
    private int number;//总共雷的个数
    private int stepSize;//走的步骤
    private int surplus;//剩余没展示个数
    private boolean state = true;//状态
    private Set<String> set;//展示出的数


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }


    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStepSize() {
        return stepSize;
    }

    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }


    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }
}
