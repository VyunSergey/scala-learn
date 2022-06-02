package io.github.vyunsergey.exercises

import java.util.TimeZone
import scala.collection.mutable

object Chapter03 extends App {
  // Вспомогательная функция для вывода массива на экран в консоль
  def printArr[T](arr: Array[T]): Unit = println(arr.mkString("[", ",", "]"))

  // 1. Напишите фрагмент кода, который записывает в массив a целые
  // числа в диапазоне от 0 (включительно) до n (исключая его)
  def arrN(n: Int): Array[Int] = Array.tabulate(n)(i => i)
  val n = 10
  println(s"n=$n")
  printArr(arrN(n))
  println()

  // 2. Напишите цикл, меняющий местами смежные элементы в массиве целых чисел.
  // Например, Array(1, 2, 3, 4, 5) должен стать Array(2, 1, 4, 3, 5)
  def swapArrInPlace(arr: Array[Int]): Array[Int] = {
    for(i <- 0 until arr.length - 1 by 2) {
      val tmp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = tmp
    }
    arr
  }
  val arr1: Array[Int] = Array(1, 2, 3, 4, 5)
  printArr(arr1)
  swapArrInPlace(arr1)
  printArr(arr1)
  println()

  // 3. Повторите предыдущее упражнение, но создайте новый массив
  // с переставленными элементами. Используйте выражение for / yield
  def swapArr(arr: Array[Int]): Array[Int] = {
    for(pair <- arr.sliding(2, 2).toArray; a <- pair.reverse) yield a
  }
  val arr2: Array[Int] = Array(1, 2, 3, 4, 5)
  printArr(arr2)
  printArr(swapArr(arr2))
  printArr(arr2)
  println()

  // 4. Дан массив целых чисел, создайте новый массив, в котором
  // сначала будут следовать положительные значения из оригинального массива,
  // в оригинальном порядке, а за ними отрицательные и нулевые значения, тоже в оригинальном порядке.
  def reorderArr(arr: Array[Int]): Array[Int] = {
    arr.sortBy(a => if (a > 0) 0 else 1)
  }
  val arr3: Array[Int] = Array(2, 4, -1, 5, -2, 1, -3, 3, 0, -4, -5)
  printArr(arr3)
  printArr(reorderArr(arr3))
  println()

  // 5. Как бы вы вычислили среднее значение элементов массива Array[Double]?
  def average(arr: Array[Double]): Double = {
    val (sum, count) = arr.foldLeft((0.0, 0.0)) { case ((sum, count), a) => (sum + a, count + 1) }
    sum / count
  }
  val arr4: Array[Double] = Array(-1.0, -2.0, -3.0, 0.0, 1.0, 2.0, 3.0, 4.0)
  printArr(arr4)
  println(s"average=${average(arr4)} avg=${arr4.sum / arr4.length}")
  println()

  // 6. Как бы вы переупорядочили элементы массива Array[Int] так,
  // чтобы они следовали в обратном отсортированном порядке?
  // Как бы вы сделали то же самое с буфером ArrayBuffer[Int]?
  def reverseSort(arr: Array[Int]): Array[Int] = {
    arr.sortBy(x => -x)
  }
  def reverseSortWithBuffer(arr: Array[Int]): Array[Int] = {
    val buffer: mutable.AbstractBuffer[Int] = mutable.ArrayBuffer.empty[Int]
    for(a <- arr) {
      val ind = buffer.indexWhere(_ < a)
      buffer.insert(if (ind < 0) buffer.length else ind, a)
    }
    buffer.toArray
  }
  printArr(arr3)
  printArr(reverseSort(arr3))
  printArr(reverseSortWithBuffer(arr3))
  println()

  // 7. Напишите фрагмент программного кода, выводящий значения
  // всех элементов из массива, кроме повторяющихся.
  def printArrDistinct(arr: Array[Int]): Unit = {
    arr.distinct.foreach(println)
  }
  def printArrDistinctWithBuffer(arr: Array[Int]): Unit = {
    val buffer: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty[Int]
    for(a <- arr) if (!buffer.contains(a)) buffer += a
    buffer.foreach(println)
  }
  val arr5: Array[Int] = Array(-1, -1, 0, 1, 0, 2, 2, 3, 3, 4, 5)
  printArr(arr5)
  printArrDistinct(arr5)
  println()
  printArrDistinctWithBuffer(arr5)
  println()

  // 8. Перепишите пример в конце раздела 3.4 «Преобразование массивов».
  // Соберите индексы отрицательных элементов, расположите их в обратном порядке,
  // отбросьте последний индекс и вызовите a.remove(i) для каждого индекса.
  // Сравните эффективность этого подхода с двумя подходами, представленными в разделе 3.4.
  // Пример в конце раздела 3.4 «Преобразование массивов»
  // Дана последовательность целых чисел, из которой требуется удалить все отрицательные числа, кроме первого.
  def removeNegativeExceptFirst(arr: Array[Int]): Array[Int] = {
    val buffer: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(arr: _*)
    var first = true
    var n = buffer.length
    var i = 0
    while (i < n) {
      if (buffer(i) >= 0) i += 1
      else if (first) {
        first = false
        i += 1
      } else {
        buffer.remove(i)
        n -= 1
      }
    }
    buffer.toArray
  }
  def removeNegativeExceptFirstTwo(arr: Array[Int]): Array[Int] = {
    val buffer: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(arr: _*)
    var first = true
    val indexes = for (i <- buffer.indices if first || buffer(i) >= 0) yield {
      if (buffer(i) < 0) first = false
      i
    }
    for (j <- indexes.indices) buffer(j) = buffer(indexes(j))
    buffer.trimEnd(buffer.length - indexes.length)
    buffer.toArray
  }
  def removeNegativeExceptFirstThree(arr: Array[Int]): Array[Int] = {
    val buffer: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(arr: _*)
    val negativeIndexes = for(i <- buffer.indices if buffer(i) < 0) yield i
    for(j <- negativeIndexes.length - 1 until 0 by -1) buffer.remove(negativeIndexes(j))
    buffer.toArray
  }
  val arr6: Array[Int] = Array(0, 1, -7, 0, 2, -1, 2, -1, 3, 4, 5)
  printArr(arr6)
  printArr(removeNegativeExceptFirst(arr6))
  printArr(removeNegativeExceptFirstTwo(arr6))
  printArr(removeNegativeExceptFirstThree(arr6))
  println()

  // 9. Создайте коллекцию всех часовых поясов,
  // возвращаемых методом java.util.TimeZone.getAvailableIDs для Америки.
  // Отбросьте префикс “America/” и отсортируйте результат.
  def timeZonesAmerica: Seq[String] = {
    val americaPattern: String = "America/"
    (for {
      timeZone <- TimeZone.getAvailableIDs() if timeZone.startsWith(americaPattern)
      // _ = println(timeZone)
    } yield timeZone.drop(americaPattern.length)).sorted
  }
  printArr(timeZonesAmerica.toArray)
  println()

  // 10. Импортируйте java.awt.datatransfer._
  // и создайте объект типа SystemFlavorMap вызовом
  // val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  // Затем вызовите метод getNativesForFlavor
  // с параметром DataFlavor.imageFlavor
  // и получите возвращаемое значение как буфер Scala.
  import java.awt.datatransfer._

  def getFlavors: mutable.Buffer[String] = {
    import scala.collection.JavaConverters.asScalaBufferConverter

    val flavors: SystemFlavorMap = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val listFlavors: java.util.List[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    listFlavors.asScala
  }
  printArr(getFlavors.toArray)
  println()
}
