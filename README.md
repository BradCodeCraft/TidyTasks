# TidyTasks - a *simple* Web API service for To Do list projects

## UML Design

### Object Diagram (PostgreSQL)

![Object Diagram for a PostgreSQL database](https://github.com/BradCodeCraft/TidyTasks/blob/Prod/design/TidyTasks%20--%20Object%20Diagram.png?raw=true) 

### Class Diagram (Java)

![Class Diagram for Java](https://github.com/BradCodeCraft/TidyTasks/blob/Prod/design/TidyTasks%20--%20Class%20Diagram.png?raw=true)

## API Design

### Architectural Style

REST (Representational State Transfer)

### API Requirements

Authentication: Users must send a Login or SignUp through RequestBody

Rate Limiting: Unlimited (for now)

Data Format: JSON (JavaScript Object Notation)

Versioning: KISS (Keep It Simple Stupid) format

### API Endpoints

`api/users`

- GET: retrieves all information about users 

`api/users/login`

- POST: grants user access (if correct login information)

`api/users/signup`

- POST: registers user into database

`api/users/{user_id}`

- GET: retrieves information about user with user_id 
- PUT: updates user's information with user_id
- DELETE: deletes user with user_id

`api/users/{user_id}/tasks`: 

- GET all information about tasks beloning to users with user_id 

`api/users/{user_id}/tasks/{task_id}`

- GET: retrieves information about task with task_id
- PUT: updates task's information with task_id
- DELETE: deletes task with task_id
