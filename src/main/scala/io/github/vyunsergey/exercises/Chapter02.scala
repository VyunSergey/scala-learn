package io.github.vyunsergey.exercises

import scala.annotation.tailrec

object Chapter02 extends App {
  // 1. Сигнум числа равен 1, если число положительное, -1 – если
  // отрицательное, и 0 – если оно равно нулю.
  // Напишите функцию, вычисляющую это значение.
  def sign(a: Int): Int = if (a > 0) 1 else if (a < 0) -1 else 0

  // 2. Какое значение возвращает пустой блок {}? Каков его тип?
  val emptyBlock: Unit = {}
  println(emptyBlock)

  // 3. Придумайте ситуацию, когда присвоение x = y = 1 будет допустимым в Scala.
  var y = 0
  val x: Unit = y = 1
  println((y, x))

  // 4. Напишите на языке Scala цикл, эквивалентный циклу на языке Java
  // for (int i = 10; i >= 0; i--) System.out.println(i);
  for (i <- 10 to 0 by -1) println(i)

  // 5. Напишите процедуру countdown(n: Int), которая выводит числа от n до 0.
  def countdown(n: Int): Unit = for (i <- n to 0 by -1) println(i)

  // 6. Напишите цикл for для вычисления произведения кодовых
  // пунктов Юникода всех букв в строке. Например, произведение
  // символов в строке "Hello" равно 9415087488L.
  def productChars(str: String): Long = {
    var prod: Long = 1
    for(c <- str) prod *= c
    prod
  }
  println(productChars("Hello"), 9415087488L)

  // 7. Решите предыдущее упражнение без применения цикла.
  def productCharsTwo(str: String): Long = str.foldLeft(1L) { case (prod, c) => prod * c }
  println(productCharsTwo("Hello"), 9415087488L)

  // 8. Напишите функцию product(s : String), вычисляющую произведение,
  // как описано в предыдущих упражнениях.
  val product: String => Long = (str: String) => productCharsTwo(str)
  println(product("Hello"), 9415087488L)

  // 9. Сделайте функцию из предыдущего упражнения рекурсивной.
  def productCharsRec(str: String): Long =
    if (str.isEmpty) 1L
    else str.head * productCharsRec(str.tail)
  println(productCharsRec("Hello"), 9415087488L)

  @tailrec
  def productCharsTailRec(str: String, prod: Long = 1L): Long =
    if (str.isEmpty) prod
    else productCharsTailRec(str.tail, prod * str.head)
  println(productCharsTailRec("Hello"), 9415087488L)

  // 10. Напишите функцию, вычисляющую x^n, где n – целое число
  // Используйте следующее рекурсивное определение:
  //  • x^n = y^2, если n – четное и положительное число, где y = x^(n/2)
  //  • x^n = x · x^(n–1), если n – нечетное и положительное число
  //  • x^0 = 1
  //  • x^n = 1/x^(–n), если n – отрицательное число
  // Не используйте инструкцию return
  def powN(x: Double, n: Int): Double = {
    if (n < 0) 1 / powN(x, -n)
    else if (n == 0) 1.0
    else if (n % 2 == 1) x * powN(x, n - 1)
    else  {
      val y = powN(x, n / 2)
      y * y
    }
  }
  println(2.0, math.pow(2.0, 0.0), powN(2.0, 0))
  println(2.0, math.pow(2.0, 3.0), powN(2.0, 3))
  println(2.0, math.pow(2.0, 4.0), powN(2.0, 4))
  println(2.0, math.pow(2.0, -3.0), powN(2.0, -3))
  println(2.0, math.pow(2.0, -4.0), powN(2.0, -4))
  println(0.0, math.pow(0.0, -1.0), powN(0.0, -1))
}
