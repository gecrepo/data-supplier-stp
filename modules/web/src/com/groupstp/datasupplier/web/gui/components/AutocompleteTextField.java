package com.groupstp.datasupplier.web.gui.components;

import com.haulmont.cuba.gui.components.TextField;

import java.util.List;

/**
 * Special text field which support a suggestions auto complete
 *
 * @author adiatullin
 */
public interface AutocompleteTextField extends TextField {
    String NAME = "autocompleteTextField";

    /**
     * Suggestions provider
     */
    interface SuggestionProvider {
        /**
         * Provide a list of possible suggestions by entered user value
         *
         * @param currentValue user entered value
         * @param limit        maximum count of suggestions
         * @return list of suggestions
         */
        List<String> getSuggestions(String currentValue, int limit);
    }

    /**
     * @return min string length to perform suggestions search
     */
    int getMinSearchStringLength();

    /**
     * Sets min string length which is required to perform suggestions search.
     *
     * @param minSearchStringLength required string length to perform search
     */
    void setMinSearchStringLength(int minSearchStringLength);

    /**
     * @return delay between the last key press action and async search
     */
    int getAsyncSearchDelayMs();

    /**
     * Sets delay between the last key press action and async search.
     *
     * @param delay delay in ms
     */
    void setAsyncSearchDelayMs(int delay);

    /**
     * @return limit of suggestions which will be shown
     */
    int getSuggestionsLimit();

    /**
     * Sets limit of suggestions which will be shown.
     *
     * @param limit integer limit value
     */
    void setSuggestionsLimit(int limit);

    /**
     * @return {@link AutocompleteTextField.SuggestionProvider} which provide a suggestions.
     */
    SuggestionProvider getSuggestionProvider();

    /**
     * Sets {@link AutocompleteTextField.SuggestionProvider} which provide a suggestions.
     *
     * @param suggestionProvider SearchExecutor instance
     */
    void setSuggestionProvider(SuggestionProvider suggestionProvider);
}