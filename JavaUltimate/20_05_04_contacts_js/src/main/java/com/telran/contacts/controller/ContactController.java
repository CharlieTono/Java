package com.telran.contacts.controller;

import com.telran.contacts.dto.Contact;
import com.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> contactForm() {
        return contactService.getAll();
    }

    @PostMapping("/contact")
    @ResponseBody
    public void addContact(@RequestBody Contact contact) {
        contactService.add(contact);
    }

    @PutMapping("/contact")
    @ResponseBody
    public void editContact(@RequestBody Contact contact) {
        contactService.edit(contact);
    }

    @GetMapping("/")
    public String home() {
        return "forward:/contacts";
    }

    @GetMapping("/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable int id) {
        return contactService.get(id);
    }

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/contact/edit/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @DeleteMapping("/contact/{id}")
    @ResponseBody
    public void removeContact(@PathVariable int id) {
        contactService.remove(id);
    }
}
