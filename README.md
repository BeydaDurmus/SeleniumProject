# SeleniumProject

- maven
- TESTNG
- POM pattern
- Allure
- Log4j



## Proje Yapısı Hakkında Özet

Projede Selenium kullanarak TESTNG test framework ile geliştirme yaptım. POM pattern sayesinde daha okunabilir otomasyon gerçekleştirdim. Loglama için Log4j ve Allure kullandım.

- DataProvider ile aynı caseleri belirttiğim 2 film içinde kod tekrarı yapmadan test edebildim.
- Web Driver Manager ile kullanmak istediğim drivera erişebildim.
- Regresyon suite yazarak testleri koşabildim.

## Test Cases
| -------------------- | -------------------------------------------------------- |
| ------ | ------ |
| TEST CASE-1 | Ana sayfada Menu üzerinden 'Oscars' sayfasına gidilerek ilgili film bulunur. |
| TEST CASE-2 | Search Box'a istenilen film adı yazılarak 'Sonuç' sayfasından ilgili film bulunur. |
| TEST CASE-3 | 2 ayrı yolla (Menü/SearchBox) aranan filmlerin ilgili dataları karşılaştırılır. |
| TEST CASE-4 | Filmlere ait fotoğraflara gidilerek linkler test edilir.  |

