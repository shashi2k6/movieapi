# Movie API :

### `## User story 1:`

As a user, I should see a list of movies when I visit GMDB.

When I visit GMDB
Then I can see a list of all movies.

### `## User story 2:`

As a user, I can browse each movie so I can learn all the details.

Rule: Movie details include title, director, actors, release year, description and star rating.

Given an existing movie
When I visit that title
Then I can see all the movie details.

Given a non-existing movie
When I visit that title
Then I receive a friendly message that it doesn't exist.

### `## User story 3:`

As a user, I can give a star rating to a movie so that I can share my experiences with others.

Given an existing movie
When I submit a 5 star rating
Then I can see it in the movie details.

Given a movie with one 5 star rating and one 3 star rating
When I view the movie details
Then I expect the star rating to be 4.

### `## User story 4:`

Given an existing movie
When I submit a star rating and text review
Then I can see my contribution on the movie details.

Given an existing movie
When I submit a text review without a star rating
Then I receive a friendly message that a star rating is required.

