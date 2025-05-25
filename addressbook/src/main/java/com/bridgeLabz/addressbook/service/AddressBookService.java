package com.bridgeLabz.addressbook.service;

import com.bridgeLabz.addressbook.model.AddressBook;
import java.util.List;

public interface AddressBookService {
    List<AddressBook> getAllEntries();
    AddressBook getEntryById(Long id);
    AddressBook createEntry(AddressBook addressBook);
    AddressBook updateEntry(Long id, AddressBook updatedEntry);
    void deleteEntry(Long id);
}


