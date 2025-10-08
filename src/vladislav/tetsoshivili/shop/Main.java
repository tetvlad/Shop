package vladislav.tetsoshivili.shop;

import vladislav.tetsoshivili.shop.model.Cart;
import vladislav.tetsoshivili.shop.model.Product;
import vladislav.tetsoshivili.shop.repository.InMemory;
import vladislav.tetsoshivili.shop.repository.ProductRepository;
import vladislav.tetsoshivili.shop.service.OrderService;
import vladislav.tetsoshivili.shop.service.SimpleOrderService;

import java.util.List;
import java.util.Scanner;

public class Main {
    // Завел отдельные константы, приватнуе, синтаксис соблюден.
    // "Магические числа"
    private static final int VIEW_PRODUCTS = 1;
    private static final int ADD_TO_CART = 2;
    private static final int VIEW_CART = 3;
    private static final int PLACE_ORDER = 4;
    private static final int EXIT = 0;

    // SOLID (D)
    private static final ProductRepository repository = new InMemory();
    private static final OrderService orderService = new SimpleOrderService();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case VIEW_PRODUCTS:
                    printAllProducts();
                    break;
                case ADD_TO_CART:
                    addToCart();
                    break;
                case VIEW_CART:
                    viewCart();
                    break;
                case PLACE_ORDER:
                    placeOrder();
                    break;
                case EXIT:
                    System.out.println("Спасибо, досвидания!");
                    return;
                default:
                    System.out.println("Такого пункта меню туту нет");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("--------Сток магазина--------");
        System.out.println(VIEW_PRODUCTS + ". Список товаров");
        System.out.println(ADD_TO_CART + ". Добавить товар в корзину");
        System.out.println(VIEW_CART + ". Посмотреть корзину");
        System.out.println(PLACE_ORDER + ". Оформить заказ");
        System.out.println(EXIT + ". Exit");
        System.out.println("------------------------");
    }

    // DRY Principle: метод для вывода списка товаров
    private static void printAllProducts() {
        System.out.println("Доступные товары:");
        repository.findAll().forEach(System.out::println);
    }

    private static void addToCart() {
        System.out.print("Введите ID товара для добавления в корзину: ");
        int id = Integer.parseInt(scanner.nextLine());
        repository.findById(id)
                .ifPresentOrElse(
                        product -> {
                            cart.addProduct(product);
                            System.out.println("Товар '" + product.getName() + "' добавлен в корзину.");
                        },
                        () -> System.out.println("Товар с ID " + id + " не найден.")
                );
    }

    private static void viewCart() {
        System.out.println("Ваша корзина:");
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            items.forEach(System.out::println);
            System.out.printf("Итоговая стоимость: %.2f руб.%n", cart.getTotalPrice());
        }
    }

    private static void placeOrder() {
        try {
            System.out.println(orderService.createOrder(cart));
            cart.clear(); // Очищаем корзину после успешного заказа
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
