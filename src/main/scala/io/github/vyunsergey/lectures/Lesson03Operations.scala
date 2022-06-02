package io.github.vyunsergey.lectures

object Lesson03Operations extends App {
  /*
  * Scala поддерживает все стандартные операции работы с числами
  * */
  val a = 42
  // унарная операция +
  println(+a)
  // унарная операция -
  println(-a)
  // сложение
  println(a + 1)
  // вычитание
  println(a - 1)
  // умножение
  println(a * 2)
  // целочисленное деление
  println(a / 5)
  // остаток от деления
  println(a % 5)
  // деление с плавающей точкой
  println(a / 5.0)

  // встроенный надо математических функций в объекте math(Scala) или Math(Java)
  println(math.exp(a), math.sqrt(a), math.sin(a), math.log(a), math.pow(a, 3))

  // Логические операции
  // равно
  println(a == 5)
  // не равно
  println(a != 5)
  // больше
  println(a > 5)
  // меньше
  println(a < 5)
  // больше либо равно
  println(a >= 5)
  // меньше либо равно
  println(a <= 5)
  // логическое отрицание
  println(!(a == 5))
  // логическое И
  println(a == 5 && a % 2 == 0)
  // логическое ИЛИ
  println(a == 5 || a % 2 == 0)

  // Битовые операции
  // побитовое отрицание
  println(~a, a.toBinaryString, (~a).toBinaryString)
  // побитовое И
  println((a & 3, a.toBinaryString, 3.toBinaryString, (a & 3).toBinaryString))
  // побитовое ИЛИ
  println(a | 3, a.toBinaryString, 3.toBinaryString, (a | 3).toBinaryString)
  // побитовое исключающее ИЛИ (сложение бит по модулю 2)
  println(a ^ 3, a.toBinaryString, 3.toBinaryString, (a ^ 3).toBinaryString)
  // побитовый сдвиг влево
  println(a << 3, a.toBinaryString, (a << 3).toBinaryString)
  // побитовый сдвиг вправо с сохранением знака
  println(-a >> 4, (-a).toBinaryString, (-a >> 4).toBinaryString)
  // побитовый сдвиг вправо с заполнением первых бит 0
  println(-a >>> 4, (-a).toBinaryString, (-a >>> 4).toBinaryString)

  /* Один из самых распостраненных типов данных
  * в Scala как и любом языке программирования является тип String
  * Ниже приедены самые частые операции для работы со строками
  * */
  val str: String = "Hello, World!"

  // получить длину строки = количество символов
  println(str.length)
  // получить символ в строке по его индексу(порядкому номеру), нумерация начинается с 0
  println(str.charAt(1))
  // получить подстроку начинающуюся с начального индекса(включительно) и до конечного индекса(исключая его)
  println(str.substring(0, 2))
  // получить подстроку из первых n символов строки
  println(str.take(2))
  // получить подстроку без первых n символов строки
  println(str.drop(2))
  // разбить строку на список строк по символу-разделителю
  println(str.split(" ").toList)
  // проверить, начинается ли строка с другой подстроки
  println(str.startsWith("He"))
  // проверить, содержит ли строка другую подстроку
  println(str.contains("o, W"))
  // заменить в строке все вхождения одной подстроки на другую подстроку
  println(str.replace("o", "@"))
  // привести все символы в строке к нижнему регистру
  println(str.toLowerCase)
  // привести все символы в строке к вернему регистру
  println(str.toUpperCase)
  // отразить все символы в строке (с конца в начало)
  println(str.reverse)

  // методы и операции можно комбинировать
  println(str.drop(2).reverse.concat(str.take(2).reverse).reverse)

  // строку можно сконвертировать в число
  val aInt: Int = "42".toInt
  println((aInt, aInt.getClass))

  val aDouble: Double = "3.1415".toDouble
  println((aDouble, aDouble.getClass))

  // Строка в Scala также представляется как последовательность символов Seq[Char]
  // т.е. к ней можно добавлять и символы Char и строки String как к последовательности
  println('#' +: str :+ '!' :+ '!')
  println(str ++ " " ++ str)

  // Также поддерживаются и арифметические операторы `+` и `*`
  println(str + 123)
  println(str * 3)

  // Интерполяция строк применяется, когда в строку
  // необходимо подставить какое-то значение переменной или вычисления
  // Есть три встроенных метода интеполяции строк через `s`, `f` и `raw`
  println(s"'$str' 'value=${1 + 2}$$' dollars")
  println(f"'$str%20s' 'value=${1 + 2}%3d $$' dollars")
  println(raw"line one\nline two")
  println(s"line one\nline two")
}
