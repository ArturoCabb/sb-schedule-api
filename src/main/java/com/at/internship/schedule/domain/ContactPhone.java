package com.at.internship.schedule.domain;

<<<<<<< Updated upstream
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

=======
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

>>>>>>> Stashed changes
@Data
@Entity
public class ContactPhone {
    @EmbeddedId
<<<<<<< Updated upstream
    private ContactPhonePk id;
=======
    private ContactPhonePK id;
>>>>>>> Stashed changes
    private Boolean primaryFlag;
}
