package com.cn.chapter01.dao;

import com.cn.chapter01.domain.Teacher;

/**
 * @Classname TeacherMapper
 * @Description TODO
 * @Date 2020/11/3 9:41
 * @Created by Administrator
 */
public interface TeacherMapper {
  public Teacher selectOne(Integer Id);
}
