package contactlist.infinityscroll.controller;

import contactlist.infinityscroll.model.Contact;
import contactlist.infinityscroll.repo.ContactRepo;
import contactlist.infinityscroll.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts(){
        List<Contact> contactList = new ArrayList<>();
        contactService.getAllContacts().forEach(contactList::add);
        return contactList ;
    }



}
