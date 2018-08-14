package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sunmood on 2018/8/14.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(1);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && "".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaName() != null && "".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("更新区域信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            try{
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("删除区域信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域ID不能为空！");
        }
    }
}
