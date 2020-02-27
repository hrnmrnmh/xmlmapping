package jp.aohno

import org.json4s.native.Serialization
import org.json4s.{DefaultFormats, Formats, JValue, Xml}

import scala.xml.Elem

abstract class Model[T: Manifest] {

  implicit val formats: Formats = DefaultFormats

  def make(jValue: JValue): T = {
    jValue.extract[T]
  }

  def make(xmlElement: Elem): T = {
    val jValue = Xml.toJson(xmlElement)
    make(jValue)
  }

  def toJson(JValue: JValue): String = {
    Serialization.write(JValue)
  }
}