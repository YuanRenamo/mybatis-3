package com.cn.chapter01;

import com.cn.chapter01.dao.TeacherMapper;
import com.cn.chapter01.domain.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname MyBatisTest
 * @Description TODO
 * @Date 2020/11/3 9:34
 * @Created by Administrator
 */
public class MyBatisTest {
  private SqlSessionFactory sqlSessionFactory;

  @Before
  public void prepare() throws IOException {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new
      SqlSessionFactoryBuilder().build(inputStream);
    inputStream.close();
  }

  @Test
  public void testMyBatis() throws IOException {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
      Teacher teachers = teacherMapper.selectOne(1);
      System.out.println(teachers);
    } finally {
      session.commit();
      session.close();
    }
  }
}
