package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBook> getAllEntries() {
        log.info("Fetching all address book entries. Total entries: {}", addressBookList.size());
        return addressBookList;
    }

    @Override
    public Optional<AddressBook> getEntryById(Long id) {
        log.info("Fetching entry with ID: {}", id);
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
    }

    @Override
    public AddressBook createEntry(AddressBook addressBook) {
        log.info("Creating new address book entry: {}", addressBook);
        addressBookList.add(addressBook);
        return addressBook;
    }

    @Override
    public Optional<AddressBook> updateEntry(Long id, AddressBook updatedEntry) {
        log.info("Updating entry with ID: {}", id);
        Optional<AddressBook> existingEntryOpt = getEntryById(id);
        existingEntryOpt.ifPresent(existingEntry -> {
            existingEntry.setName(updatedEntry.getName());
            existingEntry.setAddress(updatedEntry.getAddress());
            existingEntry.setEmail(updatedEntry.getEmail());
            log.debug("Updated entry: {}", existingEntry);
        });
        return existingEntryOpt;
    }

    @Override
    public boolean deleteEntry(Long id) {
        log.info("Deleting entry with ID: {}", id);
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}
