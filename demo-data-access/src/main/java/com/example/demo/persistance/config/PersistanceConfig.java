package com.example.demo.persistance.config;

import com.example.demo.persistance.MybatisComponentScanTag;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cirmons
 * @Date: 2021-10-09
 */
//
@Configuration
@MapperScan(basePackageClasses = {MybatisComponentScanTag.class})
//@MapperScan("com.example.demo.persistance")
public class PersistanceConfig {

//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();
//    }
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        return factoryBean.getObject();
//    }
}