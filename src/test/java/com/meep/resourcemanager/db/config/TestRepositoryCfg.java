package com.meep.resourcemanager.db.config;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuración de Base de Datos para los Test
 * 
 * @author francisco.romeroporr
 *
 */
@Configuration
@EnableJpaRepositories(value = "com.meep.resourcemanager.db.repository")
@EnableTransactionManagement
public class TestRepositoryCfg {

    @Bean(name = "dataSource")
    public DataSource dataSource() {

	EmbeddedDatabaseBuilder dataSource = new EmbeddedDatabaseBuilder();
	dataSource.setType(H2);
	return dataSource.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	    throws ClassNotFoundException, PropertyVetoException {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	emf.setDataSource(dataSource());
	emf.setJpaProperties(jpaProperties());
	emf.setJpaVendorAdapter(jpaAdapter());
	emf.setPackagesToScan("com.meep.resourcemanager.db");
	return emf;
    }

    private Properties jpaProperties() {
	Properties props = new Properties();
	props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	props.setProperty("hibernate.show_sql", "true");
	return props;
    }

    private JpaVendorAdapter jpaAdapter() {
	return new HibernateJpaVendorAdapter();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
	return new JpaTransactionManager();
    }
}
