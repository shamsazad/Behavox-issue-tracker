# Read Me First
This application provides end-points to track issues. An issue can be assigned to any users (developer/QA/BusinessAnalyst/ProductOwner). You
can't assign issue to users if they are not created beforehand.

# Issues follow a predefined path.
 - OPEN -> IN_PROGRESS, CLOSE, RESOLVED
 - IN_PROGRESS -> RESOLVED, OPEN, CLOSE.
 - RESOLVED -> CLOSED, REOPENED.
 - CLOSED -> REOPNED.
 - REOPNED -> IN_PROGRESS, RESOLVED, CLOSED

# Getting Started
To run this program, please install maven.
### Swagger endpoints:
[Swagger end-points](http://localhost:8080/swagger-ui.html#/)



### Json payloads to create users:
```json
{
    "name": "Shams",
    "profile": "DEVELOPER"
   }
```
   
### Json payload to create issues:
```json
{
  "description": "This need to fix IronMan",
  "issueType": "BUG",
  "priority": "CRITICAL",
  "status": "OPEN",
  "title": "IronMan",
  "user": {
    "id": 1
  }
}
```
