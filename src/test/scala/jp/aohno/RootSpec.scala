package jp.aohno

import org.scalatest._

class RootSpec extends FlatSpec with Matchers {
  "Root apply" should " elem count check" in {
    val listRoot = RootRef(Root.list2ElemXml).toRoot
    listRoot.node.elem.size shouldEqual 2

    val emptyRoot = RootRef(Root.emptyElemXml).toRoot
    emptyRoot.node.elem.size shouldEqual 0

    // single is not List
    // throw error
    val singleRoot = RootRef(Root.singleElemXml).toRoot
    singleRoot.node.elem.size shouldEqual 1
  }
}
