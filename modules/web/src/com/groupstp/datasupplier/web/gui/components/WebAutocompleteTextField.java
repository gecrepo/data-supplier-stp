package com.groupstp.datasupplier.web.gui.components;

import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.Datatypes;
import com.haulmont.cuba.gui.components.Formatter;
import com.haulmont.cuba.web.gui.components.WebAbstractTextField;
import com.haulmont.cuba.web.gui.components.WebWrapperUtils;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.ShortcutListener;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestion;
import eu.maxschuster.vaadin.autocompletetextfield.AutocompleteSuggestionProvider;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Web implementation of auto complete text field
 *
 * @author adiatullin
 */
public class WebAutocompleteTextField extends WebAbstractTextField<eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField> implements AutocompleteTextField {

    protected SuggestionProvider suggestionProvider;
    protected Datatype datatype;
    protected Formatter formatter;

    protected boolean trimming = true;
    protected FieldEvents.TextChangeListener textChangeListener;
    protected ShortcutListener enterShortcutListener;


    public WebAutocompleteTextField() {
    }

    @Override
    protected eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField createTextFieldImpl() {
        eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField field = new eu.maxschuster.vaadin.autocompletetextfield.AutocompleteTextField();
        field.setMinChars(2);
        field.setSuggestionLimit(10);
        field.setDelay(200);

        field.setSuggestionProvider((AutocompleteSuggestionProvider) e -> {
            if (suggestionProvider != null) {
                List<String> items = suggestionProvider.getSuggestions(e.getTerm(), e.getLimit());
                if (!CollectionUtils.isEmpty(items)) {
                    List<AutocompleteSuggestion> result = new ArrayList<>(items.size());
                    for (String item : items) {
                        result.add(new AutocompleteSuggestion(item));
                    }
                    return result;
                }
            }
            return Collections.emptyList();
        });

        return field;
    }

    @Override
    public int getMinSearchStringLength() {
        return component.getMinChars();
    }

    @Override
    public void setMinSearchStringLength(int minSearchStringLength) {
        component.setMinChars(minSearchStringLength);
    }

    @Override
    public int getAsyncSearchDelayMs() {
        return component.getDelay();
    }

    @Override
    public void setAsyncSearchDelayMs(int delay) {
        component.setDelay(delay);
    }

    @Override
    public int getSuggestionsLimit() {
        return component.getSuggestionLimit();
    }

    @Override
    public void setSuggestionsLimit(int limit) {
        component.setSuggestionLimit(limit);
    }

    @Override
    public SuggestionProvider getSuggestionProvider() {
        return suggestionProvider;
    }

    @Override
    public void setSuggestionProvider(SuggestionProvider suggestionProvider) {
        this.suggestionProvider = suggestionProvider;
    }

    @Override
    public Datatype getDatatype() {
        return datatype;
    }

    @Override
    public void setDatatype(Datatype datatype) {
        this.datatype = datatype;
        if (datatype == null) {
            initFieldConverter();
        } else {
            component.setConverter(new TextFieldStringToDatatypeConverter(datatype));
        }
    }

    @Override
    public CaseConversion getCaseConversion() {
        return null;
    }

    @Override
    public void setCaseConversion(CaseConversion caseConversion) {
    }

    @Override
    public Formatter getFormatter() {
        return formatter;
    }

    @Override
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public int getMaxLength() {
        return component.getMaxLength();
    }

    @Override
    public void setMaxLength(int value) {
        component.setMaxLength(value);
    }

    @Override
    protected Datatype getActualDatatype() {
        if (metaProperty != null) {
            return metaProperty.getRange().isDatatype() ? metaProperty.getRange().asDatatype() : null;
        } else if (datatype != null) {
            return datatype;
        } else {
            return Datatypes.getNN(String.class);
        }
    }

    @Override
    public boolean isTrimming() {
        return trimming;
    }

    @Override
    public void setTrimming(boolean trimming) {
        this.trimming = trimming;
    }

    @Override
    public String getInputPrompt() {
        return component.getInputPrompt();
    }

    @Override
    public void setInputPrompt(String inputPrompt) {
        component.setInputPrompt(inputPrompt);
    }

    @Override
    public void setCursorPosition(int position) {
        component.setCursorPosition(position);
    }

    @Override
    public String getRawValue() {
        return component.getValue();
    }

    @Override
    public void selectAll() {
        component.selectAll();
    }

    @Override
    public void setSelectionRange(int pos, int length) {
        component.setSelectionRange(pos, length);
    }

    @Override
    public void addTextChangeListener(TextChangeListener listener) {
        getEventRouter().addListener(TextChangeListener.class, listener);

        if (textChangeListener == null) {
            textChangeListener = (FieldEvents.TextChangeListener) e -> {
                TextChangeEvent event = new TextChangeEvent(this, e.getText(), e.getCursorPosition());

                getEventRouter().fireEvent(TextChangeListener.class, TextChangeListener::textChange, event);
            };
            component.addTextChangeListener(textChangeListener);
        }
    }

    @Override
    public void removeTextChangeListener(TextChangeListener listener) {
        getEventRouter().removeListener(TextChangeListener.class, listener);

        if (textChangeListener != null && !getEventRouter().hasListeners(TextChangeListener.class)) {
            component.removeTextChangeListener(textChangeListener);
            textChangeListener = null;
        }
    }

    @Override
    public void setTextChangeTimeout(int timeout) {
        component.setTextChangeTimeout(timeout);
    }

    @Override
    public int getTextChangeTimeout() {
        return component.getTextChangeTimeout();
    }

    @Override
    public TextChangeEventMode getTextChangeEventMode() {
        return WebWrapperUtils.toTextChangeEventMode(component.getTextChangeEventMode());
    }

    @Override
    public void setTextChangeEventMode(TextChangeEventMode mode) {
        component.setTextChangeEventMode(WebWrapperUtils.toVaadinTextChangeEventMode(mode));
    }

    @Override
    public void addEnterPressListener(EnterPressListener listener) {
        getEventRouter().addListener(EnterPressListener.class, listener);

        if (enterShortcutListener == null) {
            enterShortcutListener = new ShortcutListener("", com.vaadin.event.ShortcutAction.KeyCode.ENTER, null) {
                @Override
                public void handleAction(Object sender, Object target) {
                    EnterPressEvent event = new EnterPressEvent(WebAutocompleteTextField.this);
                    getEventRouter().fireEvent(EnterPressListener.class, EnterPressListener::enterPressed, event);
                }
            };
            component.addShortcutListener(enterShortcutListener);
        }
    }

    @Override
    public void removeEnterPressListener(EnterPressListener listener) {
        getEventRouter().removeListener(EnterPressListener.class, listener);

        if (enterShortcutListener != null && !getEventRouter().hasListeners(EnterPressListener.class)) {
            component.removeShortcutListener(enterShortcutListener);
        }
    }

    @Override
    public void setHtmlName(String htmlName) {
    }

    @Override
    public String getHtmlName() {
        return null;
    }
}