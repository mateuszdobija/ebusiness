package controllers

import javax.inject._
import models.services.CategoryService
import play.api.libs.json.Json
import play.api.mvc._
import models.{ Category, CategoryForm }
import scala.concurrent.{ ExecutionContext, Future }

class CategoryController @Inject() (val controllerComponents: ControllerComponents, categoryService: CategoryService)(implicit ec: ExecutionContext) extends BaseController {

  //def index() = Action.async { implicit request: Request[AnyContent] =>
  //  categoryService.listAll map { categories =>
  //    Ok("list all categories")
  //  }
  //  }

  //def addCategory(name: String) = Action { implicit request: Request[AnyContent] =>
  //  Ok("add category")
  //}
  def addCategory() = Action.async { implicit request =>

    CategoryForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addAudioBook] failed to add category")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addAudioBook] add new audiobook")

        categoryService.addCategory(Category(newBook.name)).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }
  def delete() = Action.async { implicit request =>
    //val id = request.body.asJson.get("id").as[String].toInt
    //bookService.delete(id) map { res =>
    //  Ok(Json.toJson(res))
    // }
    CategoryForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")

        categoryService.delete(newBook.name).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }

  def getCategories() = Action.async {
    categoryService.listAll.map { categories =>
      Ok(Json.toJson(categories))
    }
  }
}