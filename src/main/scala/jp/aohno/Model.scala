package jp.aohno

import org.json4s._
import org.json4s.native.Serialization
import org.json4s.{CustomSerializer, DefaultFormats, Formats, JValue, Xml}

import scala.xml.Elem

abstract class Model[T: Manifest] {

  implicit val formats: Formats = DefaultFormats
    .+(new ListStringSerializer())

  def apply(jValue: JValue): T = {
    jValue.extract[T]
  }

  class ListStringSerializer extends CustomSerializer[List[String]](_ => ( {
    case JString(x) => List(x)
    case JArray(x) => x.map(_.toString)
    case JNothing => Nil
    case JNull => Nil
  }, {
    case x: List[String] => JArray(x.map(JString(_)))
  }

  ))
  def apply(xmlElement: Elem): T = {
    val jValue = Xml.toJson(xmlElement)
    apply(jValue)
  }

  def toJson(JValue: JValue): String = {
    Serialization.write(JValue)
  }
}