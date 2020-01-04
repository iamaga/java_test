package com.liu.service.impl;

import com.liu.mapper.PositionMapper;
import com.liu.pojo.Position;
import com.liu.service.PositionService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PositionServiceImpl implements PositionService {

    @Override
    public int addPosition(Position position) {
        SqlSession session = MybatisUtil.getSession();
        PositionMapper mapper = session.getMapper(PositionMapper.class);
        int i = mapper.addPosition(position);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Position> findAllPos() {
        SqlSession session = MybatisUtil.getSession();
        PositionMapper mapper = session.getMapper(PositionMapper.class);
        List<Position> positions = mapper.findAllPos();
        session.commit();
        MybatisUtil.closed();

        return positions;
    }

    @Override
    public Position findByPosid(int posid) {
        SqlSession session = MybatisUtil.getSession();
        PositionMapper mapper = session.getMapper(PositionMapper.class);
        Position position = mapper.findByPosid(posid);
        session.commit();
        MybatisUtil.closed();
        return position;
    }

    @Override
    public int deleteByPosid(int posid) {
        SqlSession session = MybatisUtil.getSession();
        PositionMapper mapper = session.getMapper(PositionMapper.class);
        int i = mapper.deleteByPosid(posid);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public int updatePosition(Position position) {
        SqlSession session = MybatisUtil.getSession();
        PositionMapper mapper = session.getMapper(PositionMapper.class);
        int i = mapper.updatePosition(position);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

}
