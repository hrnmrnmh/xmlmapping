package jp.aohno

import org.scalatest._

class RootSpec extends FlatSpec with Matchers {
  "Root apply" should " elem count check" in {
    val listRoot = Root(Root.list2ElemXml)
    listRoot.node.elem.size shouldEqual 2

    val emptyRoot = Root(Root.emptyElemXml)
    emptyRoot.node.elem.size shouldEqual 0

    // single is not List
    // throw error
    val singleRoot = Root(Root.singleElemXml)
    singleRoot.node.elem.size shouldEqual 1
  }
}
