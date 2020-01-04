package com.liu.service;

import com.liu.pojo.Auditing;

import java.util.List;

public interface AuditingService {
    int addAudit(Auditing auditing);
    List<Auditing> findAuditByExpid(Integer expid);
    List<Auditing> findMyAuditByEmpid(String empid);
}
