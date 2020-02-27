package example

import jp.aohno.Node
import org.scalatest._

class NodeSpec extends FlatSpec with Matchers {
  "Node" should " elem count check" in {
    val listNode = Node.make(Node.listXml)
    listNode.root.elem.size shouldEqual 2
  }
}
