package jp.aohno

import org.json4s.native.Serialization
import org.json4s.{CustomSerializer, DefaultFormats, Formats, JValue, Xml, _}

import scala.xml.NodeSeq

abstract class Model[T: Manifest] {

  implicit val formats: Formats = DefaultFormats
    .+(new ListStringSerializer())

  def apply(jValue: JValue): T = {
    jValue.extract[T]
  }

  class ListStringSerializer extends CustomSerializer[List[String]](_ => ( {
    case JString(x) => List(x)
    case JArray(x) => x.map(_.extract[String])
    case JNothing => Nil
    case JNull => Nil
  }, {
    case x: List[String] => JArray(x.map(JString(_)))
  }))

  def apply(nodeSeq: NodeSeq): T = {
    val jValue = Xml.toJson(nodeSeq)
    apply(jValue)
  }

  def toJson(JValue: JValue): String = {
    Serialization.write(JValue)
  }

  def toJson(instance: T): String = {
    Serialization.write(instance)
  }
}