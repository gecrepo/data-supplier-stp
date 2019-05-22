package com.groupstp.datasupplier.core.bean.datasupplier.provider;

import com.groupstp.datasupplier.data.AddressData;
import org.springframework.core.Ordered;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Special data supplier provider delegates which perform retrieving and processing data directly
 *
 * @author adiatullin
 */
public interface DataProviderDelegate extends Ordered {

    /**
     * Format and clean address data with additional details
     *
     * @param rawAddress raw address data, cannot be null
     * @return well cleaned and full formatted address data
     */
    @Nullable
    AddressData getFormattedAddressDetails(String rawAddress);

    /**
     * If user selected the suggestion this method provide more detailed address data
     *
     * @param selected user selected suggestion address
     * @return more detailed suggestion address data
     */
    @Nullable
    AddressData getExtendedSuggestionAddressDetails(AddressData selected);

    /**
     * Get suggestions of possible addresses to user from his entered address data with additional details.
     * If count = 1 when server will provide more detailed suggestion automatically
     *
     * @param rawAddress user entered raw address data
     * @param count      count of the suggestion
     * @return possible suggestions addresses
     */
    @Nullable
    List<AddressData> getSuggestionAddressesDetails(String rawAddress, int count);

    /**
     * Get suggestions of possible addresses to user from geo coordinates points
     *
     * @param latitude  geo point latitude
     * @param longitude geo point longitude
     * @param count     count of the suggestion
     * @return possible suggestions addresses
     */
    @Nullable
    List<AddressData> getSuggestionAddressesDetails(double latitude, double longitude, int count);
}
