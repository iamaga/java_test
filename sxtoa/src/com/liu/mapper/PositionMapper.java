package com.liu.mapper;

import com.liu.pojo.Position;

import java.util.List;

public interface PositionMapper {
    int addPosition(Position position);
    List<Position> findAllPos();
    Position findByPosid(int posid);
    int deleteByPosid(int posid);
    int updatePosition(Position position);

}
