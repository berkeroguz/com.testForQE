Feature: Login

  @Test
  Scenario: Gecerli kullanici bilgileri ile giris yapilir
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "Test1018*b*s" bilgileri ile sisteme login olunur
    * Open Money Transfer butonuna tiklanir
    * Account Name alaninin "Berker-Checking" oldugu dogrulanir

  @Test
  Scenario: Gecersiz kullanici bilgileri ile giris yap
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "123" bilgileri ile sisteme login olunur
    * "Username or Password Invalid!" hata mesajı ekranda gorunmeli