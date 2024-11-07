package store.repository;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;
import store.entity.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
@SessionScope
@RequiredArgsConstructor
@Getter
public class OrderRepository {
    private final Map<Product, Long> repository = new HashMap<>();
    private final StoreRepository store;

    @PreDestroy
    public void returnToStore() {
        for (Map.Entry<Product, Long> entry : repository.entrySet()) {
            store.getRepository().merge(entry.getKey(), entry.getValue(), Long::sum);
        }
    }
}
