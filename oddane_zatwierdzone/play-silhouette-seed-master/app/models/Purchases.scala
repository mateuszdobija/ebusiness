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

case class Purchase (id:Int, id_elem:Int, id_user:Int, purchase_type:String)

object Purchase {
  implicit val categoryFormat = Json.format[Purchase]
}
class PurchasesTableDef(tag: Tag) extends Table[Purchase](tag, "Purchase") {
  def id = column[Int]("id",O.PrimaryKey)
  def id_elem = column[Int]("id_elem")
  def id_user = column[Int]("id_user")
  def purchase_type = column[String]("purchase_type")
  override def * =
    (id, id_elem, id_user, purchase_type) <>((Purchase.apply _).tupled, Purchase.unapply)
}
case class PurchaseFormData(id_elem:Int)

object PurchaseForm {
  val form = Form(
    mapping(
      "id_elem" -> number,

    )(PurchaseFormData.apply)(PurchaseFormData.unapply)
  )
}
class Purchases @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
                          (implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {
  val purchases= TableQuery[PurchasesTableDef]

  def add(purchase: Purchase): Future[String] = {
    dbConfig.db.run(purchases += purchase).map(res => "Purchase successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

}
