// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mateusz/ebiznes/zad_5/conf/routes
// @DATE:Thu Jun 13 00:31:33 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_8: controllers.HomeController,
  // @LINE:9
  CountController_2: controllers.CountController,
  // @LINE:11
  AsyncController_7: controllers.AsyncController,
  // @LINE:14
  Assets_6: controllers.Assets,
  // @LINE:16
  BookController_4: controllers.BookController,
  // @LINE:17
  EBookController_3: controllers.EBookController,
  // @LINE:18
  AudioBookController_1: controllers.AudioBookController,
  // @LINE:50
  UserController_5: controllers.UserController,
  // @LINE:56
  PublisherController_0: controllers.PublisherController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_8: controllers.HomeController,
    // @LINE:9
    CountController_2: controllers.CountController,
    // @LINE:11
    AsyncController_7: controllers.AsyncController,
    // @LINE:14
    Assets_6: controllers.Assets,
    // @LINE:16
    BookController_4: controllers.BookController,
    // @LINE:17
    EBookController_3: controllers.EBookController,
    // @LINE:18
    AudioBookController_1: controllers.AudioBookController,
    // @LINE:50
    UserController_5: controllers.UserController,
    // @LINE:56
    PublisherController_0: controllers.PublisherController
  ) = this(errorHandler, HomeController_8, CountController_2, AsyncController_7, Assets_6, BookController_4, EBookController_3, AudioBookController_1, UserController_5, PublisherController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_8, CountController_2, AsyncController_7, Assets_6, BookController_4, EBookController_3, AudioBookController_1, UserController_5, PublisherController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/""" + "$" + """id<[^/]+>""", """controllers.BookController.getById(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ebooks/""" + "$" + """id<[^/]+>""", """controllers.EBookController.getById(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """audiobook/""" + "$" + """id<[^/]+>""", """controllers.AudioBookController.getById(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.BookController.getBooks"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ebooks""", """controllers.EBookController.getBooks"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """audiobooks""", """controllers.AudioBookController.getBooks"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """booksToDb/""" + "$" + """id<[^/]+>""", """controllers.BookController.addToDbById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ebooksToDb/""" + "$" + """id<[^/]+>""", """controllers.EBookController.addToDbById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """audiobookToDb/""" + "$" + """id<[^/]+>""", """controllers.AudioBookController.addToDbById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """booksdelfromdb/""" + "$" + """id<[^/]+>""", """controllers.BookController.deleteFromDbById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ebooksdelfromdb/""" + "$" + """id<[^/]+>""", """controllers.EBookController.deleteFromDbById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """audiobookdelfromdb/""" + "$" + """id<[^/]+>""", """controllers.AudioBookController.deleteFromDbById(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login/""" + "$" + """id<[^/]+>/""" + "$" + """haslo<[^/]+>""", """controllers.UserController.loginById(id:String, haslo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register/""" + "$" + """id<[^/]+>/""" + "$" + """haslo<[^/]+>""", """controllers.UserController.registerById(id:String, haslo:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addPublisher""", """controllers.PublisherController.addPublisher(name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delPublisher""", """controllers.PublisherController.deletePublisher(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """publishers""", """controllers.PublisherController.getPublishers"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addBook""", """controllers.BookController.addBook()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_8.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_2.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_7.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_6.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_BookController_getById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BookController_getById4_invoker = createInvoker(
    BookController_4.getById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "getById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """books/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_EBookController_getById5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ebooks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EBookController_getById5_invoker = createInvoker(
    EBookController_3.getById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EBookController",
      "getById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """ebooks/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_AudioBookController_getById6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("audiobook/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AudioBookController_getById6_invoker = createInvoker(
    AudioBookController_1.getById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AudioBookController",
      "getById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """audiobook/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_BookController_getBooks7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_BookController_getBooks7_invoker = createInvoker(
    BookController_4.getBooks,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "getBooks",
      Nil,
      "GET",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_EBookController_getBooks8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ebooks")))
  )
  private[this] lazy val controllers_EBookController_getBooks8_invoker = createInvoker(
    EBookController_3.getBooks,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EBookController",
      "getBooks",
      Nil,
      "GET",
      this.prefix + """ebooks""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_AudioBookController_getBooks9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("audiobooks")))
  )
  private[this] lazy val controllers_AudioBookController_getBooks9_invoker = createInvoker(
    AudioBookController_1.getBooks,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AudioBookController",
      "getBooks",
      Nil,
      "GET",
      this.prefix + """audiobooks""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_BookController_addToDbById10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("booksToDb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BookController_addToDbById10_invoker = createInvoker(
    BookController_4.addToDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "addToDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """booksToDb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_EBookController_addToDbById11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ebooksToDb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EBookController_addToDbById11_invoker = createInvoker(
    EBookController_3.addToDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EBookController",
      "addToDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """ebooksToDb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_AudioBookController_addToDbById12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("audiobookToDb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AudioBookController_addToDbById12_invoker = createInvoker(
    AudioBookController_1.addToDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AudioBookController",
      "addToDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """audiobookToDb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_BookController_deleteFromDbById13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("booksdelfromdb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BookController_deleteFromDbById13_invoker = createInvoker(
    BookController_4.deleteFromDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "deleteFromDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """booksdelfromdb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_EBookController_deleteFromDbById14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ebooksdelfromdb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EBookController_deleteFromDbById14_invoker = createInvoker(
    EBookController_3.deleteFromDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EBookController",
      "deleteFromDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """ebooksdelfromdb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_AudioBookController_deleteFromDbById15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("audiobookdelfromdb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AudioBookController_deleteFromDbById15_invoker = createInvoker(
    AudioBookController_1.deleteFromDbById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AudioBookController",
      "deleteFromDbById",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """audiobookdelfromdb/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_UserController_loginById16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("haslo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_loginById16_invoker = createInvoker(
    UserController_5.loginById(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "loginById",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """login/""" + "$" + """id<[^/]+>/""" + "$" + """haslo<[^/]+>""",
      """GET     /login                          controllers.UserController.login()""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_UserController_registerById17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("haslo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_registerById17_invoker = createInvoker(
    UserController_5.registerById(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerById",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """register/""" + "$" + """id<[^/]+>/""" + "$" + """haslo<[^/]+>""",
      """GET     /register                       controllers.UserController.register()""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_PublisherController_addPublisher18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addPublisher")))
  )
  private[this] lazy val controllers_PublisherController_addPublisher18_invoker = createInvoker(
    PublisherController_0.addPublisher(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublisherController",
      "addPublisher",
      Seq(classOf[String]),
      "POST",
      this.prefix + """addPublisher""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_PublisherController_deletePublisher19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delPublisher")))
  )
  private[this] lazy val controllers_PublisherController_deletePublisher19_invoker = createInvoker(
    PublisherController_0.deletePublisher(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublisherController",
      "deletePublisher",
      Seq(classOf[String]),
      "POST",
      this.prefix + """delPublisher""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_PublisherController_getPublishers20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("publishers")))
  )
  private[this] lazy val controllers_PublisherController_getPublishers20_invoker = createInvoker(
    PublisherController_0.getPublishers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublisherController",
      "getPublishers",
      Nil,
      "GET",
      this.prefix + """publishers""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_BookController_addBook21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addBook")))
  )
  private[this] lazy val controllers_BookController_addBook21_invoker = createInvoker(
    BookController_4.addBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "addBook",
      Nil,
      "POST",
      this.prefix + """addBook""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_8.index)
      }
  
    // @LINE:9
    case controllers_CountController_count1_route(params@_) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_2.count)
      }
  
    // @LINE:11
    case controllers_AsyncController_message2_route(params@_) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_7.message)
      }
  
    // @LINE:14
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_6.versioned(path, file))
      }
  
    // @LINE:16
    case controllers_BookController_getById4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_BookController_getById4_invoker.call(BookController_4.getById(id))
      }
  
    // @LINE:17
    case controllers_EBookController_getById5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EBookController_getById5_invoker.call(EBookController_3.getById(id))
      }
  
    // @LINE:18
    case controllers_AudioBookController_getById6_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AudioBookController_getById6_invoker.call(AudioBookController_1.getById(id))
      }
  
    // @LINE:20
    case controllers_BookController_getBooks7_route(params@_) =>
      call { 
        controllers_BookController_getBooks7_invoker.call(BookController_4.getBooks)
      }
  
    // @LINE:21
    case controllers_EBookController_getBooks8_route(params@_) =>
      call { 
        controllers_EBookController_getBooks8_invoker.call(EBookController_3.getBooks)
      }
  
    // @LINE:22
    case controllers_AudioBookController_getBooks9_route(params@_) =>
      call { 
        controllers_AudioBookController_getBooks9_invoker.call(AudioBookController_1.getBooks)
      }
  
    // @LINE:32
    case controllers_BookController_addToDbById10_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_BookController_addToDbById10_invoker.call(BookController_4.addToDbById(id))
      }
  
    // @LINE:33
    case controllers_EBookController_addToDbById11_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EBookController_addToDbById11_invoker.call(EBookController_3.addToDbById(id))
      }
  
    // @LINE:34
    case controllers_AudioBookController_addToDbById12_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AudioBookController_addToDbById12_invoker.call(AudioBookController_1.addToDbById(id))
      }
  
    // @LINE:36
    case controllers_BookController_deleteFromDbById13_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_BookController_deleteFromDbById13_invoker.call(BookController_4.deleteFromDbById(id))
      }
  
    // @LINE:37
    case controllers_EBookController_deleteFromDbById14_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_EBookController_deleteFromDbById14_invoker.call(EBookController_3.deleteFromDbById(id))
      }
  
    // @LINE:38
    case controllers_AudioBookController_deleteFromDbById15_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AudioBookController_deleteFromDbById15_invoker.call(AudioBookController_1.deleteFromDbById(id))
      }
  
    // @LINE:50
    case controllers_UserController_loginById16_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("haslo", None)) { (id, haslo) =>
        controllers_UserController_loginById16_invoker.call(UserController_5.loginById(id, haslo))
      }
  
    // @LINE:53
    case controllers_UserController_registerById17_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("haslo", None)) { (id, haslo) =>
        controllers_UserController_registerById17_invoker.call(UserController_5.registerById(id, haslo))
      }
  
    // @LINE:56
    case controllers_PublisherController_addPublisher18_route(params@_) =>
      call(params.fromQuery[String]("name", None)) { (name) =>
        controllers_PublisherController_addPublisher18_invoker.call(PublisherController_0.addPublisher(name))
      }
  
    // @LINE:57
    case controllers_PublisherController_deletePublisher19_route(params@_) =>
      call(params.fromQuery[String]("name", None)) { (name) =>
        controllers_PublisherController_deletePublisher19_invoker.call(PublisherController_0.deletePublisher(name))
      }
  
    // @LINE:58
    case controllers_PublisherController_getPublishers20_route(params@_) =>
      call { 
        controllers_PublisherController_getPublishers20_invoker.call(PublisherController_0.getPublishers)
      }
  
    // @LINE:60
    case controllers_BookController_addBook21_route(params@_) =>
      call { 
        controllers_BookController_addBook21_invoker.call(BookController_4.addBook())
      }
  }
}
