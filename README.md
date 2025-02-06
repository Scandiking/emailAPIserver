# Arbeidskrav: Mail Server using REST API

---

## What is this?
This is a university assignment. The task is to create a REST API for a mail server. The API should be able to create, read, update, and delete. It is not a full-fledged mail server, but a simple API that can be used to create users and retrieve them. Do not use this for anything but educational purposes. Passwords are handled in cleartext and there is no user authentication.  

---
## Table of Contents

- Testing the API with Postman or Curl
  - Create a user `POST`
  - Retrieve all users `GET`  
    - Go to [/api/v1/users](/api/v1/users)
  - Retrieve a user by id `GET`  
    - Go to [/api/v1/users/1](/api/v1/users/1) (replace 1 with the ID)
  - Retrieve a user by email `GET`
  - Update user `PUT`
  - Delete user `DELETE`
- Explanation of endpoints

---

### Create a user
<details>
    <summary>
        Creating a user using Postman
    </summary>
    <p>Text</p>
</details>

<details>
    <summary>
        Creating a user using the browser bar
    </summary>
    <p>Text</p>
</details>


### Retrieve all users
<details>
    <summary>
        Retrieve all users using Postman
    </summary>
    <p>Text</p>
</details>

<details>
    <summary>
        Retrieve all users using the browser bar
    </summary>
    <p>Text</p>
</details>

### Retrieve a user by id

### Retrieve a user by email

### Update user

### Delete user

### Explanation of endpoints
| HTTP method | Endpoint        | Description        |
| - |-----------------|--------------------|
| GET | /api/users      | Retrieve all users |
| GET | /api/users/{id} | Retrieve a user by id |
| GET | /api/users/email/{email} | Retrieve a user by email |
| POST | /api/users     | Create a new user |
| PUT | /api/users/{id} | Update a user by id |
| DELETE | /api/users/{id} | Delete a user by id |

### Testing the API with Postman or `curl`

#### Create a user
> You might need to add v1 after api. So that
> `localhost:8080/api/users` becomes 
> `localhost:8080/api/v1/users`

```code
POST http://localhost:8080/api/users
Content-Type: application/json

{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "securepass"
}
```

#### Retrieve all users
```code
GET http://localhost:8080/api/users
```

#### Retrieve a user by id
```code
GET http://localhost:8080/api/users/1
```

#### Retrieve a user by email
```code
GET http://localhost:8080/api/users/email/john@example.com
```

#### Update User
```code
PUT http://localhost:8080/api/users/1
Content-Type: application/json

{
    "username": "john_doe",
    "email": "john_new@example.com",
    "password": "password123"
}
```

#### Delete User
```code
DELETE http://localhost:8080/api/users/1
```