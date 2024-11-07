package store.service;

import store.entity.Product;

import java.util.Map;

public interface StoreService {
    Map<Product, Long> showStore();

    void addToStore(Long vendorCode, String title);

    void addDefaultToStore();

    Map<Product, Long> showOrder();

    void addToOrder(Long vendorCode);

    void buy();
}
