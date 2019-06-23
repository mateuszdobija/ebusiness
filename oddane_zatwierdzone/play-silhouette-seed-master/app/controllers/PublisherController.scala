package controllers

import javax.inject.Inject
import models.services.PublisherService
import play.api.libs.json.Json
import play.api.mvc._
import models.{ Publisher, PublisherForm }
import scala.concurrent.{ ExecutionContext, Future }

class PublisherController @Inject() (val controllerComponents: ControllerComponents, publisherService: PublisherService)(implicit ec: ExecutionContext) extends BaseController {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    publisherService.listAll map { publishers =>
      Ok("list all publishers")
    }
  }

  def addPublisher() = Action.async { implicit request =>

    PublisherForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addPublisher] failed to add publisher")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addPublisher] add new publisher")

        publisherService.addPublisher(Publisher(newBook.name)).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }

  def getPublishers() = Action.async {
    publisherService.listAll.map { publishers =>
      Ok(Json.toJson(publishers))
    }
  }

  def delete() = Action.async { implicit request =>
    //val id = request.body.asJson.get("id").as[String].toInt
    //bookService.delete(id) map { res =>
    //  Ok(Json.toJson(res))
    // }
    PublisherForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")

        publisherService.deletePublisher(newBook.name).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }
}