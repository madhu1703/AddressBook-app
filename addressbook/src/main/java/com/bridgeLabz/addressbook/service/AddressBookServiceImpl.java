package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;
import com.bridgeLabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public Optional<AddressBook> getEntryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public AddressBook createEntry(AddressBook addressBook) {
        return repository.save(addressBook);
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBook updatedEntry) {
        return repository.findById(id)
                .map(entry -> {
                    entry.setName(updatedEntry.getName());
                    entry.setAddress(updatedEntry.getAddress());
                    entry.setEmail(updatedEntry.getEmail());
                    return repository.save(entry);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found with ID: " + id));
    }

    @Override
    public void deleteEntry(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Entry not found with ID: " + id);
        }
    }
}

