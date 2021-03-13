package com.springcloud.alibaba.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author i531869
 * @Date 2021/3/8 15:31
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.springcloud.alibaba.dao")
public class DataSourceProxyConfig {

  @Value("${mybatis.mapperLocations}")
  private String mapperLocations;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource getDruidDataSource(){
    return new DruidDataSource();
  }

  @Bean
  public DataSourceProxy getDataSourceProxy(DataSource dataSource) {
    return new DataSourceProxy(dataSource);
  }

  @Bean
  public SqlSessionFactory getSqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSourceProxy);
    sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
    return sqlSessionFactoryBean.getObject();
  }
}
