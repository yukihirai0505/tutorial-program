import scala.concurrent.Future

// Seq[Seq[Int]]
val sequence = Seq(Seq(1,2,3), Seq(4), Seq(5,6))
// Seq[Seq[Int]] => Seq[Int]
sequence flatMap { x => x}
sequence flatten

// Seq[Int] = List(10, 1, 2, 3, 10, 4, 10, 5, 6)
sequence flatMap { x => 10 +: x }

/*
flatMapの動き

Seq(Seq(1,2,3), Seq(), Seq(5,6))
↓ // map(各Seqの先頭要素に10を追加)
Seq(Seq(10,1,2,3), Seq(10), Seq(10,5,6))
↓ // flatten
Seq(10,1,2,3,10,10,5,6)
 */


/*
sequence flatMap { x => x} は
sequence flatMap identity とかける
*/

// こんな書き方もできる
Future successful Seq(1, 2, 3).map { number =>
  Seq(number, number*2, number*3)
}.foldLeft(Seq.empty[Int]) { (acc, seq) => acc ++ seq }