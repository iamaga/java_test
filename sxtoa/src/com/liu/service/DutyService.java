package com.liu.service;

import com.liu.pojo.Duty;

import java.util.Date;
import java.util.List;

public interface DutyService {
    int addDuty(Duty duty);
    Duty findTodayDuty(String emprid, Date date);
    int updateDuty(Duty duty);
    List<Duty> findAllDuty();
    List<Duty> findByMore(String emprid, String deptno,String date);
//    List<Duty> findMyDuty(String emprid);
}
