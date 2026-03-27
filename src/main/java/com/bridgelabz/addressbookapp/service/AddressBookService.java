package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UC5: AddressBookService - with in-memory local List storage
 * Now the service layer actually stores data in a List (in-memory).
 * Supports all CRUD operations:
 * - GET all
 * - GET by ID
 * - POST (create)
 * - PUT (update by ID)
 * - DELETE (delete by ID)
 */
@Service
public class AddressBookService implements IAddressBookService {

    // In-memory storage for address book entries
    private final List<AddressBookData> addressBookList = new ArrayList<>();

    // Simple ID generator (auto-increments for each new entry)
    private final AtomicInteger idCounter = new AtomicInteger(1);

    /**
     * Returns all address book entries from the local list
     */
    @Override
    public List<AddressBookData> getAllEntries() {
        return new ArrayList<>(addressBookList);
    }

    /**
     * Returns an address book entry by its ID from local list
     * Returns null if not found
     */
    @Override
    public AddressBookData getEntryById(int id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Creates a new address book entry from DTO and stores it in local list
     * Auto-generates ID using atomic counter
     */
    @Override
    public AddressBookData createEntry(AddressBookDTO dto) {
        int newId = idCounter.getAndIncrement();
        AddressBookData newEntry = new AddressBookData(
                newId,
                dto.getName(),
                dto.getAddress(),
                dto.getCity(),
                dto.getPhoneNumber()
        );
        addressBookList.add(newEntry);
        return newEntry;
    }

    /**
     * Updates an existing address book entry by ID using DTO data
     * Returns updated entry, or null if ID not found
     */
    @Override
    public AddressBookData updateEntry(int id, AddressBookDTO dto) {
        for (AddressBookData entry : addressBookList) {
            if (entry.getId() == id) {
                entry.setName(dto.getName());
                entry.setAddress(dto.getAddress());
                entry.setCity(dto.getCity());
                entry.setPhoneNumber(dto.getPhoneNumber());
                return entry;
            }
        }
        return null; // entry with given ID not found
    }

    /**
     * Deletes an address book entry by ID from local list
     * Returns true if deleted, false if not found
     */
    @Override
    public boolean deleteEntry(int id) {
        return addressBookList.removeIf(entry -> entry.getId() == id);
    }
}
