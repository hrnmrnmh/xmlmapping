package jp.aohno

import scala.xml.Elem

case class Root(node: Node)

case class Node(elem: List[String])

case class RootRef(node: NodeRef) {
  val toRoot: Root = node.elem match {
    case elems: List[String] =>
      Root(Node(elems))
    case elem: String =>
      Root(Node(List(elem)))
    case _ => Root(Node(Nil))
  }
}

case class NodeRef(elem: AnyRef)

case object Root {

  val emptyElemXml: Elem = <node></node>

  val singleElemXml: Elem = <node>
    <elem>text</elem>
  </node>

  val list2ElemXml: Elem = <node>
    <elem>text</elem> <elem>text</elem>
  </node>

}

case object RootRef extends Model[RootRef]