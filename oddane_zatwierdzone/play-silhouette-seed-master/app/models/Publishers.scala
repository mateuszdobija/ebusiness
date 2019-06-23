package models

import com.google.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms._
import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import play.api.libs.json.Json
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }
import slick.jdbc.MySQLProfile.api._

case class Publisher(name: String)

object Publisher {
  implicit val categoryFormat = Json.format[Publisher]
}

class PublishersTableDef(tag: Tag) extends Table[Publisher](tag, "Publisher") {

  def name = column[String]("name", O.PrimaryKey)

  override def * =
    (name) <> (Publisher.apply, Publisher.unapply)
}

case class PublisherFormData(name: String)

object PublisherForm {
  val form = Form(
    mapping(
      "name" -> nonEmptyText
    )(PublisherFormData.apply)(PublisherFormData.unapply)
  )
}

class Publishers @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val publishers = TableQuery[PublishersTableDef]

  def add(publisher: Publisher): Future[String] = {
    dbConfig.db.run(publishers += publisher).map(res => "Publisher successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(name: String): Future[Int] = {
    dbConfig.db.run(publishers.filter(_.name === name).delete)
  }

  def get(name: String): Future[Option[Publisher]] = {
    dbConfig.db.run(publishers.filter(_.name === name).result.headOption)
  }

  def listAll: Future[Seq[Publisher]] = {
    dbConfig.db.run(publishers.result)
  }

}
