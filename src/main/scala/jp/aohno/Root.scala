package jp.aohno

import scala.xml.Elem

case class Root(node: Node)
case class Node(elem: List[String])

case object Root extends Model[Root] {

  val emptyElemXml: Elem = <node></node>

  val singleElemXml: Elem = <node><elem>text</elem></node>

  val list2ElemXml: Elem = <node><elem>text</elem><elem>text</elem></node>

}