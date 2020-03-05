package jp.aohno

case class Root(node: Node)

case class Node(elem: List[String])

case object Root extends Model[Root]
