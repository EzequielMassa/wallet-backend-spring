<h1 align="center">Wallet Backend Documentation</h1>

![Proyecto nuevo](https://github.com/EzequielMassa/wallet-frontend-angular/assets/94617066/da130ae4-73d5-445b-aef9-333e6bb326aa)

<h2><a href="https://wallet-emdev.web.app/" target="blank">🚨 Live Demo</a></h2>

<h2>Complete swagger detaileds endpoints documentation:</h2>
https://wallet-render-ev4v.onrender.com/swagger-ui/index.html

<h2>Main functions of the rest api:</h2>
<ul>
  <li>
    creation of new users
  </li>
   <li>
    verification of correct login with credentials
  </li>
   <li>
    password recovery email
  </li>
   <li>
  edit user profile
  </li>
   <li>
   creation of new accounts
  </li>
   <li>
    account transactions (deposits, payments, transfers)
  </li>
</ul>

<h2>Main technical characteristics:</h2>
<ul>
  <li>
    mvc pattern implementation
  </li>
  <li>
    authentication with jwt
  </li>
  <li>
    error handling through its correct exceptions (http status code + message)
  </li>
  <li>
   data modeling using DTO
  </li>
  <li>
   hibernate field validations
  </li>
  <li>
 relationships between tables
  </li>
  <li>
   custom JPA QUERYS
  </li>
    <li>
implementation of java mail sender + thymeleaf to send "forgotten password" request email
  </li>
    </li>
    <li>
    complete endpoints documentation via swagger api (with order)
  </li>
   </li>
    <li>
  developed in Java 17 and Spring Boot 3.0.4
  </li>
</ul>

<h3>Dependencies and other resources used:
</h3>
<ul>
    <li>
    spring-boot-starter-data-jpa
  </li>
     <li>
   spring-boot-starter-security
  </li>
       <li>
   spring-boot-starter-web
  </li>
    <li>
  spring-boot-starter-validation
  </li>
    <li>
    mysql-connector
  </li>
      <li>
   lombok
  </li>
  <li>
   io.jsonwebtoken<
  </li>
       <li>
 springdoc-openapi-starter-webmvc-ui
  </li>
      <li>
springdoc-openapi-starter-webmvc-api
  </li>
         <li>
spring-boot-starter-mail
  </li>
      <li>
spring-boot-starter-thymeleaf
  </li>
</ul>
