Feature: Login

  @Regression
  Scenario: Gecerli kullanici bilgileri ile giris yapilir
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "Test1018*b*s" bilgileri ile sisteme login olunur
    * Open Money Transfer butonuna tiklanir
    * Account Name alaninin "test" oldugu dogrulanir

  @Regression
  Scenario: Gecersiz kullanici bilgileri ile giris yap
    * Uygulama sayfasina gidilir
    * "berker.oguz" ve "123" bilgileri ile sisteme login olunur
    * "Username or Password Invalid!" hata mesajı ekranda gorunmeli