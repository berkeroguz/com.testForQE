
# Money Transfer Uygulaması

Bu uygulama üzerinde UI ve API testleri yer almaktadır. Manuel senaryolar arasından sadece Prod'a çıkabilecek olan senaryolar örnek olarak eklenmiştir. Yoksa ürünün prod'a çıkmaması gerekir. Detaylı değerlendirme raporda mevcuttur.

Proje üzerinde kullanılan teknolojiler
---
- Java, Maven
- Selenium
- RestAssured
- Docker
- Cucumber, TestNG
- Selenoid


Sistem Gereksinimleri
---
- Java 17 veya üzeri version
- Maven Apache 3.9.6 veya üzeri version
- Docker Engine (Parallel olarak container üzerinde test için)
- Kullanılmak istenen tarayıcılar


Proje Özellikleri
--
* Projede Singleton Tasarım Deseni ve Factory Desing kullanılaran SOLID prensiplerine uyulmaya çalışılmıştır. 
* BDD ruhunu tam olarak yansıtabilmek adına özellikle feature dosyalarına çok fazla parametreden kaçınılmış olup, stepler tam olarak son kullanıcının ağzından çıkacak şekilde yazılmıştır.
* Bunun yanı sıra Page, locator ve method package'larından beslenen step class'ları, tester için feature'ı besleyecek özgür bir ortam olacak şekilde tasarlanmıştır.
* Proje Web ve API otomasyonu beraber çalışabilecek şekilde tasarlanmıştır.
* Senaryolar paralel olarak çalıştırılabilmektedir.
* Cucumber report ile raporlama sunmaktadır. ( Allure report istenirse eklenebilir)
* Screenshoot ve video kaydı alabilmektedir. (Video kaydı özelliği container üzerinde kullanılmaktadır.)
* Rerun özelliği ile fail olan senaryolar tekrar koşulabilmektedir.
* Selenoid ile beraber tüm test senaryoları izole bir şekilde docker container'lar üzerinde istenilen tarayıcı üzerinde koşarak raporlama sunabilmektedir.

Nasıl Çalışır?
--

- Öncelikle proje dizine çekildikten sonra
 "mvn clean verify -DskipTest"  komutu ile proje build edilir.

- UI Testler için UI sınıfı, API testleri için API runner sınıfları çalıştırılmalıdır.

Örnek:
-
mvn test -Dtest=Runner -Dbrowser=chrome komutu ile UI testler tek tek çalıştırılabilir.

Parallel çalıştırma için:
-
mvn test -Dtest=ParallelRunner -Dbrowser=chrome -Ddataproviderthreadcount=3

komutu ile UI testler parallel olarak çalıştırılabilir.

Parallel olarak docker üzerinde selenoid ile çalıştırma
--
Not: Docker çoğu zaman kendisi image'ları indiriyor ancak indirmediği takdirde compose dosyası üzerindeki imageları indirmeniz gerekebilir. "docker pull imageIsmi" şeklinde gerekli imajları terminal üzerinden indirebilirsiniz.
browser.json dosyası üzerinden istenilen browser'lar eklenebilir. Bkz : https://aerokube.com/selenoid/latest/#_browser_images

Öncelikle docker engine açık olduğundan emin olun.

Step1 : "docker-compose up -d" komutu ile selenoid ortamı ayağa kalkar.

Step2 : "mvn test -Dtest=ParallelRunner -Dbrowser=remote -Ddataproviderthreadcount=3
komutu ile testler çalıştırılır.


dilerseniz bu noktada http://localhost:8080 üzerinde selenoid'in arayüzünden testlerini takip edebilirsiniz.


Step3 : Testler bittiğinde dilerseniz target/report altında raporu görüntüleyebilirsiniz. Videos klasörü altında senaryoların videolarını görüntüleyebilirsiniz. (Şu anda tüm senaryoları kaydedecek şekilde ayarlanmıştır ancak istenirse sadece fail olan senaryoların video kaydı çekilebilmektedir.) Yeni çalıştırma için de aynı komutu kullanabilirsiniz.


Step4 : docker-compose down komutu ile selenoid ortamını kapatın.



Son
-
Ek olarak Assertion methodları farklı bir classta toplanarak step classları daha temiz hale getirilebilir. Selenium methodları sistem kullanıldıkça daha temiz ve sade hale getirilerek farklı class'lara alınabilir. Örneğin ActionClass vb.


Kaynaklar
--
https://cucumber.io/docs/cucumber/

https://mvnrepository.com/

https://www.selenium.dev/documentation/

https://aerokube.com/selenoid/latest/

https://stackoverflow.com/





