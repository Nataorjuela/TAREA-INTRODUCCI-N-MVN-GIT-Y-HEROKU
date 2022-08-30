# TAREA-INTRODUCCI-N-MVN-GIT-Y-HEROKU

Su compañía lo ha seleccionado para construir una aplicación que demuestre una simple arquitectura de Microservicios desplegada en Heroku para uno de los clientes más importantes.

Así, han decidido que usted debe construir una aplicación para consultar el mercado de valores de las acciones negociadas en Bolsa.La aplicación recibirá el identificador de una acción, por ejemplo “MSFT” para Microsoft  y deberá mostrar el histórico de la valoración intra-día, diaria, semanal y mensual. Para esto utilice el API gratuito de https://www.alphavantage.co/documentation (Puede crear una cuenta para obtener la llave para realizar consultas). Se le pide que su implementación sea eficiente en cuanto a recursos así que debe implementar un Caché que permita evitar hacer consultas repetidas al API externo. Finalmente se le pide que muestre como se puede enlazar con otro proveedor de servicios, en este caso utilice llamados como los siguientes (https://api.polygon.io/v1/open-close/AAPL/2020-10-14?adjusted=true&apiKey=*) y revisé la documentación en https://polygon.io/docs/stocks/getting-started.

*La arquitectura debe tener las siguientes características:*

1.El cliente Web debe ser un cliente asíncrono que use servicios REST desplegados en Heroku y use Json como formato para los mensajes.
2.El servidor de Heroku servirá como un gateway para encapsular llamadas a otros servicios Web externos.
3.La aplicación debe ser multiusuario.
4.Todos los protocolos de comunicación serán sobre HTTP.
5.Los formatos de los mensajes de intercambio serán siempre JSON.
6.La interfaz gráfica del cliente debe ser los más limpia y agradable posible solo HTML y JS (Evite usar librerías complejas). Para invocar métodos REST desde el cliente usted puede utilizar la tecnología que desee.
7.Debe construir un cliente Java que permita probar las funciones del servidor fachada. El cliente utiliza simples conexiones http para conectarse a los servicios. Este cliente debe hacer pruebas de concurrencia en su servidor de backend.
8.La fachada de servicios tendrá un caché que permitirá que llamados que ya se han realizado a las implementaciones concretas con parámetros específicos no se realicen nuevamente. Puede almacenar el llamado como un String con su respectiva respuesta, y comparar el string respectivo. Recuerde que el caché es una simple estructura de datos.
9.Se debe poder extender fácilmente, por ejemplo, es fácil agregar nuevas funcionalidades, o es fácil cambiar el proveedor de una funcionalidad.
10.Debe utilizar maven para gestionar el ciclo de vida, git y github para almacenar al código fuente y heroku como plataforma de producción.
