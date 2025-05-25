package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.exception.AddressBookException;
import com.bridgeLabz.addressbook.model.AddressBook;
import com.bridgeLabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBook> getAllEntries() {
        log.info("Fetching all address book entries.");
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getEntryById(Long id) {
        log.info("Fetching entry with ID: {}", id);
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book entry not found for ID: " + id));
    }

    @Override
    public AddressBook createEntry(AddressBook addressBook) {
        log.info("Creating new address book entry: {}", addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBook updatedEntry) {
        log.info("Updating entry with ID: {}", id);
        AddressBook existingEntry = getEntryById(id);
        existingEntry.setName(updatedEntry.getName());
        existingEntry.setAddress(updatedEntry.getAddress());
        existingEntry.setEmail(updatedEntry.getEmail());
        return addressBookRepository.save(existingEntry);
    }

    @Override
    public void deleteEntry(Long id) {
        log.info("Deleting entry with ID: {}", id);
        AddressBook entry = getEntryById(id);
        addressBookRepository.delete(entry);
    }
}

