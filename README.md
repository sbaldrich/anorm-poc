### Anorm POC

A very simple proof of concept of [Anorm](https://www.playframework.com/documentation/2.5.x/ScalaAnorm) using the Play Framework.

Besides the controllers present in all starter `play-scala` applications, the `MovieController` receives a movie and a rating in JSON format (**e.g.** `{"name" : "Batman V Superman", "stars" : -10}`) and saves it to an **H2** database and also shows a list of the saved movies.

See the `domain` package object to see the JSON handling logic.

See the `MovieService` class to see **Anorm** in action.

#### Usage
* `POST` to `http://localhost:9000/rate` to add a movie:
`curl -X POST -H 'Content-Type:application/json' -d '{"name" : "Batman V Superman", "stars" : -10}' http://localhost:9000/movie`

* `GET` `http://localhost:9000/movie` to see the saved movies.
