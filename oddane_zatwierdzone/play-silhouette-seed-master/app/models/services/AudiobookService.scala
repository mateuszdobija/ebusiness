package models.services

import com.google.inject.Inject
import models.{ Audiobook, Audiobooks }

import scala.concurrent.Future

class AudiobookService @Inject() (audiobooks: Audiobooks) {

  def add(audiobook: Audiobook): Future[String] = {
    audiobooks.add(audiobook)
  }

  def delete(id: Int): Future[Int] = {
    audiobooks.delete(id)
  }

  def get(id: Int): Future[Option[Audiobook]] = {
    audiobooks.get(id)
  }

  def listAll: Future[Seq[Audiobook]] = {
    audiobooks.listAll
  }
}