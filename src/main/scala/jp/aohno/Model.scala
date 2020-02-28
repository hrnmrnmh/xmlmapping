package jp.aohno

import org.json4s.native.Serialization
import org.json4s.{DefaultFormats, Formats, JValue, Xml}

import scala.xml.Elem

abstract class Model[T: Manifest] {

  implicit val formats: Formats = DefaultFormats

  def apply(jValue: JValue): T = {
    jValue.extract[T]
  }

  def apply(xmlElement: Elem): T = {
    val jValue = Xml.toJson(xmlElement)
    apply(jValue)
  }

  def toJson(JValue: JValue): String = {
    Serialization.write(JValue)
  }
}