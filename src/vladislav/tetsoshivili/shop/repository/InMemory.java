package vladislav.tetsoshivili.shop.repository;

import vladislav.tetsoshivili.shop.model.Product;
import java.util.List;
import java.util.Optional;

public class InMemory implements ProductRepository {
    private final List<Product> products;

    public InMemory() {
        // Инициализируем наш "склад" товаров
        this.products = List.of(
                new Product(1, "Йогур", 50.99),
                new Product(2, "Булка", 39.99),
                new Product(3, "Кола", 115.75),
                new Product(4, "Мясо", 320.00),
                new Product(5, "Торт", 199.99),
                new Product(6, "Хлеб", 39.45),
                new Product(7, "Боржоми", 80.95),
                new Product(8, "Лосось", 590.00)
        );
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
