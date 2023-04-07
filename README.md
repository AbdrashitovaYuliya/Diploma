# Дипломный проект по профессии «Тестировщик»

*Дипломный проект* — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Описание приложения

*Приложение* — это веб-сервис, который предлагает купить тур по фиксированной цене двумя способами:

* Обычная оплата по дебетовой карте.
* Уникальная технология: выдача кредита по данным банковской карты.


Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей, далее Payment Gate;
* кредитному сервису, далее Credit Gate.


Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

## Необходимое окружение
1. Intellij IDEA
2. Java 11
3. Docker Toolbox
4. Git и GitHub
5. Браузер Google Chrome
6. Свободные порты  8080, 9999, 5432 и 3306


# Подготовка к запуску
1. Клонировать проект при помощи команды *git clone https://github.com/AbdrashitovaYuliya/Diplom.git*
2. Запустить Docker
3. Запустить IntelliJ IDEA
4. Открыть проект в IntelliJ IDEA


# Запуск приложения
* Через терминал Intellij IDEA запустить контейнер с MySQL - *docker-compose up -d --build*
* запустить приложение, работающее с MySQL, - *java -jar aqa-shop.jar -P:jdbc.url=jdbc:mysql://localhost:3306/database -P:jdbc.user=user -P:jdbc.password=password*


или


* запустить приложение, работающее с PostgreSQL, - *java -jar aqa-shop.jar -P:jdbc.url=jdbc:postgresql://localhost:5432/database -P:jdbc.user=user -P:jdbc.password=password*
* В новой вкладке терминала Intellij IDEA запустить SUT при помощи команды *java -jar artifacts/aqa-shop.jar*
* В браузере Google Сhrome ввести URL *http://localhost/8080/* и убедиться, что приложение успешно запустилось


    
* запустить тесты с Allure:
    * для запуска с MySQL:
   
   gradlew -Ddb.url=jdbc:mysql://localhost:3306/database clean test
   
    * для запуска с PostgreSQL:
   
   gradlew -Ddb.url=jdbc:postgresql://localhost:5432/database clean test
   
* по умолчанию приложение открыто по http://localhost:8080/ Для изменения адреса в команду запуска тестов добавить *-Dsut.url=<адрес>*
* для подключения с другим именем пользователя и паролем к БД в команду запуска тестов добавить *-Ddb.user=<имя_пользователя>* и *-Ddb.password=<пароль>*
* получить отчет о тестировании (Allure) - *gradlew allureServe*
* по окончании тестов закрыть приложение (Ctrl+C)
* остановить контейнер - *docker-compose down*


## Документация:
1. [Задание](https://github.com/AbdrashitovaYuliya/Diploma/blob/master/docs/Task.md)
2. [План работ](https://github.com/AbdrashitovaYuliya/Diploma/blob/master/docs/Plan.md)
3. [Отчетные документы по итогам тестирования](https://github.com/AbdrashitovaYuliya/Diploma/blob/master/docs/Report.md)
4. [Отчетные документы по итогам автоматизации]()