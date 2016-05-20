package services

import javax.inject.{Inject, Singleton}

import domain.Movie
import play.api.db.DBApi
import anorm._
import anorm.SqlParser._

@Singleton
class MovieService @Inject() (dbapi : DBApi){

  private val db = dbapi.database("default")

  val movie = {
    get[String]("name")~
    get[Int]("stars") map {
      case name~rating => Movie(name, rating)
    }
  }

  def list : List[Movie] = db.withConnection{ implicit conn =>
    SQL("SELECT * FROM movies").as(movie *)
  }

  def insert(movie : Movie) = {
    db.withConnection { implicit connection =>
      SQL(
        """
          insert into movies values ({name}, {stars})
        """
      ).on(
        'name -> movie.name,
        'stars -> movie.stars
      ).executeUpdate()
    }
  }
}
