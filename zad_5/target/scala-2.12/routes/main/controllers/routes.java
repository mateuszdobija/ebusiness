// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mateusz/ebiznes/zad_5/conf/routes
// @DATE:Thu Jun 13 00:31:33 CEST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBookController BookController = new controllers.ReverseBookController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAudioBookController AudioBookController = new controllers.ReverseAudioBookController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCountController CountController = new controllers.ReverseCountController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAsyncController AsyncController = new controllers.ReverseAsyncController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseEBookController EBookController = new controllers.ReverseEBookController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePublisherController PublisherController = new controllers.ReversePublisherController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBookController BookController = new controllers.javascript.ReverseBookController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAudioBookController AudioBookController = new controllers.javascript.ReverseAudioBookController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCountController CountController = new controllers.javascript.ReverseCountController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAsyncController AsyncController = new controllers.javascript.ReverseAsyncController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseEBookController EBookController = new controllers.javascript.ReverseEBookController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePublisherController PublisherController = new controllers.javascript.ReversePublisherController(RoutesPrefix.byNamePrefix());
  }

}
