package com.at.internship.schedule.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.dto.ContactDto;
import com.at.internship.schedule.service.IContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    IContactService contactService;

    public ContactController () {

    }

    @GetMapping("/findAll")
    public List<Contact> listContacts() {
        return contactService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Contact> listContactsId(@PathVariable("id") Integer id) {
        return contactService.findById(id);
    }

    @GetMapping("/findByNombreOrderByNombreAsc/{nombre}")
    public List<Contact> findByFirstNameOrderByFirstNameAsc(@PathVariable("nombre") String nombre) {
        return contactService.findByFirstNameOrderByFirstNameAsc(nombre);
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid ContactDto contact) {
        // Validar que actualiza o crea
        Optional<Contact> contactF = contactService.findById(contact.getId());
        if (contactF.isEmpty())
            contactService.save(contact);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid ContactDto contact) {
            contactService.save(contact);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        contactService.delete(id);
    }
}
