package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时保存套餐和菜品的关系
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);
    SetmealDto getByIdWithDish(Long id);
    void updateWithDish(SetmealDto setmealDto);
    void removeWithDish(List<Long> ids);
}
