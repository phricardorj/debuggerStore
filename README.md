![Debugger Store](https://i.imgur.com/5C8Sm1M.png "Debugger Store")

**E-commerce RESTful API made by developers for developers**

![Version](https://img.shields.io/badge/Version-1.0-green "Version")
![Stars](https://img.shields.io/github/stars/phricardorj/debuggerStore?style=social "Stars")
![Contributors](https://img.shields.io/github/contributors/phricardorj/debuggerStore?color=#00fd13 "Contributors")

## ⚙️ Technologies

- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)
- [Lombok](https://projectlombok.org/)

## 🗺️ API Documentation

### Authentication to consume API 
![Authentication](https://i.imgur.com/Ui61n8U.png "Authentication")<br>
Application with basic security authentication, default username and password.

### Methods for registering in the Database

1. (POST) `/store/product` - Register a new Product
```Json 
{
  "name": "The Best and Most Complete Book of Java",
  "productQuantity": "500",
  "price": 15
}
```

2. (POST) `/store/customer` - Register a new Consumer
```Json 
{
  "name": "Richard",
  "document": "12638840084"
}
```

3. (POST) `/store/order` - Register a new Purchase Order
```Json
{
   "products":[
      {
         "productCode":"38894d75-35ef-4988-96c7-9ec9c247c50e",
         "productQuantity":20
      }
   ],
   "consumerCode":"27e66321-bd92-4c06-b603-074edfb79810"
}
```

### Methods to get data from the database

#### Get Lists

1. (GET) `/store/product` - List all products
2. (GET) `/store/customer` - List all customers
3. (GET) `/store/order` - List all customers

#### Get information filtered

1. (GET) `/store/product/{productCode}` - Product by {productCode}
2. (GET) `/store/customer/{customerCode}` - Customer by {customerCode}
3. (GET) `/store/order/{documentCustomer}` - Order by {documentCustomer}
