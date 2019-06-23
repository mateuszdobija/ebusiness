package controllers

import javax.inject.Inject
import models.services.AuthorService
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext

class AuthorController @Inject() (val controllerComponents: ControllerComponents, authorService: AuthorService)(implicit ec: ExecutionContext) extends BaseController {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    authorService.listAll map { publishers =>
      Ok("list all authors")
    }
  }

  def addAuthor(name: String) = Action { implicit request: Request[AnyContent] =>
    Ok("add author")
  }

  def deleteAuthor(id: Int) = Action.async { implicit request: Request[AnyContent] =>
    authorService.deleteAuthor(id) map { res =>
      Ok(Json.toJson(res))
    }
  }

  def getAuthors() = Action.async {
    authorService.listAll.map { authors =>
      Ok(Json.toJson(authors))
    }
  }
}