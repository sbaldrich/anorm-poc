import play.api.libs.json.{Json, Format}

package object domain {
  implicit val movieFormat: Format[Movie] = Json.format[Movie]
}
