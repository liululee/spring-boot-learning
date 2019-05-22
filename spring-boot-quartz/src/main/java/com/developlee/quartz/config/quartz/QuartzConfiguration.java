package com.developlee.quartz.config.quartz;


import com.developlee.quartz.config.app.AppConfig;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Lensen
 * @desc quartz 配置类
 * @since 2018/8/8 12:39
 */

@Configuration
public class QuartzConfiguration {

    @Autowired
    private AppConfig appConfig;

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory(quartzProperties());
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }

    /**
     * @return
     * @throws IOException
     * @desc 这里也可以直接写成quartz.properties。方便管理
     */
    @Bean
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", appConfig.getQuartzSchedulerInstanceName());
        prop.put("org.quartz.scheduler.instanceId", appConfig.getQuartzSchedulerInstanceId());
        prop.put("org.quartz.scheduler.skipUpdateCheck", appConfig.getQuartzSchedulerSkipUpdateCheck());
        prop.put("org.quartz.scheduler.jobFactory.class", appConfig.getQuartzSchedulerJobFactoryClass());
        prop.put("org.quartz.jobStore.class", appConfig.getQuartzJobStoreClass());
        prop.put("org.quartz.jobStore.driverDelegateClass", appConfig.getQuartzJobStoreDriverDelegateClass());
        prop.put("org.quartz.jobStore.dataSource", appConfig.getQuartzJobStoreDatasource());
        prop.put("org.quartz.jobStore.tablePrefix", appConfig.getQuartzJobStoreTablePrefix());
        prop.put("org.quartz.jobStore.isClustered", appConfig.getQuartzJobStoreIsClustered());
        prop.put("org.quartz.threadPool.class", appConfig.getQuartzThreadPoolClass());
        prop.put("org.quartz.threadPool.threadCount", appConfig.getQuartzThreadPoolThreadCount());
        prop.put("org.quartz.dataSource.quartzDataSource.connectionProvider.class", appConfig.getQuartzDatasourceQuartzDataSourceConnectionProviderClass());
        prop.put("org.quartz.dataSource.quartzDataSource.driver", appConfig.getQuartzDatasourceQuartzDataSourceDriver());
        prop.put("org.quartz.dataSource.quartzDataSource.URL", appConfig.getQuartzDatasourceQuartzDataSourceUrl());
        prop.put("org.quartz.dataSource.quartzDataSource.user", appConfig.getQuartzDatasourceQuartzDataSourceUser());
        prop.put("org.quartz.dataSource.quartzDataSource.password", appConfig.getQuartzDatasourceQuartzDataSourcePassword());
        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", appConfig.getQuartzDatasourceQuartzDataSourceMaxConnections());

        return prop;
    }
}