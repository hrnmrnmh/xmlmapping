package jp.aohno

import scala.xml.Elem

case class Node(root: Root)
case class Root(elem: List[String])

case object Node extends Model[Node] {

  val emptyElemXml: Elem = <root></root>

  val singleElemXml: Elem = <root><elem>text</elem></root>

  val list2ElemXml: Elem = <root><elem>text</elem><elem>text</elem></root>

}