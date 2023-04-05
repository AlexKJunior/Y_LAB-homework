package io.ylab.intensive.lesson05.eventsourcing.api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApiApp {
    public static void main(String[] args) throws Exception {
        // Тут пишем создание PersonApi, запуск и демонстрацию работы
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        applicationContext.start();
        PersonApi personApi = applicationContext.getBean(PersonApi.class);
        personApi.savePerson(1L, "Alex", "Alekseev", "Alekseevich");
        personApi.savePerson(2L, "Nikolai", "Nikolaev", "Nikolaevich");
        personApi.savePerson(3L, "Maria", "Maria", "Maria");
        personApi.savePerson(4L, "Maria", "Maria", "Maria");
        personApi.savePerson(4L, "Maria", "Maria", "Maria");

        Thread.sleep(3000);
        System.out.println(personApi.findPerson(2L));
        personApi.savePerson(2L, "oleg", "oleg", "oleg");
        System.out.println(personApi.findAll());
        personApi.deletePerson(2L);
        System.out.println(personApi.findAll());
        personApi.deletePerson(111L);
        System.out.println(personApi.findAll());
    }
}