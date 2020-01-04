package com.liu.mapper;

import com.liu.pojo.Auditing;
import com.liu.pojo.Dept;

import java.util.List;

public interface AuditingMapper {
  int addAudit(Auditing auditing);
  List<Auditing> findAuditByExpid(Integer expid);
  List<Auditing> findMyAuditByEmpid(String empid);

}
