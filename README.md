# Movie API :

## ` User story 1:`

As a user, I should see a list of movies when I visit GMDB.

When I visit GMDB
Then I can see a list of all movies.

| `URI`                             | `Method` | `Description`                                          |
|---------------------------------|--------|------------------------------------------------------|
|/movie                        |GET     | Get a all the movies from the Movie database.                         |

## `User story 2:`

As a user, I can browse each movie so I can learn all the details.

Rule: Movie details include title, director, actors, release year, description and star rating.

Given an existing movie
When I visit that title
Then I can see all the movie details.

Given a non-existing movie
When I visit that title
Then I receive a friendly message that it doesn't exist.

| `URI`                             | `Method` | `Description`                                          |
|---------------------------------|--------|------------------------------------------------------|
|/movie/{title}                      |GET     | Get a all the movie by title & friendly message if movie by title doesn't exist                     |


## `User story 3:`

As a user, I can give a star rating to a movie so that I can share my experiences with others.

Given an existing movie
When I submit a 5 star rating
Then I can see it in the movie details.

Given a movie with one 5 star rating and one 3 star rating
When I view the movie details
Then I expect the star rating to be 4.

| `URI`                             | `Method` | `Description `                                         |
|---------------------------------|--------|------------------------------------------------------|
|/movie                        |PATCH     | Update the Start rating to the movie with 5 by title & update same movie by title with 5,3 and get the overall rating for the movie.                     |


## `User story 4:`

Given an existing movie
When I submit a star rating and text review
Then I can see my contribution on the movie details.

Given an existing movie
When I submit a text review without a star rating
Then I receive a friendly message that a star rating is required.

| `URI`                             | `Method` | `Description`                                          |
|---------------------------------|--------|------------------------------------------------------|
|/movie                        |PATCH     |  Submit the star rating and text review by title and ge the movie details & and show friendly message if the star rating is set.                       |
                    

