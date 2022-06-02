package io.github.vyunsergey.exercises

object Chapter01 extends App {
  // 1. В окне Scala REPL введите 3., затем нажмите клавишу Tab.
  //Какие методы могут быть вызваны?

  // 2. В окне Scala REPL вычислите квадратный корень из 3, а за-
  //тем возведите результат в квадрат. Насколько окончательный
  //результат отличается от 3?

  // 3. Переменные res в окне Scala REPL – это значения val или настоящие переменные var?

  // 4. Язык Scala позволяет умножать строки на числа – попробуйте
  // выполнить выражение «crazy» * 3 в REPL. Что получилось в результате?
  println("crazy" * 3)

  // 5. Что означает выражение 10 max 2? В каком классе определен метод max?
  println(10.max(2))

  // 6. Используя число типа BigInt, вычислите 2^1024
  println(BigInt(2).pow(1024))

  // 7. Что нужно импортировать для нахождения случайного простого
  // числа вызовом метода probablePrime(100, Random) без использования
  // каких-либо префиксов перед именами probablePrime и Random?
  import scala.util.Random
  import BigInt.probablePrime
  println(probablePrime(100, Random))

  // 8. Один из способов создать файл или каталог со случайным
  // именем состоит в том, чтобы сгенерировать случайное число
  // типа BigInt и преобразовать его в систему счисления по
  // основанию 36, в результате получится строка, такая как
  // "qsnvbevtomcj38o06kul".
  def randomName(): String = probablePrime(100, Random).toString(36)
  for (_ <- 0 until 10) println(randomName())

  // 9. Как получить первый символ строки в языке Scala? А последний символ?
  val str: String = "Hello, World"
  println(s"[${str.head}] [${str.tail}]")

  // 10. Что делают строковые функции take, drop, takeRight и dropRight?
  // Какие преимущества и недостатки они имеют в сравнении с substring?
  println(s"[${str.take(2)}] [${str.drop(2)}]")
  println(s"[${str.takeRight(2)}] [${str.dropRight(2)}]")
}
