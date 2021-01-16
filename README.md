# Movie API :

## User story 1:

As a user, I should see a list of movies when I visit GMDB.

When I visit GMDB
Then I can see a list of all movies.

## User story 2:

As a user, I can browse each movie so I can learn all the details.

Rule: Movie details include title, director, actors, release year, description and star rating.

Given an existing movie
When I visit that title
Then I can see all the movie details.

Given a non-existing movie
When I visit that title
Then I receive a friendly message that it doesn't exist.

