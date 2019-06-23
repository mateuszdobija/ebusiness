// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mateusz/ebiznes/zad_5/conf/routes
// @DATE:Thu Jun 13 00:31:33 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:16
  class ReverseBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def deleteFromDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "booksdelfromdb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:32
    def addToDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "booksToDb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:60
    def addBook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addBook")
    }
  
    // @LINE:20
    def getBooks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books")
    }
  
    // @LINE:16
    def getById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:18
  class ReverseAudioBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def addToDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "audiobookToDb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:22
    def getBooks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "audiobooks")
    }
  
    // @LINE:18
    def getById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "audiobook/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:38
    def deleteFromDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "audiobookdelfromdb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:9
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:50
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def registerById(id:String, haslo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("haslo", haslo)))
    }
  
    // @LINE:50
    def loginById(id:String, haslo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("haslo", haslo)))
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:11
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:17
  class ReverseEBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def addToDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ebooksToDb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:21
    def getBooks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ebooks")
    }
  
    // @LINE:17
    def getById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ebooks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:37
    def deleteFromDbById(id:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ebooksdelfromdb/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:56
  class ReversePublisherController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def deletePublisher(name:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delPublisher" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("name", name)))))
    }
  
    // @LINE:56
    def addPublisher(name:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addPublisher" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("name", name)))))
    }
  
    // @LINE:58
    def getPublishers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "publishers")
    }
  
  }


}
