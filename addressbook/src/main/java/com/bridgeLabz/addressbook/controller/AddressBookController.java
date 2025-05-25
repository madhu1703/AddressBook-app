package com.bridgeLabz.addressbook.controller;

import com.bridgeLabz.addressbook.model.AddressBook;
import com.bridgeLabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(addressBookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        return addressBookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@RequestBody AddressBook addressBook) {
        AddressBook saved = addressBookRepository.save(addressBook);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBook updatedEntry) {
        return addressBookRepository.findById(id)
                .map(existingEntry -> {
                    existingEntry.setName(updatedEntry.getName());
                    existingEntry.setAddress(updatedEntry.getAddress());
                    existingEntry.setEmail(updatedEntry.getEmail());
                    addressBookRepository.save(existingEntry);
                    return ResponseEntity.ok(existingEntry);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
