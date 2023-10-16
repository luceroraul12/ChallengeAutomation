# ChallengeAutomation
## Base de datos
Se crea script **challenge-automation.sql** utilizando un motor de base de datos postgresql que se encuentra en /ChallengeAutomation/src/main/resources/database/challenge_automation.sql
### Creación
- Creacion de base de datos: test
- Creación de tablas:
-   tipo_producto
-   producto
-   stock (Cada producto por defecto viene con una cantidad por defecto de 0)
  ### Triggers
-   Al crear un producto, crea su instancia en la tabla de stock y delegar la funcionalidad a la base de datos
-   Al eliminar un producto, elimina su instancia de la tabla de stock para no tener problemas de contratos de llaves foraneas y delegar la funcionalidad a la base de datos
  ### Datos de ejemplo
-   Agrego tipo de productos de ejemplos
-   Agrego productos de ejemplo
## Backend: Java + Spring Boot + Hibernate(Jpa Repository)
- ABM de productos
- Actualización de stock de productos
- Recuperar la lista de tipos de productos
- Recuperar lista de productos
- Recuperar lista de stock
