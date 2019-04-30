package models

import com.google.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}
import slick.jdbc.MySQLProfile.api._

case class Publisher (name:String)

case class PublisherFormData(name: String)

object PublisherForm {

  val form = Form(
    mapping(
      "name" -> nonEmptyText
    )(PublisherFormData.apply)(PublisherFormData.unapply)
  )
}



class PublishersTableDef(tag: Tag) extends Table[Publisher](tag, "publisher") {

  def name = column[String]("name",O.PrimaryKey)


  override def * =
    (name) <>(Publisher, Publisher.unapply)
}


class Publishers @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

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
/*
case class Publisher(name: String)

case class PublisherFormData(name: String)

object PublisherForm {

  val form = Form(
    mapping(
      "name" -> nonEmptyText
    )(PublisherFormData.apply)(PublisherFormData.unapply)
  )
}

class PublisherTableDef(tag: Tag) extends Table[Publisher](tag, "publishers") {

  def name = column[String]("name")

  override def * =
    (name) <>(Publisher, Publisher.unapply)
}


class Publishers @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {


  val publishers = TableQuery[PublisherTableDef]

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

}*/