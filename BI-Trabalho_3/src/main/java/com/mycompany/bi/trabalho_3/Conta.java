/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bi.trabalho_3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Augusto
 */
public class Conta {
    String IDConta;
    LocalDateTime creationDate;
    int NoOfDaysSinceLastPurchase;
    int NoOfDealsWithDiscount;
    int NoOfWebPurchase;
    int NoOfCatalogPurchase;
    int NoOfStorePurchase;
    int NoOfWebVisitsMonth;
    int TotalNoOfCampaignAccepted;
    int CustomerComplain;

  public Conta(String IDConta, LocalDateTime activeSinceDays, int NoOfDaysSinceLastPurchase, int NoOfDealsWithDiscount, int NoOfWebPurchase, int NoOfCatalogPurchase, int NoOfStorePurchase, int NoOfWebVisitsMonth, int TotalNoOfCampaignAccepted, int CustomerComplain) {
    this.IDConta = IDConta;
    this.creationDate = activeSinceDays;
    this.NoOfDaysSinceLastPurchase = NoOfDaysSinceLastPurchase;
    this.NoOfDealsWithDiscount = NoOfDealsWithDiscount;
    this.NoOfWebPurchase = NoOfWebPurchase;
    this.NoOfCatalogPurchase = NoOfCatalogPurchase;
    this.NoOfStorePurchase = NoOfStorePurchase;
    this.NoOfWebVisitsMonth = NoOfWebVisitsMonth;
    this.TotalNoOfCampaignAccepted = TotalNoOfCampaignAccepted;
    this.CustomerComplain = CustomerComplain;
  }
  
  
  public static Conta contaExemplo(){
      return new Conta("123", LocalDateTime.parse("2017-07-15T00:00:00"), 49, 2, 4, 3, 6, 5, 0, 0);
  }
}
