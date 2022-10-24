## JAVA APPLICATION- GENERATING FILE WITH STRINGS

#### ENDPOINTS:

http://localhost:8080/v1/strings  POST

JSON BODY example:

````
{
    "id": 1,
    "lengthMin": 2,
    "lengthMax": 4,
    "characterArray":  
        [
        "a","b","1","d"
        ],
    "amountStrings": 30
}
````

http://localhost:8080/v1/strings/{id} GET

This get endpoint returns a String with unique strings that were created from the job id given in the path

http://localhost:8080/v1/strings GET

This get endpoint returns the number of jobs in running- NO IMPLEMENTATION :(