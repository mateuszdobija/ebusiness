// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mateusz/ebiznes/zad_5/conf/routes
// @DATE:Thu Jun 13 00:31:33 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
