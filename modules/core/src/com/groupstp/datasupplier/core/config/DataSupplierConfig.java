package com.groupstp.datasupplier.core.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;
import com.haulmont.cuba.core.config.defaults.DefaultBoolean;
import com.haulmont.cuba.core.config.defaults.DefaultInteger;

/**
 * Data supplier (address suggestions, address formatting and etc) settings config class
 *
 * @author adiatullin
 */
@Source(type = SourceType.DATABASE)
public interface DataSupplierConfig extends Config {
    /**
     * @return is data supplier service enabled
     */
    @Property("data-supplier.enabled")
    @DefaultBoolean(true)
    Boolean getEnabled();

    /**
     * @return DaData provider API key
     */
    @Property("data-supplier.daData.apiKey")
    String getDaDataApiKey();

    /**
     * @return DaData provider secret key
     */
    @Property("data-supplier.daData.secretKey")
    String getDaDataSecretKey();

    /**
     * @return DaData provider basic rest endpoint url
     */
    @Property("data-supplier.daData.restEndpoint")
    @Default("https://dadata.ru/api/v2")
    String getDaDataRestEndpoint();

    /**
     * @return DaData provider basic rest endpoint url
     */
    @Property("data-supplier.daData.restSuggestionEndpoint")
    @Default("https://suggestions.dadata.ru/suggestions/api/4_1/rs")
    String getDaDataRestSuggestionEndpoint();

    /**
     * @return DaData provider communication timeout in ms
     */
    @Property("data-supplier.daData.timeOutMs")
    @DefaultInteger(5000)
    Integer getTimeoutMs();

    /**
     * @return special property to prevent an external locking
     */
    @Property("data-supplier.daData.requestsPerSecond")
    @DefaultInteger(10)
    Integer getRequestsPerSecond();
}
