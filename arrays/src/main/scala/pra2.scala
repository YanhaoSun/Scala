sealed trait Item:
  def desc: String

case class Article(desc: String, price: Double) extends Item
case class Bundle(desc: String, discount: Double, items: List[Item]) extends Item

//Total price of an item
def price(item: Item): Double =
  item match
    case Article(_, price) => price
    case Bundle(_, discount, items) =>
      /**
      //不同的写法
      //items.map((item) => price(item)).sum - discount
      //items.foldLeft(0.0)((sum, item) => sum+price(item))-discount
      //items.foldLeft(0.0)(_+price(_))-discount
      **/
      items.map(price).sum-discount

//List of descriptions of Bundles that have a discount of > 10%
def goodValueBundles(item: Item): List[String] =
  def percentageDiscount(bundle: Bundle): Double =
    bundle.discount * 100.0 / price(bundle)
  def goodValueHelper(item: Item, nameSoFar: List[String]): List[String] =
    item match
      case a: Article => nameSoFar
      case b: Bundle =>
        nameSoFar :+ b.desc
        b.items.flatMap(item => goodValueHelper(item, nameSoFar))
  goodValueHelper(item, List())

