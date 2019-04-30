package controllers


import services.PublisherService
import models.{Publisher, PublisherForm}
import javax.inject.Inject
import play.api.db._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api._


class PublisherController @Inject()(val controllerComponents: ControllerComponents, publisherService: PublisherService) extends BaseController {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    publisherService.listAllUsers map { publishers =>
      Ok(views.html.publisher(PublisherForm.form, publishers))
    }
  }

  def addPublisher() = Action.async { implicit request: Request[AnyContent] =>
    PublisherForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        Logger(s"Form submission with error: ${errorForm.errors}")
        Future.successful(Ok(views.html.publisher(errorForm, Seq.empty[Publisher])))
      },
      data => {
        val newUser = Publisher(data.name)
        publisherService.addPublisher(newUser).map( _ => Redirect(routes.PublisherController.index()))
      })
  }

  def deletePublisher(name: String) = Action.async { implicit request: Request[AnyContent] =>
    publisherService.deletePublisher(name) map { res =>
      Redirect(routes.PublisherController.index())
    }
  }

}