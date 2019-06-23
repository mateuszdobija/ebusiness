package models.services

import com.google.inject.Inject
import models.{ Author, Authors }

import scala.concurrent.Future

class AuthorService @Inject() (authors: Authors) {

  def addAuthor(author: Author): Future[String] = {
    authors.add(author)
  }

  def deleteAuthor(id: Int): Future[Int] = {
    authors.delete(id)
  }
  def getAuthor(id: Int): Future[Option[Author]] = {
    authors.get(id)
  }

  def listAll: Future[Seq[Author]] = {
    authors.listAll
  }
}