package models.services

import com.google.inject.Inject
import models.{ Ebook, Ebooks }

import scala.concurrent.Future

class EBookService @Inject() (ebooks: Ebooks) {

  def add(ebook: Ebook): Future[String] = {
    ebooks.add(ebook)
  }

  def delete(id: Int): Future[Int] = {
    ebooks.delete(id)
  }

  def get(id: Int): Future[Option[Ebook]] = {
    ebooks.get(id)
  }

  def listAll: Future[Seq[Ebook]] = {
    ebooks.listAll
  }
}