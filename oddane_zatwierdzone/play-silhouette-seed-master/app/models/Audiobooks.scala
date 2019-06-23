package models

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.Forms.mapping
import play.api.libs.json.Json
import play.api.data.format.Formats._

import com.google.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms._
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.jdbc.JdbcProfile
import scala.concurrent.{ ExecutionContext, Future }
import slick.jdbc.MySQLProfile.api._

case class Audiobook(id: Int, isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String)

object Audiobook {
  implicit val categoryFormat = Json.format[Audiobook]
}

class AudiobooksTableDef(tag: Tag) extends Table[Audiobook](tag, "Audiobook") {

  def id = column[Int]("id", O.PrimaryKey)
  def isbn = column[String]("isbn")
  def title = column[String]("title")
  def author_id = column[Int]("author_id")
  def price = column[Float]("price")
  def year = column[Int]("year")
  def language = column[String]("language")
  def pages_number = column[Int]("pages_number")
  def category = column[String]("category")
  def publisher = column[String]("publisher")
  def description = column[String]("description")

  private val authors = TableQuery[AuthorsTableDef]
  def audiobooks_foreignkey_1 = foreignKey("audiobooks_foreignkey_1", author_id, authors)(_.id)
  private val publishers = TableQuery[PublishersTableDef]
  def audiobooks_foreignkey_2 = foreignKey("audiobooks_foreignkey_2", publisher, publishers)(_.name)
  private val categories = TableQuery[CategoriesTableDef]
  def audiobooks_foreignkey_3 = foreignKey("audiobooks_foreignkey_3", category, categories)(_.name)

  override def * =
    (id, isbn, title, author_id, price, year, language, pages_number, category, publisher, description) <> ((Audiobook.apply _).tupled, Audiobook.unapply)
}

case class AudiobookFormData(isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String)

object AudiobookForm {
  val form = Form(
    mapping(
      "isbn" -> nonEmptyText,
      "title" -> nonEmptyText,
      "author_id" -> number,
      "price" -> of(floatFormat),
      "year" -> number,
      "language" -> nonEmptyText,
      "pages_number" -> number,
      "category" -> nonEmptyText,
      "publisher" -> nonEmptyText,
      "description" -> nonEmptyText
    )(AudiobookFormData.apply)(AudiobookFormData.unapply)
  )
}

case class delAudioBookFormData(id: Int)

object delAudioBookForm {
  val form = Form(
    mapping(
      "id" -> number,
    )(delBookFormData.apply)(delBookFormData.unapply)
  )
}


class Audiobooks @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val audiobooks = TableQuery[AudiobooksTableDef]

  def add(audiobook: Audiobook): Future[String] = {
    dbConfig.db.run(audiobooks += audiobook).map(res => "Audiobook successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Int): Future[Int] = {
    dbConfig.db.run(audiobooks.filter(_.id === id).delete)
  }

  def get(id: Int): Future[Option[Audiobook]] = {
    dbConfig.db.run(audiobooks.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[Audiobook]] = {
    dbConfig.db.run(audiobooks.result)
  }

}