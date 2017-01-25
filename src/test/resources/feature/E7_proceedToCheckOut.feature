#language: ru

Функция: E-1,E-2
  URL: http://automationpractice.com/index.php
  Это тестовый e-commerce сайт, который позволяет написать авто-тесты такого типа,
  как регистрация на сайте, поиск товара, добавление товара в корзину и так далее.

  Сценарий: E-7 ProceedToCheckout
    Допустим я на доавторизационной странице
    И я ввожу в поле "Search" значение "Blouse"
    И я нажимаю на кнопку "Add to cart"
    То отобразится сообщение:
    """
    Product successfully added to your shopping cart
    """
    И товар "Blouse" отобразится в карзине
#    //*[@id='layer_cart']/div[1]/div[1]/div[1]/img
    Если я нажимаю на кнопку "Proceed to checkout"
#    .//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span
    То откроется страница "Shopping-cart summary"
    И отобразится шаг "01. Summary" зеленым цветом
#    //*[@id='product_1_1_0_10950']/td[2]/p/a
    И я нажимаю на кнопку "Proceed to checkout"
#    //*[@id='center_column']/p[2]/a[1]/span
    И отобразится шаг "03. Sign in" зеленым цветом
    И я нажимаю на кнопку "Proceed to checkout"
    И отобразится шаг "03. Address" зеленым цветом
    И я нажимаю на кнопку "Proceed to checkout"
    И отобразится шаг "04. Shipping" зеленым цветом
    И я поставил согласие "I agree to the terms of service and will adhere to them unconditionally."
    И я нажимаю на кнопку "Proceed to checkout"
    И отобразится шаг "05. Payment" зеленым цветом
    И товар "Blouse" отобразится в карзине
    И отобразится поле "Product" со значением "Picture"
    И отобразится поле "Description" со значением "Faded Short Sleeve T-shirts"
    И отобразится поле "Unit price" со значением "$16.51"
    И отобразится поле "Total" со значением "$16.51"
    И отобразится строка "Total" со значением "$18.51"
    И я нажимаю на ссылку "Pay by bank wire"
    То отобразится страница "Bank-wire payment."
    #    .//*[@id='HOOK_PAYMENT']/div[1]/div/p/a
    И я нажимаю на кнопку "Proceed to checkout"
#    .//*[@id='cart_navigation']/button
    То отобразится сообщение:
    """
      Your order on My Store is complete.
      Please send us a bank wire with
      - Amount $29.00
      - Name of account owner Pradeep Macharla
      - Include these details xyz
      - Bank name RTP
      - Do not forget to insert your order reference YXDAUAIFG in the subject of your bank wire.
      An email has been sent with this information.
      Your order will be sent as soon as we receive payment.
      If you have questions, comments or concerns, please contact our expert customer support team. .
    """
    Если я открою страницу "My account"
    И я нажму на кнопку "Order history and details"
#  .//*[@id='center_column']/div/div[1]/ul/li[1]/a/span
    То отобразится страница "Order history"
#    .//*[@id='center_column']/h1
    И отобразится поле "Order" со значением
#  //*[@id='order-list']/tbody/tr[1]/td[1]/a
    И отобразится поле "reference" со значением "$16.51"
    И отобразится поле "Date" со значением "$16.51"
    И отобразится поле "Total price"  со значением "$16.51"
    И отобразится поле "Payment" со значением "$16.51"
    И отобразится поле "Status" со значением "$16.51"
    И отобразится поле "Invoice" со значением "$16.51"