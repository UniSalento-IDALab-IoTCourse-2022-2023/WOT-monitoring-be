db = connect( 'mongodb://localhost:27027/test' );

db.user.insertMany( [
   {
      "_id": ObjectId("648dad26d873e0a930bad918"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z"),
      "name": "Mario",
      "surname": "Bros",
      "email": "mario@nintendo.it",
      "address": "via address",
      "boilerId": ObjectId("64ab11356623471faa234a7a")
   },{
      "_id": ObjectId("648dad26d873e0a930bad919"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z"),
      "name": "Luigi",
      "surname": "Bros",
      "email": "luigi@nintendo.it",
      "address": "via address",
      "boilerId": ObjectId("64ab115056f0596336453f9d")
   },{
      "_id": ObjectId("648dad26d873e0a930bad91a"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z"),
      "name": "Peach",
      "surname": "Princess",
      "email": "peach@nintendo.it",
      "address": "via address",
      "boilerId": ObjectId("64ab1172d65d5a1722fde753")
   }
] )


db.boiler.insertMany( [
   {
      "_id": ObjectId("64ab11356623471faa234a7a"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z")
   },{
      "_id": ObjectId("64ab115056f0596336453f9d"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z")
   },{
      "_id": ObjectId("64ab1172d65d5a1722fde753"),
      "CreatedDate": Date("2023-06-17T12:55:02.988Z")
   }
] )