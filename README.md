# Request Header Parser Microservice

A simple request header parser microservice built with Spring Boot. A deployed version can be viewed
[here](https://sliceheaderparser.herokuapp.com/).

### Example response:
```
{
  ipaddress: "251.1.41.24",
  language: "en-GB",
  software: "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"
}
```

## Running Locally
```
gradle bootRun
```
Then point your browser to [localhost:8080](http://localhost:8080).
