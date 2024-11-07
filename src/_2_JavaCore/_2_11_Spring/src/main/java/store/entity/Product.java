package store.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class Product {
    @Getter
    private final Long vendorCode;
    private final String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(vendorCode, product.vendorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendorCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "vendorCode=" + vendorCode +
                ", title='" + title + '\'' +
                '}';
    }
}
