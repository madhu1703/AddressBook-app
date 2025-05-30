package com.bridgeLabz.addressbook.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class AddressBook {
    @Id
    private Long id;
    private String name;
    private String address;
    private String email;

    public AddressBook() {
    }

    public AddressBook(Long id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
