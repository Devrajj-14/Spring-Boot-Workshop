package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UC4: AddressBookController
 * Controller now delegates all business logic to the service layer.
 * Uses @Autowired to inject IAddressBookService.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Inject service layer - controller no longer manages model logic
    @Autowired
    private IAddressBookService addressBookService;

    /**
     * GET /addressbook/
     * Returns all address book entries via service layer
     */
    @GetMapping("/")
    public ResponseEntity<List<AddressBookData>> getAllEntries() {
        List<AddressBookData> entries = addressBookService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    /**
     * GET /addressbook/get/{id}
     * Returns address book entry by ID via service layer
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getEntryById(@PathVariable int id) {
        AddressBookData data = addressBookService.getEntryById(id);
        if (data != null) {
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * POST /addressbook/create
     * Creates a new address book entry by passing DTO to service layer
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createEntry(@RequestBody AddressBookDTO dto) {
        AddressBookData created = addressBookService.createEntry(dto);
        return ResponseEntity.ok(created);
    }

    /**
     * PUT /addressbook/update/{id}
     * Updates an address book entry by passing ID and DTO to service layer
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        AddressBookData updated = addressBookService.updateEntry(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * DELETE /addressbook/delete/{id}
     * Deletes an address book entry by ID via service layer
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        boolean deleted = addressBookService.deleteEntry(id);
        if (deleted) {
            return ResponseEntity.ok("{ \"message\": \"Address book entry with id: " + id + " deleted successfully\" }");
        }
        return ResponseEntity.notFound().build();
    }
}
