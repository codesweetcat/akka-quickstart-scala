import java.util.UUID


class Item {
 val id:UUID = UUID.randomUUID()
}
class ElectronicItem(val name: String, val subCatagory: String) extends Item {
  val uuid: String = "Elec_"+id
}
object CartApp extends App{

  def showItems(item: ElectronicItem) = println(s"Item uuid: ${item.uuid} Item ID: ${item.id} name: ${item.name}")

  showItems(new ElectronicItem("Xperia", "Mobiles"))
}
