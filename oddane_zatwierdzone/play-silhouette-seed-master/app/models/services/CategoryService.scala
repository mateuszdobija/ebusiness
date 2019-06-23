package models.services

import com.google.inject.Inject
import models.{ Categories, Category }

import scala.concurrent.Future

class CategoryService @Inject() (categories: Categories) {

  def addCategory(category: Category): Future[String] = {
    categories.add(category)
  }

  def getCategory(name: String): Future[Option[Category]] = {
    categories.get(name)
  }
  def listAll: Future[Seq[Category]] = {
    categories.listAll
  }
  def delete(name: String): Future[Int] = {
    categories.delete(name)
  }
}