package com.groupstp.datasupplier.web.util;

import com.groupstp.datasupplier.service.DataSupplierService;
import com.groupstp.datasupplier.web.config.DataSupplierWebConfig;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.gui.components.SuggestionField;

/**
 * Data supplier address helper class
 *
 * @author adiatullin
 */
public final class AddressUiHelper {
    private AddressUiHelper() {
    }

    /**
     * Prepare, clean and format address data
     *
     * @param address raw address data
     * @return formatted address
     */
    public static String formatAddress(String address) {
        return ((DataSupplierService) AppBeans.get(DataSupplierService.NAME)).getFormattedAddress(address);
    }

    /**
     * Setup address suggestion field
     *
     * @param field UI suggestion field
     */
    public static void showAddressSuggestions(SuggestionField field) {
        DataSupplierWebConfig config = ((Configuration) AppBeans.get(Configuration.NAME)).getConfig(DataSupplierWebConfig.class);

        showAddressSuggestions(field, config.getDelayMs(), config.getMinSearchLength(), config.getFetchLimit());
    }

    /**
     * Setup address suggestion field
     *
     * @param field           UI suggestion field
     * @param delayMs         delay in ms between user entering data and searching suggestions
     * @param minSearchLength minimum search length when suggestions should appear
     * @param count           maximum count of suggestions
     */
    public static void showAddressSuggestions(SuggestionField field, int delayMs, int minSearchLength, int count) {
        DataSupplierService service = AppBeans.get(DataSupplierService.NAME);

        field.setAsyncSearchDelayMs(delayMs);
        field.setMinSearchStringLength(minSearchLength);
        field.setSuggestionsLimit(count);
        field.setSearchExecutor((search, params) -> service.getSuggestionAddresses(search, field.getSuggestionsLimit()));
    }
}
