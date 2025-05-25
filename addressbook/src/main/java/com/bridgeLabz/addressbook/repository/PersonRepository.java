package com.bridgeLabz.addressbook.repository;
import com.bridgeLabz.addressbook.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
