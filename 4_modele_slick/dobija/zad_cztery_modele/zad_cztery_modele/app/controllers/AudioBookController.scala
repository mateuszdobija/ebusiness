package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class AudioBookController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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
    Ok("get audiobook by id")
  }

  def getBooks() = Action {
    Ok("get audiobooks")
  }

  def addToBasket(id:String) = Action{
    Ok("add audiobook to basket")
  }

  def delFromBasket(id:String) = Action{
    Ok("delete audiobook from basket")
  }

  def addToDbById(id:String) = Action{
    Ok("add audiobook to db")
  }

  def deleteFromDbById(id:String) = Action{
    Ok("delete audiobook from db")
  }

  def addToDb() = Action{
    Ok("add audiobook to db")
  }

  def deleteFromDb() = Action{
    Ok("delete audiobook from db")
  }


}