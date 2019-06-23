package models.services

import com.google.inject.Inject
import models.{ Book, Books }

import scala.concurrent.Future

class BookService @Inject() (books: Books) {

  def add(book: Book): Future[String] = {
    books.add(book)
  }

  def delete(id: Int): Future[Int] = {
    books.delete(id)
  }

  def get(id: Int): Future[Option[Book]] = {
    books.get(id)
  }

  def listAll: Future[Seq[Book]] = {
    books.listAll
  }
}