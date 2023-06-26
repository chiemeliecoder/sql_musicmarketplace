package com.laba.solvd.databases.myBatis;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisObject {
  // Create a MyBatis configuration object
  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSessionFactory getSqlSessionFactory() {
    if (sqlSessionFactory == null) {
      try {
        // Specify the path to your MyBatis configuration file
        String resource = "src/main/resources/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // Create the SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sqlSessionFactory;
  }

}
