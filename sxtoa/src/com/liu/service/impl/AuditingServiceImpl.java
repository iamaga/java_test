package com.liu.service.impl;

import com.liu.mapper.AuditingMapper;
import com.liu.pojo.Auditing;
import com.liu.service.AuditingService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AuditingServiceImpl implements AuditingService {

    @Override
    public int addAudit(Auditing auditing) {
        SqlSession session = MybatisUtil.getSession();
        AuditingMapper mapper = session.getMapper(AuditingMapper.class);
        int i = mapper.addAudit(auditing);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Auditing> findAuditByExpid(Integer expid) {
        SqlSession session = MybatisUtil.getSession();
        AuditingMapper mapper = session.getMapper(AuditingMapper.class);
        List<Auditing> auditings = mapper.findAuditByExpid(expid);
        session.commit();
        MybatisUtil.closed();
        return auditings;
    }

    @Override
    public List<Auditing> findMyAuditByEmpid(String empid) {
        SqlSession session = MybatisUtil.getSession();
        AuditingMapper mapper = session.getMapper(AuditingMapper.class);
        List<Auditing> auditings = mapper.findMyAuditByEmpid(empid);
        session.commit();
        MybatisUtil.closed();
        return auditings;
    }

}
