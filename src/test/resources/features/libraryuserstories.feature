Feature: Get a Book from a Library
	As a library customer
	I want to get a book from the library using its isbn
	So that I can get info about the book

Scenario Outline: Get an existing Book from the Library
   Given Library and BookInventory services are running and BookInventory's db has isbn, <isbn>, in it
   When The Library Microservice receives a request for isbn, <isbn>
   Then The Library microservice should return book information for isbn, <isbn>

  Examples:
    | isbn  |
    | 12345      | 
    | 875        |

Scenario Outline: Try to get a Book that does not exist in the Library
   Given Library and BookInventory services are running and BookInventory's db does not have isbn, <isbn>, in it
   When The Library Microservice receives a request for isbn, <isbn>
   Then The Library microservice should return no data for isbn, <isbn>

  Examples:
    | isbn  |
    | 9999  | 