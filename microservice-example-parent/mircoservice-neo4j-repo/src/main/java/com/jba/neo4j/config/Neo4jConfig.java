/**
 * 
 */
package com.jba.neo4j.config;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jude
 * @since June 3, 2017
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.jba.neo4j.repository")
@EnableTransactionManagement
public class Neo4jConfig implements BeanFactoryAware {
	@SuppressWarnings("unused")
	private BeanFactory beanFactory;
	@Value("${user.db.path}")
	private String dataBasePath;

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase(dataBasePath);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
