# Arbeidskrav: Mail Server using REST API

---

## What is this?
This is a university assignment. The task is to create a REST API for a mail server. The API should be able to create, read, update, and delete. It is not a full-fledged mail server, but a simple API that can be used to create users and retrieve them. Do not use this for anything but educational purposes. Passwords are handled in cleartext and there is no user authentication. To cite tech entusiasts from XDA:
> Your warranty is now void.   
> I am not responsible for bricked devices, dead SD cards, thermonuclear war, or you getting fired because the alarm app failed.   
> Please do some research if you have any concerns about features included in this ROM before flashing it!  
> YOU are choosing to make these modifications, and if you point the finger at me for messing up your device, I will laugh at you. [^xda]

Source: [^xda]: [XDA forums](https://xdaforums.com/t/funny-warnings.1896297/)

Needless to say, this quote is not for __this__ project, but for custom ROMs, but the spirit of the quote still stands as is.

## Assignment text:
<details>
  <summary>
    <b>Term assignment</b>: Mail Server using REST API</h5>
  </summary>
<h4>Spring Boot Mail Server REST API with PostgreSQL</h4>
<h5>Objectives:</h5>
<ol>
  <li>Learn how to set up a Spring Boot application with Maven</li>
<li>Implement RESTful web services with Spring</li>
<li>Use Spring Data JPA to integrate with a PostgreSQL database</li>
<li>Practice designing and implementing database entities and relationships</li>
</ol>

<h5>Requirements:</h5>
<ul>
  <li><strong>Java JDK 20 or above</strong></li>
<li><strong>Maven</strong> (for project management and build)</li>
<li><strong>Spring Boot</strong>(latest stable version)</li>
<li><strong>Spring data JPA</strong></li>
<li><strong>PostgreSQL</strong>(database)</li>
<li><strong>Lombok</strong>(optional, to reduce boilerplate code)</li>
</ul>

<h5>Assignment tasks:</h5>
<ol>
<li><strong>Project setup</strong></li>
  <ul>
    <li>Create a new Spring Boot project using Spring Initializr (https://start.spring.io/). Choose Maven as the build tool and include dependencies for Spring Web, Spring Data JPA, and PostgreSQL driver.</li>
  </ul>
<li><strong>Database configuration</strong></li>
  <ul>
    <li>Install PostgreSQL and create a new database for your application.</li>
<li>Configure your application to connect to the PostgreSQL database by updating <code>application.properties</code> with the correct database URL, username, and password.</li>
  </ul>
<li><strong>Model Definition</strong></li>
  <ul>
    <li>Define (at least) two main entities: <code>User</code> and <code>Email</code>. Consider adding more entities if you want.</li>
<li>Implement the necessary relationships between entities (e.g., one-to-many, many-to-many).</li>
<ul>
  <li>The <code>User</code> entity should include fields like <code>id</code> (primary key), <code>username</code>, <code>email</code>, <code>password</code>.</li>
<li>The <code>Email</code> entity should have fields such as <code>id</code> (primary key), <code>fromEmail</code>, <code>toEmail</code>, <code>subject</code>, <code>body</code>, <code>timestamp</code>.</li>
</ul>
<li>Use JPA annotations to map these entities to your PostgreSQL database tables.</li>
  </ul>
<li><strong>Repository Layer</strong></li>
    <ul>
        <li>Create JPA repositories for each entity to facilitate CRUD operations.</li>
    </ul>
<li><strong>Service Layer</strong></li>
    <ul>
        <li>Implement service classes to encapsulate the business logic for user and email management.</li>
    </ul>
<li><strong>Controller Layer</strong></li>
<ul>
  <li>Develop REST controllers to expose HTTP endpoints for managing users and emails.</li>
<li>Endpoints could include user creation, deletion, update, fetching user details, sending emails, listing received/sent emails, and email deletion.</li>
</ul>
<li><strong>Documentation</strong></li>
<ul>
<li>Document your REST API endpoints using tools like Swagger or Spring Rest Docs</li>
</ul>
</ol>

<h5>Submission Guidelines:</h5>
<ul>
<li>Ensure your code is well-structured, properly commented, and follows Java coding best practices.</li>
<li>Include a <code>README.md</code> file with setup instructions, including how to configure and start the PostgreSQL database, build and run your Spring Boot application, and any other relevant information.</li>
<li>Submit your project as a zip file or provide a link to a Git repository containing your Maven project.</li>
</ul>

<h5>Evaluation Criteria:</h5>
<ul>
<li>Correctness: Application functions according to the requirements.</li>
<li>Database Integration: Effective use of Spring Data JPA with PostgreSQL</li>
<li>Documentation: Clarity and completeness of documentation for using the API and setting up the project</li>
</ul>

<blockquote>Source: <a href="https://usn.instructure.com/courses/33298/assignments/114253?module_item_id=621513">Canvas: OBJ2100 Objektorientert programmering 2 25V Hønefoss </a></blockquote>
</details>

---
## Table of Contents

- Testing the API with Postman or Curl
  - [Create a user `POST`](#create-a-user)
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
<ol>
    <li>Open Postman and create a new HTTPS workspace if you don't already have one</li>
    <li>We want to create a user so choose the <code>POST</code> label under the REST API basics: CRUD, test & variable dropdown menu.</li>
    <li>Enter the URL <code>http://localhost:8080/api/users</code> in the address bar</li>
<li>In the body field, make sure raw JSON is selected.</li>
<li>
  <pre>// Replace John Doe's information with your own.
    <code>
      {
        "username": "john_doe",
        "email": "john_doe@email.com",
        "password": "password"
      }
    </code>
  </pre>
</li>
<li>Press the <code>Send</code> button.</li>
<li>If you see the number <code>200</code> in a toast everything went as expected. If you see something else, something went wrong.</li>
</ol>
</details>

<details>
    <summary>
        Creating a user using URL parameters in the browser bar
    </summary>
    <ol>
        <li>Decide username.</li>
        <li>Decice email</li>
        <li>Decide password.</li>
        <li>Enter the following URL in the browser bar: <code>http://localhost:8080/api/users</code></li>
        <li>Replace the placeholders with your own information. Example: <code>http://localhost:8080/api/users?username=john_doe&email=john_doe@email.com&password=password</code></li>
    </ol>
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
| HTTP method | Endpoint                 | Description              |
|-------------|--------------------------|--------------------------|
| GET         | /api/users               | Retrieve all users       |
| GET         | /api/users/{id}          | Retrieve a user by id    |
| GET         | /api/users/email/{email} | Retrieve a user by email |
| POST        | /api/users               | Create a new user        |
| PUT         | /api/users/{id}          | Update a user by id      |
| DELETE      | /api/users/{id}          | Delete a user by id      |

### Testing the API with Postman or `curl`

#### Create a user
> You might need to add v1 after api. So that
> `localhost:8080/api/users` becomes 
> `localhost:8080/api/v1/users`
> > _«It works on __my__ computer»_  
> 
> > -__-"

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