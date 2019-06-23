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
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}
import slick.jdbc.MySQLProfile.api._

case class Author (id:Int, name:String, surname:String, nacionality:String, birth_date:String)

object Author {
  implicit val categoryFormat = Json.format[Author]
}

class AuthorsTableDef(tag: Tag) extends Table[Author](tag, "Author") {

  def id = column[Int]("id",O.PrimaryKey)
  def name = column[String]("name")
  def surname = column[String]("surname")
  def nacionality = column[String]("nacionality")
  def birth_date = column[String]("birth_date")

  override def * =
    (id, name, surname, nacionality,birth_date) <>((Author.apply _).tupled, Author.unapply)
}

case class AuthorFormData(name:String, surname:String, nacionality:String, birth_date:String)

object AuthorForm {
  val form = Form(
    mapping(
      "name" -> nonEmptyText,
      "surname" ->nonEmptyText,
      "nacionality" -> nonEmptyText,
      "birth_date" -> nonEmptyText,
    )(AuthorFormData.apply)(AuthorFormData.unapply)
  )
}

class Authors @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
                      (implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val authors= TableQuery[AuthorsTableDef]


  def add(author: Author): Future[String] = {
    dbConfig.db.run(authors += author).map(res => "Author successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(id: Int): Future[Option[Author]] = {
    dbConfig.db.run(authors.filter(_.id === id).result.headOption)
  }

  def delete(id: Int): Future[Int] = {
    dbConfig.db.run(authors.filter(_.id === id).delete)
  }

  def listAll: Future[Seq[Author]] = {
    dbConfig.db.run(authors.result)
  }
}