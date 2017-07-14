# Salon Management Software

#### By Laura Hamilton

## Description

This application is a demonstration of CRUD - creating, reading, updating, and destroying Java objects that exist as a one-to-many relationship within a database. The page will allow users to create new stylists on a salon management page, add service details to that stylist, view all the stylists that were created, add new clients with contact details to those stylists, view all clients assigned to a stylist, update a stylist's services, update a client's contact information, and delete any record of a stylist or client.

## Code Specs

|Behavior - Plain English|Input|Output|
|---|---|---|
|On the homepage, a user adds a stylist using the "Add A Stylist" field and button and they are taken to a success page that tells them the stylist was added and gives them the option to go back to the homepage|User enters "Stylist 1" in the "Name" field and adds "Haircuts" in the "Services" field |The user is taken to a success page letting them know the stylist was added|
|On the success page for a stylist addition, the user clicks on the "Back To The Stylist List" link and is taken back to the homepage where the stylist they just added is listed|User clicks on "Back To The Stylist List" after adding a stylist called "Stylist 1"|The user is taken to the homepage and sees Stylist 1 listed as a stylist|
|On the homepage, a user clicks on the name of a stylist and is taken to a page where they can see a list of the clients assigned to that stylist, if any have been added already, and use a field to add additional clients to that stylist|User clicks on "Stylist 1"|The user is taken to the Stylist 1 page and a they see a blank list of clients and a field to add clients to that stylist|
|On a stylist page, a user adds a client to the stylist using the "Add A Client" field and button after filling out the name and email field and they are taken to a success page that tells them the client was added and gives them the option to go back to the homepage|User enters "Client A" in the "Add A Client" field|The user is taken to a success page letting them know the client was added|
|On the success page for a client addition, the user clicks on the "Back To The Stylists List" link and is taken back to the homepage where the stylist they just added a client to is listed|User clicks on "Back To The Stylists List" after adding a client called "Client A"|The user is taken to the homepage and sees Stylist 1 still listed as a stylist|
|On a stylist page, a user clicks on the "Delete This Client" button below "Client 1" and are taken to a success page that tells them the client was deleted and gives them the option to go back to the homepage|User clicks on a "Delete This Client" button next to a client name|The user is taken to a success page letting them know the client was deleted|
|On the homepage a user clicks on the "Delete This Stylist" button below the stylist's name and are taken to a success page that tells them the stylist was deleted and gives them the option to go back to the homepage|User clicks on a "Delete This Stylist" button below the "Stylist 1" name|The user is taken to a success page letting them know the stylist was deleted|

## Setup

This application uses a database, so begin by creating this database using the following commands:




Once the table is set up, clone this repository. Run it through the terminal with the command $ gradle run. Once running, follow the listening path provided through the terminal and view it through your browser in localhost:
(Note: you must have the right programs installed on your computer already to run the program. Please refer to the Technologies Used section below for the program list)

## Technologies Used

Java
Gradle
JUnit
Spark
VelocityTemplateEngine

### Legal

Copyright (c) 2017 Laura Hamilton laurahamilton9@gmail.com

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
