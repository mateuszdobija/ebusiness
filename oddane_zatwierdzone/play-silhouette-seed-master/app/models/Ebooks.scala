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

case class Ebook(id: Int, isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String)

object Ebook {
  implicit val categoryFormat = Json.format[Ebook]
}

class EbooksTableDef(tag: Tag) extends Table[Ebook](tag, "Ebook") {

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
  def ebooks_foreignkey_1 = foreignKey("ebooks_foreignkey_1", author_id, authors)(_.id)
  private val publishers = TableQuery[PublishersTableDef]
  def ebooks_foreignkey_2 = foreignKey("ebooks_foreignkey_2", publisher, publishers)(_.name)
  private val categories = TableQuery[CategoriesTableDef]
  def ebooks_foreignkey_3 = foreignKey("ebooks_foreignkey_3", category, categories)(_.name)

  override def * =

    (id, isbn, title, author_id, price, year, language, pages_number, category, publisher, description) <> ((Ebook.apply _).tupled, Ebook.unapply)
}

case class EbookFormData(isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String)

object EbookForm {
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
    )(EbookFormData.apply)(EbookFormData.unapply)
  )
}

case class delEBookFormData(id: Int)

object delEBookForm {
  val form = Form(
    mapping(
      "id" -> number,
    )(delBookFormData.apply)(delBookFormData.unapply)
  )
}

class Ebooks @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val ebooks = TableQuery[EbooksTableDef]

  def add(ebook: Ebook): Future[String] = {
    dbConfig.db.run(ebooks += ebook).map(res => "Ebook successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Int): Future[Int] = {
    dbConfig.db.run(ebooks.filter(_.id === id).delete)
  }

  def get(id: Int): Future[Option[Ebook]] = {
    dbConfig.db.run(ebooks.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[Ebook]] = {
    dbConfig.db.run(ebooks.result)
  }

}