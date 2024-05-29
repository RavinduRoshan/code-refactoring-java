package org.zenflix.service;

import org.zenflix.entity.Customer;

public interface RentalService {

    String getSummaryStatement(Customer customer);
}
