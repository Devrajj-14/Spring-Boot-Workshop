package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UC4: AddressBookService
 * Service implementation for address book operations.
 * Decouples business logic from the controller layer.
 * At this UC4 stage, methods return placeholder/stub responses.
 * Actual storage (local list) will be introduced in UC5.
 */
@Service
public class AddressBookService implements IAddressBookService {

    /**
     * Returns all address book entries - placeholder at UC4
     */
    @Override
    public List<AddressBookData> getAllEntries() {
        // Placeholder: returns empty list - UC5 will have actual storage
        return new ArrayList<>();
    }

    /**
     * Returns entry by ID - placeholder at UC4
     */
    @Override
    public AddressBookData getEntryById(int id) {
        // Placeholder: returns a sample model object for UC4 demonstration
        return new AddressBookData(id, "Placeholder Name", "Placeholder Address", "Placeholder City", "0000000000");
    }

    /**
     * Creates a new address book entry from DTO - placeholder at UC4
     */
    @Override
    public AddressBookData createEntry(AddressBookDTO dto) {
        // Placeholder: maps DTO to model with mock ID (UC5 will do real storage)
        return new AddressBookData(1, dto.getName(), dto.getAddress(), dto.getCity(), dto.getPhoneNumber());
    }

    /**
     * Updates existing entry by ID from DTO - placeholder at UC4
     */
    @Override
    public AddressBookData updateEntry(int id, AddressBookDTO dto) {
        // Placeholder: returns updated model without actual persistence
        return new AddressBookData(id, dto.getName(), dto.getAddress(), dto.getCity(), dto.getPhoneNumber());
    }

    /**
     * Deletes entry by ID - placeholder at UC4
     */
    @Override
    public boolean deleteEntry(int id) {
        // Placeholder: always returns true (no real storage yet)
        return true;
    }
}
