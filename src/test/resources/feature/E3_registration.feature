#language: ru

Функция: E-3
  URL: http://automationpractice.com/index.php
  Это тестовый e-commerce сайт, который позволяет написать авто-тесты такого типа,
  как регистрация на сайте, поиск товара, добавление товара в корзину и так далее.

  Сценарий: E-3 Verify the ability to register
    Допустим я на странице "Authentication"
    И я заполнил поле "Email address" значением "sensesnet@gmail.com"
    И я нажимаю на кнопку "Create an account"
    То откроется страница "Create an account" на странице регистрации
    И я заполнил все необходимые поля в блоке "Your personal information":
      | title | first_name | last_name | email               | password | date_of_birth |
      | Mr    | Kirill     | Degtyarev | sensesnet@gmail.com | zvenz13  | 12.02.87      |
    И я поставил согласие "Sign up for our newsletter!"
    И я поставил согласие "Receive special offers from our partners!"
    И я заполнил все необходимые поля в блоке "Your address":
      | first_name | last_name | company   | address | address_line_2 | city      | state  | zip_postal_code | country       | additional_information | home_phone    | mobile_phone  | assign_an_address_alias_for_future_reference |
      | Kirill     | Degtyarev | Alfa-Bank | Willow  | 43 - 255       | Anchorage | Alaska | 12345           | United States | testinfo               | +375336617771 | +375336617771 | ok                                           |
    И я нажал на кнопку "Register"
#  (//*[@id='submitAccount'])
    То откроется страница "My account"
#  (.//*[@id='center_column']/h1)