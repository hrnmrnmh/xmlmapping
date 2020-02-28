package jp.aohno

case class RootSingle(node: NodeSingle) {
  val toRoot: Root = Root(node.toNode)
}

case class NodeSingle(elem: String) {
  val toNode: Node = Node(List(elem))
}

case object RootSingle extends Model[RootSingle]