package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.List;

/**
 * UC4: IAddressBookService
 * Service interface defining contract for address book operations.
 * Business logic is delegated from controller to service via this interface.
 */
public interface IAddressBookService {

    /**
     * Get all address book entries
     */
    List<AddressBookData> getAllEntries();

    /**
     * Get an address book entry by ID
     */
    AddressBookData getEntryById(int id);

    /**
     * Create a new address book entry from DTO
     */
    AddressBookData createEntry(AddressBookDTO dto);

    /**
     * Update an existing address book entry by ID from DTO
     */
    AddressBookData updateEntry(int id, AddressBookDTO dto);

    /**
     * Delete an address book entry by ID
     */
    boolean deleteEntry(int id);
}
