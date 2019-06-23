package models.services

import com.google.inject.Inject
import models.{ Audiobook, Audiobooks, OwnUser, OwnUsers }

import scala.concurrent.Future

class OwnUserService @Inject() (ownusers: OwnUsers) {

  def add(ownuser: OwnUser): Future[String] = {
    ownusers.add(ownuser)
  }

  def delete(id: Int): Future[Int] = {
    ownusers.delete(id)
  }

  def get(id: Int): Future[Option[OwnUser]] = {
    ownusers.get(id)
  }

  def listAll: Future[Seq[OwnUser]] = {
    ownusers.listAll
  }

  def getByProvider(provider: String, user_key: String): Future[Option[OwnUser]] = {
    ownusers.getByProvider(provider, user_key)
  }

}