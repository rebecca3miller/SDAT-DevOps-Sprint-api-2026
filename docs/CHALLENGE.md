Q1. Which two endpoints did you add pagination to, and why did those make sense to paginate?
I added pagination to the GET /patients endpoint and the GET /aircraft endpoint. These endpoints make sense to paginate because they can potentially return a large number of records that are more likely to change then the other entity data. Pagination helps to limit the amount of data sent in one of these single response. 

Q2. Show a Postman request that uses pagination and sorting (Show a screenshot from postman when you test)
on one of your endpoints. What URL did you use, and what did the response look like?

**Empty response:** This request returned no passengers because the database had no sample data.

![Postman pagination and sorting request with an empty response](images/Screenshot%202026-11-08%20at%203.11.51%E2%80%AFPM.png)

**Response with data:** With the API running and sample data added to the database, the request returned passenger records.

![Postman pagination and sorting request with passenger data](images/Screenshot%202026-11-08%20at%204.04.20%E2%80%AFPM.png)
I used passengers/paged and aircraft/paged endpoints to test pagination and sorting. The response included a list of 3 passengers sorted by last name in ascending order. The response also included the total number of pages, the current page, and the size of the page.

Q3. In your own code, what does the Pageable parameter do in your repository or controller? Paste the relevant
method signature and explain it.

public Page<Passenger> getPassengers(Pageable pageable)

The Pageable parameter holds the page number, page size, and sorting options from the request. The controller passes it to PassengerService, which then passes it to the PassengerRepository. The repository uses this information to retrieve the appropriate page of data from the database.

Q4. What is the difference between Page<T> and List<T> as a return type? Why might you choose one over the
other?
The difference between Page<T> and List<T> is that Page<T> splits data into pages using size and page number parameters while also providing metadata, while List<T> returns all data in a single response. Page<T> is useful for large datasets where you want to limit the amount of data returned in a single response, while List<T> is useful for smaller datasets where you want to return all data at once.