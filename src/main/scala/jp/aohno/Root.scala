package jp.aohno

import scala.xml.Elem

case class Root(node: Node)

case class Node(elem: List[String])

case class RootRef(node: NodeRef) {
  val toRoot: Root = Root(node.toNode)
}

case class NodeRef(elem: AnyRef) {
  val toNode: Node = elem match {
    case elems: List[String] =>
      Node(elems)
    case elem: String =>
      Node(List(elem))
    case _ => Node(Nil)
  }
}

case object Root {

  val emptyElemXml: Elem = <node></node>

  val singleElemXml: Elem = <node>
    <elem>text</elem>
  </node>

  val list2ElemXml: Elem = <node>
    <elem>text</elem>
    <elem>text</elem>
  </node>

}

case object RootRef extends Model[RootRef]