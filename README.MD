# TravelManagementSystem

## INTRODUCTION
Tourism can be considered as the most favorite pastime. Several travel organizations are available on the web. The people or the tourist select their own Travel Package according to their personal interest. Online Travel Management system is an application that allows travelers to check for flight tickets availability, book a ticket. The traditional method of travel management system is presently in use which involves the use of papers for storing traveller’s information, with this method there is always a long queue, loss of data, incomplete traveller’s information and inaccuracy. An online Travel management system was implemented for accurate and profitable data management.

## Selection of Problem Statement
 The definition of our problem lies in the manual system and a fully automated system.
 
 `Existing System`: The system is very time consuming and lazy. This system is more prone to errors and sometimes the approach to various problems is unstructured.
 
 `Proposed System`: With the advent of latest technology if we do not update our system then our business results in losses gradually with time. The technical systems contain the tools of the latest trend i.e. computers printers, fax, Internet etc. The systems with this technology are very fast, accurate, user-friendly and reliable.

## Definition of Problem Statement
* Travelers can search and book travel ( flights) 
* Pricing will be individualized based on customer preferences
* Suppliers can upload inventory(airlines)

It includes the following Actor-wise functionalities.

## Actor-wise Functionalities: 
| Traveler | Inventory Supplier | Rating | Ticket Generation | Manager(Admin) |
| -------- | ------------------ | ------ | ----------------- | -------------- |
|Can Signup and Signin.|Can Signup and Signin.|Ratings option will be given after successful Booking.|Tickets will be printed with the Price based on Customer preferences.|Has the authority to control the entire application.|
|Search and Book Travel.|Can upload inventory for Travelers.|-|-|Can manage data.|
|View recently booked ticket.|-|-|-|-|

## System Requirement: 
`Operating System`: Platform Independent.

`Concept Used`: Java and Swings, MySQL Database .

`Development environment/tools`: INTELLIJ IDEA and WampServer.

## UML Diagrams
<div style="text-align:center">
    <img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/UML%20case.png">
</div>

## JAVA Class Diagram
<div style="text-align:center">
    <img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/UML%20class.svg">
</div>

## GUI Design

| `Splash Screen` | `Home Page` |
| ------------- | ----------------- |
|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/Splash.jpeg">|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/Home.jpeg">|


| `Admin Login` | `Admin Dashboard` |
| ------------- | ----------------- |
|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/adminLogin.jpeg">|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/admin.jpeg">|


| `View from both Customer and Inventory supplier Information` | `View from both Customer and Inventory supplier Information` |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/search.jpeg">|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/view.jpeg">|


| `Suppliers & Customer Signup` | `Suppliers & Customer Login` |
| ------------- | ----------------- |
|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/customerSignup.jpeg">|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/customerLogin.jpeg">|


| `Suppliers Inventory` | `Customer Booking` |
| ------------- | ----------------- |
|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/Add.jpeg">|<img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/Book.jpeg">|


### `Flight Booking Process`
![Basic_Layout](https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/bookTicket.gif)


### `Database Table`
<div style="text-align:center">
    <img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/dbAdmin.jpeg">
    <img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/dbCustomer.jpeg">
    <img src="https://github.com/KVM-Projects/TravelManagementSystem/blob/main/xfiles/dbSupply.jpeg">
</div> 
