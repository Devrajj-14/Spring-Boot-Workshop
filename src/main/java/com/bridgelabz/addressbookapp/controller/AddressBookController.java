package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UC3: AddressBookController
 * Updated to use AddressBookDTO for input and AddressBookData (Model) for response.
 * Returns proper JSON responses using ResponseEntity.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /**
     * GET /addressbook/
     * Returns all address book entries (placeholder - no storage yet at UC3)
     */
    @GetMapping("/")
    public ResponseEntity<String> getAllEntries() {
        return ResponseEntity.ok("{ \"message\": \"GET all address book entries\", \"data\": [] }");
    }

    /**
     * GET /addressbook/get/{id}
     * Returns address book entry by ID using the model pattern
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getEntryById(@PathVariable int id) {
        // Placeholder - returns a sample model object for UC3 demonstration
        AddressBookData data = new AddressBookData(id, "Sample Name", "Sample Address", "Sample City", "0000000000");
        return ResponseEntity.ok(data);
    }

    /**
     * POST /addressbook/create
     * Creates a new address book entry from DTO input
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createEntry(@RequestBody AddressBookDTO dto) {
        // Placeholder: maps DTO to model and returns it (no persistence at UC3)
        AddressBookData data = new AddressBookData(1, dto.getName(), dto.getAddress(), dto.getCity(), dto.getPhoneNumber());
        return ResponseEntity.ok(data);
    }

    /**
     * PUT /addressbook/update/{id}
     * Updates an address book entry by ID from DTO input
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        // Placeholder: maps DTO to model with given ID and returns it
        AddressBookData updatedData = new AddressBookData(id, dto.getName(), dto.getAddress(), dto.getCity(), dto.getPhoneNumber());
        return ResponseEntity.ok(updatedData);
    }

    /**
     * DELETE /addressbook/delete/{id}
     * Deletes address book entry by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        return ResponseEntity.ok("{ \"message\": \"DELETE - address book entry with id: " + id + " deleted\" }");
    }
}
