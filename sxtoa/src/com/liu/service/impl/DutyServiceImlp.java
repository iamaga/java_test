package com.liu.service.impl;

import com.liu.mapper.DutyMapper;
import com.liu.pojo.Duty;
import com.liu.service.DutyService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class DutyServiceImlp implements DutyService {

    @Override
    public int addDuty(Duty duty) {
        SqlSession session = MybatisUtil.getSession();
        DutyMapper mapper = session.getMapper(DutyMapper.class);
        Duty todayDuty = mapper.findTodayDuty(duty.getEmprid(), duty.getDtdate());
        if (null!=todayDuty){
            return -1;
        }
        int i = mapper.addDuty(duty);

        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public Duty findTodayDuty(String emprid, Date date) {
        SqlSession session = MybatisUtil.getSession();
        DutyMapper mapper = session.getMapper(DutyMapper.class);
        Duty duty = mapper.findTodayDuty(emprid, date);
        session.commit();
        MybatisUtil.closed();
        return duty;
    }

    @Override
    public int updateDuty(Duty duty) {
        SqlSession session = MybatisUtil.getSession();
        DutyMapper mapper = session.getMapper(DutyMapper.class);
        int i = mapper.updateDuty(duty);
        session.commit();
        MybatisUtil.closed();


        return i;
    }

    @Override
    public List<Duty> findAllDuty() {
        SqlSession session = MybatisUtil.getSession();
        DutyMapper mapper = session.getMapper(DutyMapper.class);
        List<Duty> dutys = mapper.findAllDuty();
        session.commit();
        MybatisUtil.closed();
        return dutys;
    }

    @Override
    public List<Duty> findByMore(String emprid, String deptno, String date) {
        SqlSession session = MybatisUtil.getSession();
        DutyMapper mapper = session.getMapper(DutyMapper.class);
        List<Duty> duties = mapper.findByMore(emprid, deptno, date);
        session.commit();
        MybatisUtil.closed();
        return duties;
    }
}
