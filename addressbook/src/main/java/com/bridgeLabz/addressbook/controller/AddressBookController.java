package com.bridgeLabz.addressbook.controller;

import com.bridgeLabz.addressbook.model.AddressBook;
import com.bridgeLabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Address Book Application!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        AddressBook addressBook = service.getEntryById(id);
        return ResponseEntity.ok(addressBook);
    }

    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@RequestBody AddressBook addressBook) {
        AddressBook createdEntry = service.createEntry(addressBook);
        return ResponseEntity.ok(createdEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBook updatedEntry) {
        AddressBook updated = service.updateEntry(id, updatedEntry);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}

