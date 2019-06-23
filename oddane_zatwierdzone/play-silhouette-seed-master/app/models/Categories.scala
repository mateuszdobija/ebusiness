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

case class Category(name: String)

object Category {
  implicit val categoryFormat = Json.format[Category]
}

class CategoriesTableDef(tag: Tag) extends Table[Category](tag, "Category") {

  def name = column[String]("name", O.PrimaryKey)

  override def * =
    (name) <> ((Category.apply _), Category.unapply)
}

case class CategoryFormData(name: String)

object CategoryForm {
  val form = Form(
    mapping(
      "name" -> nonEmptyText
    )(CategoryFormData.apply)(CategoryFormData.unapply)
  )
}

class Categories @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val categories = TableQuery[CategoriesTableDef]

  def add(category: Category): Future[String] = {
    dbConfig.db.run(categories += category).map(res => "Category successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def get(name: String): Future[Option[Category]] = {
    dbConfig.db.run(categories.filter(_.name === name).result.headOption)
  }

  def delete(name: String): Future[Int] = {
    dbConfig.db.run(categories.filter(_.name === name).delete)
  }

  def listAll: Future[Seq[Category]] = {
    dbConfig.db.run(categories.result)
  }
}