package controllers

import javax.inject._
import models.services.AudiobookService
import play.api.libs.json.Json
import play.api.mvc._
import models.{ Audiobook, AudiobookForm }
import models.{ delAudioBookForm }
//import scala.concurrent.ExecutionContext
import scala.concurrent.{ ExecutionContext, Future }
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class AudioBookController @Inject() (cc: ControllerComponents, audiobookService: AudiobookService)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {

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
    Ok("get audiobook by id")
  }

  def getBooks() = Action.async {
    audiobookService.listAll.map { audiobooks =>
      Ok(Json.toJson(audiobooks))
    }
  }

  def addToBasket(id: Int) = Action {
    Ok("add audiobook to basket")
  }

  def delFromBasket(id: Int) = Action {
    Ok("delete audiobook from basket")
  }

  def addToDbById(id: Int) = Action {
    Ok("add audiobook to db")
  }

  def deleteFromDbById(id: Int) = Action {
    Ok("delete audiobook from db")
  }

  def addToDb() = Action {
    Ok("add audiobook to db")
  }

  def deleteFromDb() = Action {
    Ok("delete audiobook from db")
  }
  def addBook() = Action.async { implicit request =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    AudiobookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addAudioBook] failed to add audiobook")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addAudioBook] add new audiobook")

        audiobookService.add(Audiobook(0, newBook.isbn, newBook.title, newBook.author_id, newBook.price,
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
    delAudioBookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")
        audiobookService.delete(newBook.id).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }
}