package com.groupstp.datasupplier.service;
import com.groupstp.datasupplier.core.bean.DataSupplierWorker;
import com.groupstp.datasupplier.data.AddressData;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Basic data supplier service bean component
 *
 * @author adiatullin
 */
@Service(DataSupplierServiceBean.NAME)
public class DataSupplierServiceBean implements DataSupplierService {

    @Inject
    protected DataSupplierWorker worker;

    @Override
    public String getFormattedAddress(String rawAddress) {
        return worker.getFormattedAddress(rawAddress);
    }

    @Override
    public AddressData getFormattedAddressDetails(String rawAddress) {
        return worker.getFormattedAddressDetails(rawAddress);
    }

    @Override
    public List<String> getSuggestionAddresses(String rawAddress, int count) {
        return worker.getSuggestionAddresses(rawAddress, count);
    }

    @Override
    public List<AddressData> getSuggestionAddressesDetails(String rawAddress, int count) {
        return worker.getSuggestionAddressesDetails(rawAddress, count);
    }

    @Override
    public List<AddressData> getSuggestionAddressesDetails(double latitude, double longitude, int count) {
        return worker.getSuggestionAddressesDetails(latitude, longitude, count);
    }
}
