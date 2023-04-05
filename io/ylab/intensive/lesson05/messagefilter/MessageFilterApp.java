package io.ylab.intensive.lesson05.messagefilter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class MessageFilterApp {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        applicationContext.start();
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        FilterRepository filterRepository = applicationContext.getBean(FilterRepository.class);
        filterRepository.initDb();
        DataProcessor dataProcessor = applicationContext.getBean(DataProcessor.class);
        Thread thread = new Thread(() -> dataProcessor.processQueue());
        thread.start();
        SaveApi inputApi = applicationContext.getBean(SaveApi.class);
        inputApi.saveInput("Fuck you, уважаемый!");
        inputApi.saveInput("Fuck you, что простите?");
        inputApi.saveInput("Fuck you, ты всё слышал!");
    }
}