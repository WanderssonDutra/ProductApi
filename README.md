ProductApi

Description:
      
      An Api that register products with it's information and persists in a database. It has a simple CRUD that has some personalized endpoints to do specific actions.

ProductController endpoints:
      
      GET   /getall: return a list with all the products in the database.
      POST  register a product with the required data.
      PUT   /{sku}: update the product data.
      PUT   /saleprice/{sku}: update the saleprice and the time duration it will have.
Services:

      ProductService:  service that will apply the business rules necessary to the ProductController.

Endpoint demonstration in Postman:

![image](https://github.com/user-attachments/assets/d802696e-9be2-4429-a087-77b431c69679)

Tools and technologies:

      -java 21
      -Spring Boot
      -PostgreSql
      -Jpa/Hibernate
      -Maven


Project Status:

      in Development.

