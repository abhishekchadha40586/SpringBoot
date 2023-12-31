For Hibernate CRUD->
1. Need spring-boot-starter-data-jpa and mysql-connector-j dependencies in maven pom.xml
2. Create DB table in SQL server and give url, username and password in app.properties
3. Command Line App in main function to create new object
4. Create Entity class which maps to table and fields map to columns along with getter/setter 
5. Dao interface which contains structure for DB functions
6. DaoImplementation which contains EntityManager and entityManager functions that do transaction on DB
7. Main program has code to create object, and use daoimp to save in DB