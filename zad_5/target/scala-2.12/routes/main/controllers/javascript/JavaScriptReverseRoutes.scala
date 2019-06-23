// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mateusz/ebiznes/zad_5/conf/routes
// @DATE:Thu Jun 13 00:31:33 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def deleteFromDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.deleteFromDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "booksdelfromdb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:32
    def addToDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.addToDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "booksToDb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:60
    def addBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.addBook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBook"})
        }
      """
    )
  
    // @LINE:20
    def getBooks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.getBooks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
        }
      """
    )
  
    // @LINE:16
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseAudioBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def addToDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AudioBookController.addToDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "audiobookToDb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:22
    def getBooks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AudioBookController.getBooks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "audiobooks"})
        }
      """
    )
  
    // @LINE:18
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AudioBookController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "audiobook/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:38
    def deleteFromDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AudioBookController.deleteFromDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "audiobookdelfromdb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def registerById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.registerById",
      """
        function(id0,haslo1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("haslo", haslo1))})
        }
      """
    )
  
    // @LINE:50
    def loginById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.loginById",
      """
        function(id0,haslo1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("haslo", haslo1))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseEBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def addToDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EBookController.addToDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ebooksToDb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:21
    def getBooks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EBookController.getBooks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ebooks"})
        }
      """
    )
  
    // @LINE:17
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EBookController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ebooks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:37
    def deleteFromDbById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EBookController.deleteFromDbById",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ebooksdelfromdb/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:56
  class ReversePublisherController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def deletePublisher: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublisherController.deletePublisher",
      """
        function(name0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delPublisher" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("name", name0)])})
        }
      """
    )
  
    // @LINE:56
    def addPublisher: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublisherController.addPublisher",
      """
        function(name0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addPublisher" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("name", name0)])})
        }
      """
    )
  
    // @LINE:58
    def getPublishers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublisherController.getPublishers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "publishers"})
        }
      """
    )
  
  }


}
