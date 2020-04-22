package technicalblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
       emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");

        emfb.afterPropertiesSet();
        return emfb.getObject();
    }




//    @Bean
//    public Map<String, String> jpaProperties() {
//        Map<String, String> props = new HashMap<>();
//        props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
//        props.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5433/technicalblog");
//        props.put("javax.persistence.jdbc.user", "postgres");
//        props.put("javax.persistence.jdbc.password", "Postgresql@123");
//        //props.put("javax.persistence.sql-load-script-source", "sql/import.sql");
//        return props;
//    }
//    @Bean
//    public Map<String, String> hibernateProperties() {
//        Map<String, String> props = new HashMap<>();
//        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
//        props.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
//
//        return props;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5433/technicalblog");
        ds.setUsername("postgres");
        ds.setPassword("Postgresql@123");

        return ds;
    }
}
