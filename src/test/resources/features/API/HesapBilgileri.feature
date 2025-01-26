Feature: Hesap bilgilerinin getirilmesi


  @Test
  Scenario: GET /api/v1/banking/users/accounts endpointine istek atilarak userin hesaplari listelenmeli
    * Endpointin path parametresini olarak "/api/v1/banking/users/accounts" ayarla
    * "GET" method ile response kaydet
    * Statu kod "200" oldugunu dogrula

  @Test
  Scenario: POST istegi ile para transferi gerceklestirilebilmeli
    * Endpointin path parametresini olarak "/api/v1/banking/transactions/transfer" ayarla
    * Sender accountId olarak "3f53daa5-b607-4ec5-b97d-7e14fb402762" id kullan
    * Receiver accountId olarak "e78c9654-b50c-40fa-855b-57efd076c596" id kullan
    * Amount olarak "100" degerini kullan
    * ClientId olarak "web" degerini kullan
    * "POST" method ile response kaydet
    * Statu kod "200" oldugunu dogrula