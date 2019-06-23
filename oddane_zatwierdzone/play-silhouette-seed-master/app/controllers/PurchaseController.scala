package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import javax.inject._
import models.services.PurchaseService
import models.services.OwnUserService
import play.api.libs.json.Json
import play.api.mvc._
import models.{ OwnUser, Purchase, PurchaseForm }
import utils.auth.DefaultEnv
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{ LogoutEvent, Silhouette }

import scala.concurrent.{ ExecutionContext, Future }

class PurchaseController @Inject() (val controllerComponents: ControllerComponents, purchaseService: PurchaseService,
  ownUserService: OwnUserService, silhouette: Silhouette[DefaultEnv])(implicit ec: ExecutionContext) extends BaseController {

  def buyBook() = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    PurchaseForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addPurchase] failed to add purchase")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addBook] add new book")

        ownUserService.getByProvider(request.identity.loginInfo.providerID, request.identity.loginInfo.providerKey)
          .flatMap(elem =>
            {
              elem match {
                case Some(user) => {
                  purchaseService.add(Purchase(0, newBook.id_elem, user.id, "book")).map { _ =>
                    Ok(Json.toJson("{status: \"success\"}"))
                  }
                }

                case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
              }
            })

      }
    )
  }

  def buyEBook() = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    PurchaseForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addPurchase] failed to add purchase")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addEBook] add new ebook")

        ownUserService.getByProvider(request.identity.loginInfo.providerID, request.identity.loginInfo.providerKey)
          .flatMap(elem =>
            {
              elem match {
                case Some(user) => {
                  purchaseService.add(Purchase(0, newBook.id_elem, user.id, "ebook")).map { _ =>
                    Ok(Json.toJson("{status: \"success\"}"))
                  }
                }

                case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
              }
            })

      }

    )
  }

  def buyAudioBook() = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    //Future.successful(Ok(Json.toJson("{todo: napisac}")))

    PurchaseForm.form.bindFromRequest.fold(
      errorForm => {
        println("[addPurchase] failed to add purchase")
        println(errorForm)
        Future.successful(
          Ok(Json.toJson("{status: \"failed\", reason: \"Server error\"}"))
        )
      }, newBook => {
        println("[addAudioBook] add new audiobook")

        ownUserService.getByProvider(request.identity.loginInfo.providerID, request.identity.loginInfo.providerKey)
          .flatMap(elem =>
            {
              elem match {
                case Some(user) => {
                  purchaseService.add(Purchase(0, newBook.id_elem, user.id, "audiobook")).map { _ =>
                    Ok(Json.toJson("{status: \"success\"}"))
                  }
                }

                case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
              }
            })

      }

    )
  }

}