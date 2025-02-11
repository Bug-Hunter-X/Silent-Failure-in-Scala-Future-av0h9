```scala
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(i: Int): Future[Int] = Future {
    if (i == 0) throw new Exception("Something went wrong")
    i * 2
  }.recover {
    case e: Exception => 
      println(s"Error in myMethod: ${e.getMessage}")
      0 // Or another appropriate default value
  }
}

// Example usage:

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global
  val myClass = new MyClass()
  val futureResult = myClass.myMethod(0)
  val futureResult2 = myClass.myMethod(5)

  futureResult.onComplete {
    case Success(value) => println(s"Success: $value")
    case Failure(exception) => println(s"Failure: ${exception.getMessage}")
  }
    futureResult2.onComplete {
    case Success(value) => println(s"Success: $value")
    case Failure(exception) => println(s"Failure: ${exception.getMessage}")
  }

  Thread.sleep(1000)
}
```