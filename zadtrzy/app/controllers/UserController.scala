package controllers

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def login() = Action {
    Ok("login")
  }

  def login(id:String, haslo:String ) = Action {
    Ok("login")
  }

  def register() = Action {
    Ok("register")
  }

  def register(id:String, haslo:String ) = Action {
    Ok("register")
  }

  def buy() = Action {
    Ok("buy")
  }
  def edit() = Action{
    Ok("edit")
  }

  def edit(arg:String) = Action{
    Ok("edit")
  }
}
