package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class BookController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  def getById(id:String) = Action {
    Ok("get book by id")
  }

  def getBooks() = Action {
    Ok("get books")
  }

  def addToBasket(id:String) = Action{
    Ok("add book to basket")
  }

  def delFromBasket(id:String) = Action{
    Ok("delete book from basket")
  }

  def addToDbById(id:String) = Action{
    Ok("add book to db")
  }

  def deleteFromDbById(id:String) = Action{
    Ok("delete book from db")
  }

  def addToDb() = Action{
    Ok("add book to db")
  }

  def deleteFromDb() = Action{
    Ok("delete book from db")
  }


}