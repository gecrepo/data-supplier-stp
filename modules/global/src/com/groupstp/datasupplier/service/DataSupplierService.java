package com.groupstp.datasupplier.service;

import com.groupstp.datasupplier.data.AddressData;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Special data supplier service bean which provide a set of useful methods to work with different data
 *
 * @author adiatullin
 */
public interface DataSupplierService {
    String NAME = "dsstp_DataSupplierService";

    /**
     * Format and clean address data
     *
     * @param rawAddress raw address data, cannot be null
     * @return well cleaned and full formatted address data
     */
    String getFormattedAddress(String rawAddress);

    /**
     * Format and clean address data with additional details
     *
     * @param rawAddress raw address data, cannot be null
     * @return well cleaned and full formatted address data or null if nothing found
     */
    @Nullable
    AddressData getFormattedAddressDetails(String rawAddress);

    /**
     * Get suggestions of possible addresses to user from his entered address data
     *
     * @param rawAddress user entered raw address data
     * @param count      count of the suggestion
     * @return possible suggestions addresses
     */
    List<String> getSuggestionAddresses(String rawAddress, int count);

    /**
     * Get suggestions of possible addresses to user from his entered address data with additional details
     *
     * @param rawAddress user entered raw address data
     * @param count      count of the suggestion
     * @return possible suggestions addresses
     */
    List<AddressData> getSuggestionAddressesDetails(String rawAddress, int count);
}
