Prueba Meep Backend Developer
============

Lo primero que hay que hacer es importar la siguiente llamada con el Postman o similar (import →
Paste Raw Text)

```
curl -X GET "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources?
lowerLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-
9.137115&companyZoneIds=545,467,473" -H "accept: application/json"
```

Para darte un poco de contexto, esta llamada sirve para obtener los recursos (moto, bicis, paradas
de bus, metro, ...) disponibles dado un "marco" ```(lowerLeftLatLon=38.711046,-
9.160096&upperRightLatLon=38.739429,-9.137115)``` y una zona (lisboa). Puedes utilizar la
llamada directamente. En este caso también se aplica un filtro (companyZoneIds=545,467,473)
para que sólo devuelva datos de tres empresas de motosharing / carsharing que operan en
Lisboa.

La idea es generar un microservicio con Spring Boot que haga polling cada 1/2 minutos en el
endpoint anterior detectando cambios, es decir nuevos vehículos disponibles y vehículos que
antes estaban disponibles y ahora dejan de estar disponibles.

**Preguntas**

¿Cómo de escalable es tu solución propuesta? 

**Es escalable a cualquier servicio con similares caracteristicas al que se le quiera hacer polling.**

¿Que problemas a futuro podría presentar? 

**Al estar llamando constantemente al servicio del proveedor se generan varios problemas.**
*  **No tendremos los datos en tiempo real, pues hay un margen de 30 segundos en el que no tenemos los datos refrescados.**
*  **Los recursos destinados al rendimiento del servicio se ven afectos, pues al estar llamando constantemente aumentaran los recuros necesarios.**
*  **Dependemos de estar abriendo conexiones cada 30 seg.**


¿Qué alternativa/s propones para solventar dichos problemas?

**Veo varias soluciones con este problema.**
**Si tuvieramos garantizada la conexión con el proveedor 24/7, diria que hicisemos directamente la llamada a proveedor cada vez que queramos utilziar los datos.**
**Esta llamada no relentizaria demasiado la experiencia de usuario ya que el tiempo de respuesta del servicio suele ser 650ms.**

**Pero esa solución solo serviria para consultar los datos y no darles tratamiento, tampoco serviria para llevar un control de los que han cambiado.**
**La opción mas viable seria habilitar un endpoint en el cual nos informe el servicio del proveedor de cada cambio que se produzca, y nosotros localmente actualziariamos la base de datos.**

¿Qué nos gustaría ver?


• Arquitectura
• Uso del framework (Spring) y otras librerías que consideres necesarias
• Estilo de codificación y buenas prácticas
• Llamada al endpoint

Muchas gracias por la entrevista y por tu tiempo.
Saludos!



LLAMADA DE CONSULTA
============

La llamada para la consulta de los datos guardados es:

```
curl --location --request GET 'http://localhost:8899/resources' \
--header 'accept: application/json'
```