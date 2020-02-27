package jp.aohno

import scala.xml.Elem

case class Node(root: Root)
case class Root(elem: List[String])

case object Node extends Model[Node] {

  val emptyXml: Elem = <root></root>

  val singleXml: Elem = <root><elem>text</elem></root>

  val listXml: Elem = <root><elem>text</elem><elem>text</elem></root>

}