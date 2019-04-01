package com.groupstp.datasupplier.web.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultInteger;

/**
 * Web module data supplier settings interface
 *
 * @author adiatullin
 */
@Source(type = SourceType.DATABASE)
public interface DataSupplierWebConfig extends Config {

    /**
     * @return delay in ms between user entering data and searching suggestions
     */
    @Property("data-supplier.ui.delayMs")
    @DefaultInteger(300)
    Integer getDelayMs();

    /**
     * @return minimum search length when suggestions should appear
     */
    @Property("data-supplier.ui.minSearchLength")
    @DefaultInteger(5)
    Integer getMinSearchLength();

    /**
     * @return maximum count of suggestions
     */
    @Property("data-supplier.ui.limit")
    @DefaultInteger(10)
    Integer getFetchLimit();
}
