## Валидатор данных:
### При помощи App можно указать требования к данным и проверить эти данные на валидность
Реализована возможность проверять __строки__ по валидаторам:
- __required__ – любая непустая строка
- __minLength__ – строка равна или длиннее указанного числа
- __contains__ – строка содержит определённую подстроку

Реализована возможность проверять __числа__ по валидаторам:

- __required__ – любое число включая ноль
- __positive__ – положительное число
- __range__ – диапазон, в который должны попадать числа включая границы

Реализована возможность проверять объекты __Map__ по валидаторам:

- __required__ – требуется тип данных Map
- __sizeof__ – количество пар ключ-значений в объекте Map должно быть равно заданному

Реализована возможность проверки значений объекта __Map__ .

### Hexlet tests and linter status:
[![Actions Status](https://github.com/KrylovMikhail1985/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/KrylovMikhail1985/java-project-lvl3/actions)
[![GitHub Actions](https://github.com/KrylovMikhail1985/java-project-lvl3/actions/workflows/github-actions.yml/badge.svg)](https://github.com/KrylovMikhail1985/java-project-lvl3/actions/workflows/github-actions.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/34fb87f9a834221c73ed/maintainability)](https://codeclimate.com/github/KrylovMikhail1985/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/34fb87f9a834221c73ed/test_coverage)](https://codeclimate.com/github/KrylovMikhail1985/java-project-lvl3/test_coverage)