#language: ru

@contact_us
Функция: Final task
  URL: http://automationpractice.com/index.php
  Это тестовый e-commerce сайт, который позволяет написать авто-тесты такого типа,
  как регистрация на сайте, поиск товара, добавление товара в корзину и так далее.

  Сценарий: E-1 Verify that contact us form sends successfully
    Допустим я на странице "ContactUs"
    И я заполнил все необходимые поля:
      | subject_heading | email_address       | order_reference | message             |
      | Webmaster       | sensesnet@gmail.com | 123Qw           | It is test message! |
    И я прикрепил "message.txt" файл в поле "Attach File"
    И я нажимаю на кнопку "Send"
    То отобразится сообщение об успешной отправке:
    """
    Your message has been successfully sent to our team.
    """

  Сценарий: E-2 Verify that error message appears if Message area is empty
    Допустим я на странице "ContactUs"
    И я заполнил все необходимые поля:
      | subject_heading | email_address       | order_reference | message |
      | Webmaster       | sensesnet@gmail.com | 123Qw           |         |
    И я нажимаю на кнопку "Send"
    То отобразится сообщение об неуспешной отправке:
    """
    The message cannot be blank.
    """

