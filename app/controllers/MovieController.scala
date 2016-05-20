package controllers

import javax.inject.Inject

import domain.Movie
import play.api.libs.json._
import play.api.mvc._
import domain.movieFormat
import services.MovieService

class MovieController @Inject() (movieService : MovieService) extends Controller{

  def rate() : Action[JsValue] = Action(parse.json){ request =>
    val movie = request.body.as[Movie]
    movieService.insert(movie)
    Ok(Json.toJson(movie))
  }

  def movies = Action {
    val mov = movieService.list
    Ok(Json.toJson(mov))
  }


}
