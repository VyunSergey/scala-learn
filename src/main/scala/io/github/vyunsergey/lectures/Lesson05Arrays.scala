package io.github.vyunsergey.lectures

import scala.collection.mutable

object Lesson05Arrays extends App {
  // Вспомогательная функция для вывода массива на экран в консоль
  def printArr[T](arr: Array[T]): Unit = println(arr.mkString("[", ",", "]"))

  /*
  * В Scala есть два вида массивов
  *  Array[T](size: Int) - массив фиксированной длины n
  *  mutable.ArrayBuffer[T](initialSize: Int) - массив переменной длины
  * */
  // массив длины 10 из пустых ссылок - null
  val arrEmpty: Array[String] = new Array[String](10)
  // массив из 4 элемнтов
  val arr: Array[String] = Array("Vasya", "Sveta", "Misha", "Asya")

  // пустой буффер
  val bufferEmpty: mutable.ArrayBuffer[String] = new mutable.ArrayBuffer[String]()
  // буфер созданнй из элементов массива arr0
  val buffer: mutable.ArrayBuffer[String] = mutable.ArrayBuffer(arr: _*)
  println(arr.length)
  printArr(arr)
  println(buffer.length)
  printArr(buffer.toArray)

  // получить длину массива = количество элементов в нем
  println(arr.length)
  // получить элемент массива по его индексу ind, нумерация начинается с 0
  println(arr(1))
  // получить первый элемент массива
  println(arr.head)
  // получить все элементы массива, кроме первого
  printArr(arr.tail)
  // получить последний элемент массива
  println(arr.last)
  // получить все элементы массива, кроме последнего
  printArr(arr.init)
  // получить последовательность индексов массива
  println(arr.indices)
  // проверить элемент на вхождение в массив
  println(arr.contains("Sergey"))
  // получить индекс элемента, если он есть
  // получить индекс по условию, если оно выполнено
  // получить развернутый обратно массив
  // получить отсортированный массив
  // получить отсортированный массив по условию
  // получить разницу с другим массивом
  // получить пересечение с другим массивом

  // Функции высшегопорядка как методы массива
  // отфильтровать массив по условию
  // отсортировать массив по условию
  // изменить все элементы массива по условию
  // собрать = отфильтровать + изменить все элементы массива по условию

  // Агрегатные функции массива
}
