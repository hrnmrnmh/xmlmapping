package jp.aohno

import org.scalatest._

class NodeSpec extends FlatSpec with Matchers {
  "Node make" should " elem count check" in {
    val listNode = Node.make(Node.listXml)
    listNode.root.elem.size shouldEqual 2
  }
}
