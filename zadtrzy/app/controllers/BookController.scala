package controllers

import javax.inject._
import play.api.mvc._


@Singleton
class BookController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def getById(id:String) = Action {
    Ok("get book by id")
  }

  def getBooks() = Action {
    Ok("get books")
  }

  def addToBasket(id:String) = Action{
    Ok("add book to basket")
  }

  def addToDb(id:String) = Action{
    Ok("add book to db")
  }

  def deleteFromDb(id:String) = Action{
    Ok("delete book from db")
  }

  def addToDb() = Action{
    Ok("add book to db")
  }

  def deleteFromDb() = Action{
    Ok("delete book from db")
  }

  def delFromBasket() = Action{
    Ok("delete book from basket")
  }
}
