Feature: Transfer Money Islemlerinin Yapilmasi

  Scenario: Pozitif bir tam sayi ile transfer islemi gerceklestirildiginde transactionsda bu islem goruntulenmeli
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "Test1018*b*s" bilgileri ile sisteme login olunur
    * Open Money Transfer butonuna tiklanir
    * Transfer Money Butonuna tiklanir
    * Receiver account olarak "Testinium-3" secilir
    * Amount olarak "100" degeri girilir
    * Send butonuna tiklanir
    * Transactions ekraninda yapilan islemin goruntulendigi dogrulanir
