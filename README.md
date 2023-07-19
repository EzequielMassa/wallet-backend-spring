<h1 align="center">Wallet Backend Documentation</h1>

![Proyecto nuevo](https://github.com/EzequielMassa/wallet-frontend-angular/assets/94617066/da130ae4-73d5-445b-aef9-333e6bb326aa)

<h2>Complete swagger detaileds endpoints documentation:</h2>
http://wallet-v1-env.eba-ipztfzcp.us-east-1.elasticbeanstalk.com/swagger-ui/index.html

<h2>Principales funciones de la api rest:</h2>
<ul>
  <li>
    creacion de nuevos usuarios
  </li>
   <li>
    verificacion de correcto login con credenciales
  </li>
   <li>
    email de recupero de contraseña
  </li>
   <li>
    edicion del perfil del usuario
  </li>
   <li>
    creacion de nuevas cuentas
  </li>
   <li>
    transacciones de cuenta (depositos , pagos , transferencias)
  </li>
</ul>

<h2>Principales caracteristicas tecnicas:</h2>
<ul>
  <li>
    implementacion de patron mvc
  </li>
  <li>
    autenticacion con jwt
  </li>
  <li>
    manejo de errores mediante sus correctas excepciones (http status code + mensaje)
  </li>
  <li>
   modelado de datos mediante DTO
  </li>
  <li>
   validaciones de campos de hibernate
  </li>
  <li>
   relaciones entre tablas
  </li>
  <li>
   custom JPA QUERYS
  </li>
    <li>
   implementacion de java mail sender + thymeleaf para enviar email de solicitud de "password olvidado"
  </li>
    </li>
    <li>
    documentacion de endpoints completa mediante api swagger (con orden)
  </li>
   </li>
    <li>
   desarrollado en Java 17 y Spring Boot 3.0.4
  </li>
</ul>

<h3>Dependencias y otros recursos utilizados:
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
