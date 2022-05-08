package com.at.internship.schedule.config;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.CsvAppointmentRepository;
import com.at.internship.schedule.repository.impl.CsvContactRepository;
import com.at.internship.schedule.repository.impl.MockAppointmentRepositoryImpl;
import com.at.internship.schedule.repository.impl.MockContactRepositoryImpl;
import com.at.internship.schedule.config.MockRepositoryConfig;

import java.util.Arrays;

import javax.swing.Icon;

import com.at.internship.schedule.config.CsvRepositoryConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Configuration
public class DefaultRepositoryConfig {

    /**
     * Al modificar un propertie saber si va a usar el csvRepository o el mockRepository
     * tanto para contact como appointment
     */

    
    private static final String PROP_DEFAULT_REPOSITORY_CONFIG = "${com.at.intership.default.repository.config}";
    
    @Value(PROP_DEFAULT_REPOSITORY_CONFIG)
    private String repositoryPrefix;
    
    private final ApplicationContext context;

    public DefaultRepositoryConfig(ApplicationContext context) {
        this.context = context;
        //this.context.getBean(name);
    }
    
    @Bean
    @Primary
    public IContactRepository contactRepository() {
        // TODO
        //if(!Arrays.asList("csv", "mock").contains(repositoryPrefix))
        //    throw new RuntimeException("");
        if ("csv".equalsIgnoreCase(repositoryPrefix))
            return CsvContactRepository.getSingleton();
        return new MockContactRepositoryImpl();
        //return context.getBean(repositoryPrefix + "ContactRepository", IContactRepository.class);
        //if (PROP_DEFAULT_REPOSITORY_CONFIG.equalsIgnoreCase("csv"))
        //    context.getBean(CsvRepositoryConfig.class);
        //else
        //context.getBean(MockRepositoryConfig.class);
        //return new MockContactRepositoryImpl();
    }

    public IAppointmentRepository appointmentRepository() {
        if(!Arrays.asList("csv", "mock").contains(repositoryPrefix))
            throw new RuntimeException("");
        return context.getBean(repositoryPrefix + "AppointmentRepository", IAppointmentRepository.class);
        //if (PROP_DEFAULT_REPOSITORY_CONFIG.equalsIgnoreCase("csv"))
        //    context.getBean(CsvRepositoryConfig.class);
        //else
        //    context.getBean(MockRepositoryConfig.class);
        //return new MockAppointmentRepositoryImpl();
    }
}
