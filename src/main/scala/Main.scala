import scala.io.Source
import scala.util.{Failure, Success, Try}

object Main extends App {

  Try {
    Source.fromResource("resources/file.txt")
  } match {
    case Success(_) => println("Found the file")
    case Failure(exception) => println(exception.toString)
  }

}
