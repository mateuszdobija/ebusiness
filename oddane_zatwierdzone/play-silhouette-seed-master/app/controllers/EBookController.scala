package controllers

import javax.inject._

import play.api.libs.json.Json
import play.api.mvc._
import models.services.EBookService
import models.{ Ebook, EbookForm }
import models.{ delEBookForm }
//import scala.concurrent.ExecutionContext
import scala.concurrent.{ ExecutionContext, Future }

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class EBookController @Inject() (cc: ControllerComponents, ebookService: EBookService)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("Your new application is ready.")
  }

  def getById(id: Int) = Action {
    Ok("get ebook by id")
  }

  def getBooks() = Action.async {
    ebookService.listAll.map { audiobooks =>
      Ok(Json.toJson(audiobooks))
    }
  }

  def addToBasket(id: Int) = Action {
    Ok("add ebook to basket")
  }

  def delFromBasket(id: Int) = Action {
    Ok("del from basket")
  }

  def addToDbById(id: Int) = Action {
    Ok("add ebook to db")
  }

  def deleteFromDbById(id: Int) = Action {
    Ok("delete ebook from db")
  }

  def addToDb() = Action {
    Ok("add ebook to db")
  }

  def deleteFromDb() = Action {
    Ok("delete eebook from db")
  }

  def addBook() = Action.async { implicit request =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    EbookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addEBook] failed to add ebook")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addEBook] add new ebook")

        ebookService.add(Ebook(0, newBook.isbn, newBook.title, newBook.author_id, newBook.price,
          newBook.year, newBook.language, newBook.pages_number, newBook.category, newBook.publisher,
          newBook.description)).map { _ =>
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
    delEBookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")
        ebookService.delete(newBook.id).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }
}
