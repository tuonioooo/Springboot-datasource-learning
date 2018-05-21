package com.datasouce.config;

import org.springframework.beans.factory.annotation.Qualifier;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

/**
 * Created by tuonioooo.
 * User: tony
 * Date: 2018-5-15
 * Time: 10:25
 * info: 配置数据源
 */
@Configuration
public class DataSourceConfig {


    @Bean
    @Primary
    @Qualifier("dataSource")//按照名称装配实例
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {//主数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate (@Qualifier("dataSource")  DataSource dataSource ) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "cloudDataSource")
    @Qualifier("cloudDataSource")//按照名称装配实例
    @ConfigurationProperties(prefix="spring.datasource.cloud.mysql")
    public DataSource cloudDataSource() {//从数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name="cloudJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate (@Qualifier("cloudDataSource")  DataSource dataSource ) {
        return new JdbcTemplate(dataSource);
    }



}
