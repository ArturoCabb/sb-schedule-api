package com.at.internship.schedule.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ContactPhonePK implements Serializable {
    @Embedded
    private Integer contactId;
    private String phoneNumber;
}
