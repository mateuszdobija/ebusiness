package models.services

import com.google.inject.Inject
import models.{ Purchase, Purchases }

import scala.concurrent.Future

class PurchaseService @Inject() (purchases: Purchases) {

  def add(purchase: Purchase): Future[String] = {
    purchases.add(purchase)
  }

}