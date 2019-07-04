# EPAM
 Developing a web application to search for movies based on preferences.

# Работа с GitHub
## 1. Начало работы

### Настройка:
  1. Вводим в git bash:
  ```
    $ git config --global user.email "you@example.com"
    $ git config --global user.name "Your name"
    $ git config --global core.editor notepad
  ```
  2. Заходим на [страницу проекта](https://github.com/RazuvaevDD/EPAM) , жмем кнопку Fork 
  3. Вводим в git bash:
  ```
    $ git clone https://github.com/!!!ТВОЙ_ЛОГИН!!!/EPAM
    $ cd EPAM
    $ git remote add upstream https://github.com/RazuvaevDD/EPAM
    $ git fetch upstream
    $ git checkout -b feature
  ```

## 2. Отправка изменений с компьютера на свой репозиторий 
```
  $ git status
  $ git add что там нужно
  $ git commit
  $ git push origin feature
```
## 3. Отправка изменений в основной репозиторий

Необходимо зайти на [страницу проекта](https://github.com/RazuvaevDD/EPAM) и нажать кнопку New pull request

## 4. Следите за главным репозиторием. Если он ушел вперед, то нужно обновить свой репозиторий. 
Для этого выполняем последовательность команд:
```
  $ git checkout master
  $ git pull upstream master
  $ git checkout feature
  $ git merge master
  $ git push origin feature
```
# Описание и указания к работе

1. Версия JRE: JavaSE-11 
2. Обязательно пишем комментарии желательно на английском языке, но не нужно переусердствовать в этом. Достаточно краткого описания к каждой функции и пояснения в некоторых сложных на ваш взгляд местах
3. Стараемся писать по человечески! Нам это еще показывать... (избегайте изобретения велосипедов)
4. Пожалуйста, пишите комментарии к коммитам на нормальном английском языке. (избегайте 20 коммитов c комментарием update main.java)
5. Следите за обработкой исключений!
6. Используем Tab.

Продолжение следует...
