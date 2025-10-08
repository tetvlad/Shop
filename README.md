Какие принципы были применены в программе по заданию:

SOLID:

1) S - принцип единственной ответственности (Single Responsibility Principle)
	"Класс должен выполнять только те функции, для которых он логически предназначен"
	Класс "Cart.java".
	Этот класс отвечает только за корзину: добавление товаров, их получение и подсчет общей суммы. 

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/model/Cart.java

2)  O - принцип открытости/закрытости (Open Closed Principle)
	"Программные сущности должны быть открыты для расширения, но закрыты для модификации."
	Класс "OrderService.java".
	Можно расширять функционал, если программу нужно будет усложнить и добавить новую логику.

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/service/OrderService.java

3)  I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
	"Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения"
	Как пример - "ProductRepository" 

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/repository/ProductRepository.java

4) D - принцип инверсии зависимостей (Dependency Inversion Principle)
	"Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга."
	В классе "Main.java", строки инициализации сервисов.

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/Main.java

DRY:

Метод "printAllProducts" в классе "Main.java") 

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/Main.java#L68


Magics (Магические числа): 

Добавлены приватные константы для меню в класс "Main.java":

	https://github.com/tetvlad/Shop/blob/main/src/vladislav/tetsoshivili/shop/Main.java#L13-L20
