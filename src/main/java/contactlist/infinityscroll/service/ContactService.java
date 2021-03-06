package contactlist.infinityscroll.service;

import contactlist.infinityscroll.model.Contact;
import contactlist.infinityscroll.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
public class ContactService implements IContactService {
    @Autowired
    private ContactRepo repo;

    @Transactional
    @Override
    public void addContact(Contact contact) {
        Contact newOne = contact.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phoneNumber(contact.getPhoneNumber())
                .build();
        repo.save(newOne);
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> allContacts = repo.findAll();
        return allContacts;
    }

    @Override
    public List<Contact> getContactsByPage(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Contact> contactPage = repo.findAll(pageable);
        return contactPage.getContent();
    }


}
