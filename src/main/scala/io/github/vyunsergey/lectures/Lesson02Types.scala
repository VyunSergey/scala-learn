package io.github.vyunsergey.lectures

object Lesson02Types extends App {
  /*
  * Все типы в Scala разделяюся на две группы: `AnyVal` и `AnyRef`,
  * которые в свою очередь являются подтипами типа `Any`
  * `Any` - это супертип всех типов, педоставляет универсальные методы
  *         т.к. `equals`, `hashCode` и `toString`
  * `AnyVal` - надтип всех типов-значений, существует 9 предопределенных
  *   типов значений: `Boolean`,`Short`,`Int`,`Long`,`Float`,`Double`,`Char`,`Byte`,`Unit`
  * `AnyRef` - надтип всех ссылочных типов, т.е. всех типов, которые не являются типами-значений,
  *   каждый пользовательский тип в Scala является подтипом AnyRef
  * Также есть типы для обозначения границы снизу т.е. типы:
  * `Nothing` - тип отсутсвия значения, подтип любого другого типа
  * `Null` - тип пустой ссылки, подтип любого ссылочного типа
  * */

  // `Boolean` - булевый тип, принимающий два возможных значения: истина - true и ложь - false
  val aBooleanTrue: Boolean = true
  val aBooleanFalse: Boolean = false
  println(aBooleanTrue, aBooleanFalse)

  // `Byte`    - 8 битовое знаковое значение. Диапазон от -128 до 127
  val aByte: Byte = 125
  println(aByte, Byte.MinValue, Byte.MaxValue)

  // `Short`   - 16 битовое знаковое значение. Диапазон от -32768 to 32767
  val aShort: Short = 101
  println(aShort, Short.MinValue, Short.MaxValue)

  // `Int`     - 32 битовое знаковое значение. Диапазон от -2147483648 to 2147483647
  val aInt: Int = -100500
  println(aInt, Int.MinValue, Int.MaxValue)

  // `Long`    - 64 битовое знаковое значение. Диапазон от -9223372036854775808 to 9223372036854775807
  val aLong: Long = 1000000000000L
  println(aLong, Long.MinValue, Long.MaxValue)

  // `Float`   - 32 битовое IEEE 754 число с плавающей точкой одинарной точности
  // -12.34 => -1234e(-2)
  val aFloat: Float = -3.1415F
  println(aFloat, Float.MinValue, Float.MinPositiveValue, Float.MaxValue)

  // `Double`  - 64 битовое IEEE 754 число с плавающей точкой двойной точности
  val aDouble: Double = 3.141592653589793238462643
  println(aDouble, Double.MinValue, Double.MinPositiveValue, Double.MaxValue)

  // `Char`    - 16 битовое беззнаковый символ Unicode. Диапазон от U+0000 to U+FFFF
  val aChar: Char = '*'
  println(aChar, Char.MinValue, Char.MaxValue)

  // `Unit`    - Соответствует отсутствию значения
  val aUnit: Unit = ()
  println(aUnit)

  // Чтобы узнать тип переменной можно воспользоваться встроенным у Any методом `getClass`
  println(aBooleanTrue.getClass)
  println(aByte.getClass)
  println(aInt.getClass)
  println(aLong.getClass)
  println(aChar.getClass)
  println(aUnit.getClass)
}
