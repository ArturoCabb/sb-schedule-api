package com.at.internship.schedule.config;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.CsvAppointmentRepository;
import com.at.internship.schedule.repository.impl.CsvContactRepository;
import com.at.internship.schedule.repository.impl.MockAppointmentRepositoryImpl;
import com.at.internship.schedule.repository.impl.MockContactRepositoryImpl;
import com.at.internship.schedule.config.MockRepositoryConfig;
import com.at.internship.schedule.config.CsvRepositoryConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultRepositoryConfig {

    /**
     * Al modificar un propertie saber si va a usar el csvRepository o el mockRepository
     * tanto para contact como appointment
     */

    private static final String PROP_DEFAULT_REPOSITORY_CONFIG = "${com.at.intership.default.repository.config}";

    private final ApplicationContext context;

    public DefaultRepositoryConfig(ApplicationContext context) {
        this.context = context;
        //this.context.getBean(name);
    }
    
    public IContactRepository contactRepository() {
        // TODO
        if (PROP_DEFAULT_REPOSITORY_CONFIG.equalsIgnoreCase("csv"))
            context.getBean(CsvRepositoryConfig.class);
        else
        context.getBean(MockRepositoryConfig.class);
        return new MockContactRepositoryImpl();
    }

    public IAppointmentRepository appointmentRepository() {
        if (PROP_DEFAULT_REPOSITORY_CONFIG.equalsIgnoreCase("csv"))
            context.getBean(CsvRepositoryConfig.class);
        else
            context.getBean(MockRepositoryConfig.class);
        return new MockAppointmentRepositoryImpl();
    }
}
