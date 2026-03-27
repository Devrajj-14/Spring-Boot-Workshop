package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UC2: AddressBookController
 * Provides REST endpoints for all HTTP methods:
 * GET, POST, PUT, DELETE
 * At this stage, returns simple placeholder JSON responses.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /**
     * GET /addressbook/
     * Returns all address book entries (placeholder at UC2 stage)
     */
    @GetMapping("/")
    public ResponseEntity<String> getAllEntries() {
        return ResponseEntity.ok("{ \"message\": \"GET all address book entries\" }");
    }

    /**
     * GET /addressbook/get/{id}
     * Returns address book entry by ID (placeholder at UC2 stage)
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok("{ \"message\": \"GET address book entry with id: " + id + "\" }");
    }

    /**
     * POST /addressbook/create
     * Creates a new address book entry (placeholder at UC2 stage)
     */
    @PostMapping("/create")
    public ResponseEntity<String> createEntry(@RequestBody String body) {
        return ResponseEntity.ok("{ \"message\": \"POST - create address book entry\", \"receivedData\": " + body + " }");
    }

    /**
     * PUT /addressbook/update/{id}
     * Updates an existing address book entry by ID (placeholder at UC2 stage)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestBody String body) {
        return ResponseEntity.ok("{ \"message\": \"PUT - update address book entry with id: " + id + "\", \"receivedData\": " + body + " }");
    }

    /**
     * DELETE /addressbook/delete/{id}
     * Deletes an address book entry by ID (placeholder at UC2 stage)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        return ResponseEntity.ok("{ \"message\": \"DELETE - remove address book entry with id: " + id + "\" }");
    }
}
