Три микросервиса
1. empl-service -крутится на порту 8080 там основная бизнес логика и прикручен postgres
POST api/employees` - добавить сотрудника (принимает `name`, `salary`, возвращает созданного сотрудника с `id`).
        * `PATCH api/employees/{id}/salary` - изменить зарплату сотруднику (принимает новую `salary`, возвращает обновленного сотрудника или `204 No Content`).
        * `GET api/employees` - получить всех сотрудников.
        * `DELETE api/employees/{id}` - удалить сотрудника (возвращает `204 No Content`)

2. empl-config-server конфигурации для проекта ссылка на гит https://github.com/digitalnja/config-repo
3. empl-gateway
   крутится на порту 8081, маршрутизирует запросы с api/employees на empl-service
   
