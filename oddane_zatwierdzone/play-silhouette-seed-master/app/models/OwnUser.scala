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

case class OwnUser(id: Int, provider: String, user_key: String)

object OwnUser {
  implicit val categoryFormat = Json.format[OwnUser]
}

class OwnUsersTableDef(tag: Tag) extends Table[OwnUser](tag, "User") {

  def id = column[Int]("id", O.PrimaryKey)
  def provider = column[String]("provider")
  def user_key = column[String]("user_key")

  override def * =
    (id, provider, user_key) <> ((OwnUser.apply _).tupled, OwnUser.unapply)
}

case class OwnUserFormData(provider: String, user_key: String)

object OwnUserForm {
  val form = Form(
    mapping(
      "provider" -> nonEmptyText,
      "user_key" -> nonEmptyText
    )(OwnUserFormData.apply)(OwnUserFormData.unapply)
  )
}

class OwnUsers @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val ownusers = TableQuery[OwnUsersTableDef]

  def add(ownuser: OwnUser): Future[String] = {
    dbConfig.db.run(ownusers += ownuser).map(res => "Own user successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Int): Future[Int] = {
    dbConfig.db.run(ownusers.filter(_.id === id).delete)
  }

  def get(id: Int): Future[Option[OwnUser]] = {
    dbConfig.db.run(ownusers.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[OwnUser]] = {
    dbConfig.db.run(ownusers.result)
  }

  def getByProvider(provider: String, user_key: String): Future[Option[OwnUser]] = {
    dbConfig.db.run(ownusers.filter(_.provider === provider).filter(_.user_key === user_key).result.headOption)
  }

}
