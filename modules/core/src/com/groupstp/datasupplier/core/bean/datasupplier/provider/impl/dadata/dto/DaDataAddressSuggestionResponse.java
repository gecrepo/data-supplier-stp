package com.groupstp.datasupplier.core.bean.datasupplier.provider.impl.dadata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * DaData service address suggestion request class
 *
 * @author adiatullin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaDataAddressSuggestionResponse implements Serializable {
    private static final long serialVersionUID = 6935131198421371701L;

    @JsonProperty("suggestions")
    private List<DaDataAddressSuggestion> suggestions;


    public List<DaDataAddressSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<DaDataAddressSuggestion> suggestions) {
        this.suggestions = suggestions;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DaDataAddressSuggestion implements Serializable {
        private static final long serialVersionUID = 44255843570252991L;

        @JsonProperty("value")
        private String value;
        @JsonProperty("unrestricted_value")
        private String unrestrictedValue;
        @JsonProperty("data")
        private DaDataAddress data;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUnrestrictedValue() {
            return unrestrictedValue;
        }

        public void setUnrestrictedValue(String unrestrictedValue) {
            this.unrestrictedValue = unrestrictedValue;
        }

        public DaDataAddress getData() {
            return data;
        }

        public void setData(DaDataAddress data) {
            this.data = data;
        }
    }
}
