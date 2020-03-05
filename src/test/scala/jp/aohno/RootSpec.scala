package jp.aohno

import org.scalatest._

import scala.xml.Elem

class RootSpec extends FlatSpec with Matchers {
  "Root apply" should " elem count check" in {
    val listRoot = Root(RootSpec.list2ElemXml)
    listRoot.node.elem.size shouldEqual 2

    val emptyRoot = Root(RootSpec.emptyElemXml)
    emptyRoot.node.elem.size shouldEqual 0

    val singleRoot = Root(RootSpec.singleElemXml)
    singleRoot.node.elem.size shouldEqual 1
  }
}

object RootSpec{
  val emptyElemXml: Elem = <node></node>

  val singleElemXml: Elem = <node>
    <elem>text</elem>
  </node>

  val list2ElemXml: Elem = <node>
    <elem>text</elem>
    <elem>text</elem>
  </node>
}