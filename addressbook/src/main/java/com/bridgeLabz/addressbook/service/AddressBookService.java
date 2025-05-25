package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    List<AddressBook> getAllEntries();
    Optional<AddressBook> getEntryById(Long id);
    AddressBook createEntry(AddressBook addressBook);
    AddressBook updateEntry(Long id, AddressBook addressBook);
    void deleteEntry(Long id);
}
