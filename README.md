# Movie Project - Revamp


MovieMicro Service , MovieTicket Service 

   change API link to localhost.
   
   Mongo DB:
     -> use quinbay
     ->db.createCollection('MovieTicket')
     ->db.createCollection('Movie')
     
     
     
HistoryManagement,UserMicroServices
UserMicroServices
postgres:
  \c quinbay
  create table Userlogin(userId text,username text,phonenumber text primary key,password text,role text);


HistoryManagement
MongoDB:
    use quinbay
  >db.createCollection(historyManagement)
