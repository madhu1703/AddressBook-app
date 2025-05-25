package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    List<AddressBook> getAllEntries();
    Optional<AddressBook> getEntryById(Long id);
    AddressBook createEntry(AddressBook addressBook);
    Optional<AddressBook> updateEntry(Long id, AddressBook updatedEntry);
    boolean deleteEntry(Long id);
}

