package models.services

import com.google.inject.Inject
import models.{ Publisher, Publishers }

import scala.concurrent.Future

class PublisherService @Inject() (publishers: Publishers) {

  def addPublisher(publisher: Publisher): Future[String] = {
    publishers.add(publisher)
  }

  def deletePublisher(name: String): Future[Int] = {
    publishers.delete(name)
  }

  def getPublisher(name: String): Future[Option[Publisher]] = {
    publishers.get(name)
  }

  def listAll: Future[Seq[Publisher]] = {
    publishers.listAll
  }
}