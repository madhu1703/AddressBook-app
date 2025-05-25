package com.bridgeLabz.addressbook.repository;

import com.bridgeLabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}
