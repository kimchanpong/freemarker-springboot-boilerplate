package com.ckdpharm.homepage.common.config;

import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class DataSourceConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultDSLContext dslContext() {
        return new DefaultDSLContext(configuration());
    }

    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.setSQLDialect(SQLDialect.MARIADB);
        jooqConfiguration.settings().setRenderNameStyle(RenderNameStyle.AS_IS);
        jooqConfiguration
                .set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));

        return jooqConfiguration;
    }
}
