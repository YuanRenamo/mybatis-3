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

/**
 * mybatis源码流程
 * 1. 创建一个对应接口的代理类 MapperProxy, 调用业务接口的方式实际是调用MapperProxy.invoke方法（这里使用的是JDK的动态代理）
 * 2. 调用业务接口方法时，实际时调用MapperMethod.execute 方法
 * 3. 查询最后是调用的 Executor.query方法
 * 4. 在创建 Executor方法时, 每个插件将 Executor进行包装 （使用Plugin.wrap 进行包装，实际上也是使用JDK动态代理）
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
