package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class EBookController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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
    Ok("get ebook by id")
  }

  def getBooks() = Action {
    Ok("get ebooks")
  }

  def addToBasket(id:String) = Action{
    Ok("add ebook to basket")
  }

  def addToDb(id:String) = Action{
    Ok("add ebook to db")
  }

  def deleteFromDb(id:String) = Action{
    Ok("delete ebook from db")
  }

  def addToDb() = Action{
    Ok("add ebook to db")
  }

  def deleteFromDb() = Action{
    Ok("delete eebook from db")
  }

  def delFromBasket() = Action{
    Ok("del from basket")
  }
}
