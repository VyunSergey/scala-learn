package io.github.vyunsergey.lectures

object Lesson04Functions extends App {
  /*
  * В программировании вообще есть два вида функций:
  *  функции - именованный блок кода, принимающий входные значение,
  *            выполняющий над ними действия и возвращающий значение
  *  Например: def sum(x: Int): Int = { x + 1 }
  *  процедуры - именованный блок кода, принимающий входные значение,
  *            выполняющий над ними действия и не возращающий никаких значений
  *  Например: def info(str: String) = println(s"Info: $str")
  *
  * В Scala - это все функции, т.е. они все возвращают значение,
  *  для процедур в Scala придумано значение () типа Unit
  *
  * То, что в программировании вообще называется функциями, в Scala называют методом(ключевое слово def),
  * но, чтобы было привычнее, останемся с термином функция.
  *
  * В Scala функциями называются обычные значения(ключевые слова val и var),
  * которые можно использовать как методы т.е. они принимают параметры,
  * производят над ними действия и возвращают результат
  * Например: val sum = (x: Int) => { x + 1 }
  * Переменная sum имеет тип Int => Int или Function1[Int, Int] и являтеся функцией с параметром x: Int
  * */

  // Пример функции для ФИО
  def person(firstName: String, middleName: String, lastName: String): String = {
    s"$firstName $middleName $lastName"
  }
  println(person("John", "Baba Yaga", "Wick"))

  // Пример процедуры для вывода ФИН на экран в консоль
  def printPerson(firstName: String, middleName: String, lastName: String): Unit = {
    println(person(firstName, middleName, lastName))
  }
  printPerson("Luke", "Wormie", "Skywalker")

  // Функция может иметь параметры по умолчанию
  def personTwo(firstName: String = "Unknown",
                middleName: String = "Unknown",
                lastName: String = "Unknown"): String = {
    s"$firstName $middleName $lastName"
  }
  // Тогда вызывать ее можно пропуская переменные, значения которых возьмутся по умолчанию
  // Надо помнить про порядок следования, что значения по умолчанию берутся с конца списка параметров фунции
  println(personTwo("John", "Wick"))
  println(personTwo())

  // Можно вызывать функции явно указывая имя передаваемого параметра
  println(personTwo(firstName = "John"))
  println(personTwo(middleName = "Baba Yaga"))
  println(personTwo(lastName = "Wick"))

  /*
  * Передача параметров в функции поддерживается двумя способами:
  * вызов по значению(call-by-value) - вычисление значения параметра перед телом функции и использование значения в нем
  * вызов по имени(call-by-name) - вычисление значения параметра каждый раз при обращении к нему в теле функции
  * */

  // call-by-value стандартное самое распространенное использование -
  // значение передаваемое в функцию вычисляется только один раз
  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }
  callByValue(System.nanoTime)

  // call-by-name используется для оптимизациивычислений -
  // если внутри тела функции значение не будет испоьзоваться, оно не будет вычисляться
  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }
  callByName(System.nanoTime)

  // Рассмотрим на примере долгого вычисления
  def computingLong(): Long = {
    println("Computing...")
    Long.MaxValue
  }
  callByValue(computingLong())
  callByName(computingLong())

  // Также Scala позволяет определять новые функции внтури тела уже какой-то функции
  def bossFunction(name: String): String = {
    def helperFunction(name: String): String = s"${name.toUpperCase} the BOOS!"

    s"I'm ${helperFunction(name)}"
  }
  println(bossFunction("Denis"))

  // Также в Scala можно в параметрах функции передавать "повторяемый параметр",
  // который воспринимается как последовательность типа Seq[T]
  def sumAll(first: Int, others: Int*): Int = {
    first + others.sum
  }
  println(sumAll(1))
  println(sumAll(1, 2))
  println(sumAll(1, 2, 3, 4, 5))

  // Поговорим про функции в Scala
  // Функциям в Scala можно приваивать в качестве значений методы
  def addOne0(x: Int): Int = { x + 1 }
  val addOne1: Int => Int = (x: Int) => { x + 1 }
  val addOne2: Int => Int = addOne0
  val addOne3 = addOne0 _
  println(addOne0(1))
  println(addOne1(1))
  println(addOne2(1))
  println(addOne3(1))

  // Значения функций можно задавать через лямбда синтаксис
  val addOne4: Int => Int = x => x + 1
  val addOne5 = (x: Int) => x + 1
  // Компилятор поддерживает короткую запись через подчеркивание без имени аргумента
  val addOne6: Int => Int = _ + 1
  println(addOne4(1))
  println(addOne5(1))
  println(addOne6(1))

  // Композиция функций в Scala
  // Функции, состоящие из последовательного вызова
  // других функций, можно задавать композицией
  // с помощью методов andThen и compose
  // f(x) -> x, g(x) -> x
  // f andThen g = g(f(x))
  // f compose g = f(g(x))

  // addThree1(x) = addOne2(addOne1(addOne0(x)))
  val addThree1: Int => Int = addOne0 _ andThen addOne1 andThen addOne2
  // addThree1(x) = addOne3(addOne4(addOne5(x)))
  val addThree2 = addOne3 compose addOne4 compose addOne5
  println(addThree1(1))
  println(addThree2(1))
}
