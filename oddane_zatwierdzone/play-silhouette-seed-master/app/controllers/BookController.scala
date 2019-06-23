package controllers

import javax.inject._
import models.services.BookService
import models.{ Book, BookForm }
import models.{ delBookForm }

import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ ExecutionContext, Future }

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class BookController @Inject() (cc: ControllerComponents, bookService: BookService)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def getById(id: Int) = Action {
    Ok("get book by id")
  }

  def getBooks() = Action.async {
    bookService.listAll.map { books =>
      Ok(Json.toJson(books))
    }
  }

  def addToBasket(id: Int) = Action {
    Ok("add book to basket")
  }

  def delFromBasket(id: Int) = Action {
    Ok("delete book from basket")
  }

  def addToDbById(id: Int) = Action {
    Ok("add book to db")
  }

  def deleteFromDbById(id: Int) = Action {
    Ok("delete book from db")
  }

  //def addToDb() = Action{
  //  Ok("add book to db")
  //}

  def deleteFromDb() = Action {
    Ok("delete book from db")
  }

  def addBook() = Action.async { implicit request =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    BookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")

        bookService.add(Book(0, newBook.isbn, newBook.title, newBook.author_id, newBook.price,
          newBook.year, newBook.language, newBook.pages_number, newBook.category, newBook.publisher,
          newBook.description, newBook.quantity)).map { _ =>
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
    delBookForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addBook] failed to add book")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")

        bookService.delete(newBook.id).map { _ =>
          Ok(Json.toJson("{status: \"success\"}"))
        }

      }

    )
  }
}