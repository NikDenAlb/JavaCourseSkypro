package store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import store.entity.Product;
import store.service.StoreService;

import java.util.Map;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping()
    public Map<Product, Long> showStore() {
        return storeService.showStore();
    }

    @GetMapping(path = "/add")
    public String addToStore(@RequestParam("vendorCode") Long vendorCode,
                             @RequestParam("title") String title) {
        storeService.addToStore(vendorCode, title);
        return "Товар добавлен на склад";
    }

    @GetMapping(path = "/addDefaultPackage")
    public String addDefaultPackage() {
        storeService.addDefaultToStore();
        return "В склад добавлен дефолтный набор товаров";
    }

    @GetMapping(path = "/order/get")
    public Map<Product, Long> showOrder() {
        return storeService.showOrder();
    }

    @GetMapping(path = "/order/add")
    public String addToOrder(@RequestParam("vendorCode") Long vendorCode) {
        storeService.addToOrder(vendorCode);
        return "Товар добавлен в корзину";
    }

    @GetMapping(path = "/order/buy")
    public String addToOrder() {
        storeService.buy();
        return "Корзина выкуплена";
    }
}
