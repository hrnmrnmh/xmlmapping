package jp.aohno

import org.scalatest._

class NodeSpec extends FlatSpec with Matchers {
  "Node make" should " elem count check" in {
    val listNode = Node.make(Node.list2ElemXml)
    listNode.root.elem.size shouldEqual 2

    val emptyNode = Node.make(Node.emptyElemXml)
    emptyNode.root.elem.size shouldEqual 0

    // single is not List
    // throw error
    val singleNode = Node.make(Node.singleElemXml)
    emptyNode.root.elem.size shouldEqual 1
  }
}
