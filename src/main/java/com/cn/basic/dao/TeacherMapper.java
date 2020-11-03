package com.cn.basic.dao;

import com.cn.basic.domain.Teacher;

/**
 * @Classname TeacherMapper
 * @Description TODO
 * @Date 2020/11/3 9:41
 * @Created by Administrator
 */
public interface TeacherMapper {
  public Teacher selectOne(Integer Id);
}
