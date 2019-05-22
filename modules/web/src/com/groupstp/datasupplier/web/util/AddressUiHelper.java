package com.groupstp.datasupplier.web.util;

import com.groupstp.datasupplier.data.AddressData;
import com.groupstp.datasupplier.service.DataSupplierService;
import com.groupstp.datasupplier.web.config.DataSupplierWebConfig;
import com.groupstp.datasupplier.web.gui.components.AutocompleteTextField;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.SuggestionField;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Nullable;
import java.util.*;

/**
 * Data supplier address helper class
 *
 * @author adiatullin
 */
public final class AddressUiHelper {
    private AddressUiHelper() {
    }

    /**
     * Address select listener
     */
    public interface AddressSelectListener {
        /**
         * User clicked the address suggestion
         *
         * @param field    field object which are communicated with user
         * @param value    user selected current address
         * @param previous previous address value
         */
        void onAddressSelect(Field field, @Nullable AddressData value, @Nullable AddressData previous);
    }

    /**
     * Prepare, clean and format address data. In most cases it more detailed method than suggestions
     *
     * @param address raw address data
     * @return formatted address
     */
    public static String getFormattedAddress(String address) {
        return ((DataSupplierService) AppBeans.get(DataSupplierService.NAME)).getFormattedAddress(address);
    }

    /**
     * Setup address suggestion field
     *
     * @param field UI suggestion field
     */
    public static void showAddressSuggestions(SuggestionField field) {
        showAddressSuggestions(field, null);
    }

    /**
     * Setup address suggestion field with listener
     *
     * @param field    UI suggestion field
     * @param listener address select listener
     */
    public static void showAddressSuggestions(SuggestionField field, @Nullable AddressSelectListener listener) {
        DataSupplierWebConfig config = ((Configuration) AppBeans.get(Configuration.NAME)).getConfig(DataSupplierWebConfig.class);

        showAddressSuggestions(field, config.getDelayMs(), config.getMinSearchLength(), config.getFetchLimit(), listener);
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
        showAddressSuggestions(field, delayMs, minSearchLength, count, null);
    }

    /**
     * Setup address suggestion field with listener
     *
     * @param field           UI suggestion field
     * @param delayMs         delay in ms between user entering data and searching suggestions
     * @param minSearchLength minimum search length when suggestions should appear
     * @param count           maximum count of suggestions
     * @param listener        address select listener
     */
    public static void showAddressSuggestions(SuggestionField field, int delayMs, int minSearchLength, int count, @Nullable AddressSelectListener listener) {
        DataSupplierService service = AppBeans.get(DataSupplierService.NAME);

        field.setAsyncSearchDelayMs(delayMs);
        field.setMinSearchStringLength(minSearchLength);
        field.setSuggestionsLimit(count);

        Map<String, AddressData> cache = new HashMap<>();
        field.setSearchExecutor((search, params) -> {
            cache.clear();

            List<String> result = Collections.emptyList();
            List<AddressData> items = service.getSuggestionAddressesDetails(search, field.getSuggestionsLimit());
            if (!CollectionUtils.isEmpty(items)) {
                result = new ArrayList<>(items.size());
                for (AddressData item : items) {
                    cache.put(item.getAddress(), item);

                    result.add(item.getAddress());
                }
            }
            return result;
        });
        if (listener != null) {
            AddressData[] previousDataHolder = new AddressData[1];
            field.addValueChangeListener(e -> {
                String address = field.getValue();

                AddressData current = service.getExtendedSuggestionAddressDetails(cache.get(address));
                AddressData previous = previousDataHolder[0];
                previousDataHolder[0] = current;

                listener.onAddressSelect(field, current, previous);
            });
        }
    }

    /**
     * Setup address suggestion field
     *
     * @param field UI autocomplete field
     */
    public static void showAddressSuggestions(AutocompleteTextField field) {
        showAddressSuggestions(field, (AddressSelectListener) null);
    }

    /**
     * Setup address suggestion field with select listener
     *
     * @param field    UI autocomplete field
     * @param listener address select listener
     */
    public static void showAddressSuggestions(AutocompleteTextField field, @Nullable AddressSelectListener listener) {
        DataSupplierWebConfig config = ((Configuration) AppBeans.get(Configuration.NAME)).getConfig(DataSupplierWebConfig.class);

        showAddressSuggestions(field, config.getDelayMs(), config.getMinSearchLength(), config.getFetchLimit(), listener);
    }


    /**
     * Setup address suggestion field
     *
     * @param field           UI autocomplete field
     * @param delayMs         delay in ms between user entering data and searching suggestions
     * @param minSearchLength minimum search length when suggestions should appear
     * @param count           maximum count of suggestions
     */
    public static void showAddressSuggestions(AutocompleteTextField field, int delayMs, int minSearchLength, int count) {
        showAddressSuggestions(field, delayMs, minSearchLength, count, null);
    }

    /**
     * Setup address suggestion field
     *
     * @param field           UI autocomplete field
     * @param delayMs         delay in ms between user entering data and searching suggestions
     * @param minSearchLength minimum search length when suggestions should appear
     * @param count           maximum count of suggestions
     * @param listener        address select listener
     */
    public static void showAddressSuggestions(AutocompleteTextField field, int delayMs, int minSearchLength, int count, @Nullable AddressSelectListener listener) {
        DataSupplierService service = AppBeans.get(DataSupplierService.NAME);

        field.setAsyncSearchDelayMs(delayMs);
        field.setMinSearchStringLength(minSearchLength);
        field.setSuggestionsLimit(count);

        Map<String, AddressData> cache = new HashMap<>();
        field.setSuggestionProvider((currentValue, limit) -> {
            cache.clear();

            List<String> result = Collections.emptyList();
            List<AddressData> items = service.getSuggestionAddressesDetails(currentValue, limit);
            if (!CollectionUtils.isEmpty(items)) {
                result = new ArrayList<>(items.size());
                for (AddressData item : items) {
                    cache.put(item.getAddress(), item);

                    result.add(item.getAddress());
                }
            }
            return result;
        });
        if (listener != null) {
            AddressData[] previousDataHolder = new AddressData[1];
            field.addValueChangeListener(e -> {
                String address = field.getValue();

                AddressData current = service.getExtendedSuggestionAddressDetails(cache.get(address));
                AddressData previous = previousDataHolder[0];
                previousDataHolder[0] = current;

                listener.onAddressSelect(field, current, previous);
            });
        }
    }
}
