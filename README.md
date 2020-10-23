# EJERCICIO

 ### Aplicación para la creación de usuarios:
    - Nombre: Katherine Candia
    - Fecha: 24-10-2020
 
 ### Detalles de compilación y ejecución:
 - Tener JDK 1.8
 - Tener instalado "H2 Database Engine" (https://www.h2database.com/html/main.html).
 - Recargar las librerías externas de Gradle.
 - Tener instalado Postman.
 
 1. Se debe levantar este proyecto como Aplicación de SpringBoot:
 Dentro del proyecto se ejecuta el siguiente comando: gradle bootRun
 
 Una vez que se haya levantado, en postman debe ingresar:
 - localhost:8080/guardarUsuario como POST
 - Se agrega el siguiente texto cómo formato JSON:
 
 {
     "name" : "Juan Rodriguez" ,
     "email" : "juan@rodriguez.org" ,
     "password" : "Hunter22" ,
     "phones" : [
         {
         "number" : "1234567" ,
         "citycode" : "1" ,
         "contrycode" : "57"
         }
     ]
 }
 
 -Una vez que se ejecute, se puede mostrar el resultado o un mensaje de error:

*Caso exitoso:

{
    "idLogin": 3,
    "created": "2020-10-23T21:37:06.177+00:00",
    "modified": "2020-10-23T21:37:06.177+00:00",
    "last_login": "2020-10-23T21:37:06.177+00:00",
    "token": "a46e3715-d185-4651-b342-5db5e8430621",
    "isActive": true,
    "usuario": {
        "id": 1,
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "Hunter22",
        "phones": [
            {
                "id": 2,
                "number": 1234567,
                "cityCode": null,
                "countryCode": null,
                "usuario": null
            }
        ],
        "login": null
    }
}

* Caso erróneo:
{
    "mensaje": "El email del usuario no tiene el formato correcto"
}
 
 

