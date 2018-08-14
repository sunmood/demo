package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

/**
 * Created by sunmood on 2018/8/14.
 */
public interface AreaService {
    /**
     * 查询区域列表
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据id查询区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 添加区域信息
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
