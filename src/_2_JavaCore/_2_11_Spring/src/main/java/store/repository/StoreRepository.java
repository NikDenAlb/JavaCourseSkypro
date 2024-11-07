package store.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import store.entity.Product;
import store.exception.NoVendorCodeInStoreException;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
    @Getter
    private final Map<Product, Long> repository = new HashMap<>();
    private final OrderRepository order;

    public void add(Product product) {
        repository.merge(product, 1L, Long::sum);
    }

    public Map<Product, Long> getOrder() {
        return order.getRepository();
    }

    public void addToOrder(Long vendorCode) {
        Product product = repository.keySet().stream()
                .filter(e -> e.getVendorCode().equals(vendorCode))
                .findAny().orElseThrow(() -> new NoVendorCodeInStoreException("На складе такой продукт не доступен"));
        if (repository.get(product).equals(1L)) {
            repository.remove(product);
        } else {
            repository.merge(product, -1L, Long::sum);
        }
        order.getRepository().merge(product, 1L, Long::sum);
    }

    public void buy() {
        order.getRepository().clear();
    }
}
