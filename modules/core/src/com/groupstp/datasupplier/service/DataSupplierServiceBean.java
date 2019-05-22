package com.groupstp.datasupplier.service;

import com.groupstp.datasupplier.core.bean.DataSupplierWorker;
import com.groupstp.datasupplier.data.AddressData;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
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

    @Nullable
    @Override
    public AddressData getFormattedAddressDetails(String rawAddress) {
        return worker.getFormattedAddressDetails(rawAddress);
    }

    @Nullable
    @Override
    public AddressData getSuggestionAddressDetails(String rawAddress) {
        List<AddressData> data = getSuggestionAddressesDetails(rawAddress, 1);
        if (!CollectionUtils.isEmpty(data)) {
            return data.get(0);
        }
        return null;
    }

    @Nullable
    @Override
    public AddressData getSuggestionAddressDetails(double latitude, double longitude) {
        List<AddressData> data = getSuggestionAddressesDetails(latitude, longitude, 1);
        if (!CollectionUtils.isEmpty(data)) {
            return data.get(0);
        }
        return null;
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

    @Nullable
    @Override
    public AddressData getExtendedSuggestionAddressDetails(AddressData selected) {
        return worker.getExtendedSuggestionAddressDetails(selected);
    }
}
