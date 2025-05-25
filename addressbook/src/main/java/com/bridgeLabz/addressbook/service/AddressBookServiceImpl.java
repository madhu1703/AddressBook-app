package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    @Override
    public Optional<AddressBook> getEntryById(Long id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
    }

    @Override
    public AddressBook createEntry(AddressBook addressBook) {
        addressBook.setId(idCounter.getAndIncrement());
        addressBookList.add(addressBook);
        return addressBook;
    }

    @Override
    public Optional<AddressBook> updateEntry(Long id, AddressBook updatedEntry) {
        return getEntryById(id).map(existing -> {
            existing.setName(updatedEntry.getName());
            existing.setAddress(updatedEntry.getAddress());
            existing.setEmail(updatedEntry.getEmail());
            return existing;
        });
    }

    @Override
    public boolean deleteEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}
