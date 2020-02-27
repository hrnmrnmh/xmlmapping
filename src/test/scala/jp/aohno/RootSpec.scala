package jp.aohno

import org.scalatest._

class RootSpec extends FlatSpec with Matchers {
  "Node make" should " elem count check" in {
    val listRoot = Root.make(Root.list2ElemXml)
    listRoot.node.elem.size shouldEqual 2

    val emptyRoot = Root.make(Root.emptyElemXml)
    emptyRoot.node.elem.size shouldEqual 0

    // single is not List
    // throw error
    val singleRoot = Root.make(Root.singleElemXml)
    singleRoot.node.elem.size shouldEqual 1
  }
}
