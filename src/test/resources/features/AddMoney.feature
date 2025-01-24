Feature: Kredi kartıyla gerekli bilgiler girilerek hesaba para yatırılabilmeli

  Scenario: Dogru kart bilgileri ile para yatırma islemi yapildiginda transactionsda bu islem goruntulenmeli
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "Test1018*b*s" bilgileri ile sisteme login olunur
    * Open Money Transfer butonuna tiklanir
    * Add Money butonuna tiklanir
    * Card Number alanina "1234123412341234" kart numarasi yazilir
    * Card Holder alanina "berker x" texti yazilir
    * Expiry Date alanina "1026" degeri yazilir
    * CVV alanina "110" degeri yazilir
    * Amount olarak "100" degeri girilir
    * Add butonuna tiklanir
    * Transactions ekraninda para yatirma isleminin goruntulendigi dogrulanir