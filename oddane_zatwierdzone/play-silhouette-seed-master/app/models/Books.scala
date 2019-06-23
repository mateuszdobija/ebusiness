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

case class Book(id: Int, isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String, quantity: Int)

object Book {
  implicit val categoryFormat = Json.format[Book]
}

class BooksTableDef(tag: Tag) extends Table[Book](tag, "Book") {

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
  def quantity = column[Int]("quantity")

  private val authors = TableQuery[AuthorsTableDef]
  def books_foreignkey_1 = foreignKey("books_foreignkey_1", author_id, authors)(_.id)
  private val publishers = TableQuery[PublishersTableDef]
  def books_foreignkey_2 = foreignKey("books_foreignkey_2", publisher, publishers)(_.name)
  private val categories = TableQuery[CategoriesTableDef]
  def books_foreignkey_3 = foreignKey("books_foreignkey_3", category, categories)(_.name)

  override def * =
    (id, isbn, title, author_id, price, year, language, pages_number, category, publisher, description, quantity) <> ((Book.apply _).tupled, Book.unapply)
}

case class BookFormData(isbn: String, title: String, author_id: Int, price: Float, year: Int, language: String, pages_number: Int, category: String, publisher: String, description: String, quantity: Int)


object BookForm {
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
      "description" -> nonEmptyText,
      "quantity" -> number
    )(BookFormData.apply)(BookFormData.unapply)
  )
}

case class delBookFormData(id: Int)

object delBookForm {
  val form = Form(
    mapping(
      "id" -> number,
    )(delBookFormData.apply)(delBookFormData.unapply)
  )
}

class Books @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val books = TableQuery[BooksTableDef]

  def add(book: Book): Future[String] = {
    dbConfig.db.run(books += book).map(res => "Book successfully added").recover {
      case ex: Exception => {
        //println(ex.detailMessage)
        ex.getCause.getMessage
      }
    }
  }

  def delete(id: Int): Future[Int] = {
    dbConfig.db.run(books.filter(_.id === id).delete)
  }

  def get(id: Int): Future[Option[Book]] = {
    dbConfig.db.run(books.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[Book]] = {
    dbConfig.db.run(books.result)
  }

}