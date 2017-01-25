#language: ru

Функция: E-1,E-2
  URL: http://automationpractice.com/index.php
  Это тестовый e-commerce сайт, который позволяет написать авто-тесты такого типа,
  как регистрация на сайте, поиск товара, добавление товара в корзину и так далее.

  Сценарий: E-4 Verify the ability to search items
    Допустим я на доавторизационной странице
    И я ввожу в поле "Search" значение "Blouse"
    И я нажимаю на кнопку "Find"
    То отобразится страница "Search"
#  (//*[@id='center_column']/h1 )
    И отобразится сообщение:
    """
    result has been found.
    """
#    //*[@id='center_column']/h1/span[2]
    И отобразится ссылка на товар "Blouse"
#  //*[@id='center_column']/ul/li/div/div[2]/h5/a

  Сценарий: E-5 Verify the ability to add and delete items from cart
    Допустим я на доавторизационной странице
    И я ввожу в поле "Search" значение "Blouse"
    И я нажимаю на кнопку "Add to cart"
    То отобразится сообщение:
    """
    Product successfully added to your shopping cart
    """
    И отобразится поле "Product" со значением "Picture"
    И отобразится поле "Description" со значением "Faded Short Sleeve T-shirts"
    И отобразится поле "Unit price" со значением "$16.51"
    И отобразится поле "Total" со значением "$16.51"
    И отобразится строка "Total" со значением "$18.51"
#    //*[@id='layer_cart']/div[1]/div[1]/div[1]/img
    Если я нажимаю на кнопку "Proceed to checkout"
#    .//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span
    То откроется страница "Shopping-cart summary"
#    //*[@id='cart_title']
    Если я нажимаю на кнопку "Delete"
    То отобразится сообщение:
    """
    Your shopping cart is empty.
    """
#    //*[@id='center_column']/p

  Сценарий: E-6 CatalogTest.
    Допустим я на странице "Women"
    И я нажал на ссылку "T-Shirts"
    То отобразится страница "T-Shirts"
#//*[@id='center_column']/h1/span[1]
    И отобразится товар "T-Shirts"
#    //*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img
