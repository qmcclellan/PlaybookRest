package com.rest.playbookrest.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="security.datasource")
    public DataSource securityDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "entityManagerFactory")
//    @ConfigurationProperties(prefix="spring.data.jpa.entity")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource")DataSource dataSource){
//        return builder
//                .dataSource(dataSource)
//                .build();
//    }



//    @Bean
//    public PlatformTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setDataSource(dataSource);
//
//        return transactionManager;
//    }

}
