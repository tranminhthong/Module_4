package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.service.impl.HibernateCustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new HibernateCustomerServiceImpl();
        }
        return singleton;
    }
}
