package store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.entity.Product;
import store.repository.StoreRepository;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository store;

    @Override
    public Map<Product, Long> showStore() {
        return Collections.unmodifiableMap(store.getRepository());
    }

    @Override
    public void addToStore(Long vendorCode, String title) {
        store.add(new Product(vendorCode, title));
    }

    @Override
    public void addDefaultToStore() {
        store.add(new Product(10L, "title10"));
        store.add(new Product(10L, "title10"));
        store.add(new Product(11L, "title11"));
        store.add(new Product(12L, "title12"));
    }

    @Override
    public Map<Product, Long> showOrder() {
        return Collections.unmodifiableMap(store.getOrder());
    }

    @Override
    public void addToOrder(Long vendorCode) {
        store.addToOrder(vendorCode);
    }

    @Override
    public void buy() {
        store.buy();
    }
}
