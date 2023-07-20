db = connect( 'mongodb://localhost:27027/test' );

db.user.insertMany( [
   {
      "_id": ObjectId("648dad26d873e0a930bad918"),
      "date": ISODate("2023-06-17T12:55:02.988Z"),
      "name": "Mario",
      "surname": "Bros",
      "email": "mario@nintendo.it",
      "address": "via address",
      "boilerId": "64ab11356623471faa234a7a"
   },{
      "_id": ObjectId("648dad26d873e0a930bad919"),
      "date": ISODate("2023-06-17T12:55:02.988Z"),
      "name": "Luigi",
      "surname": "Bros",
      "email": "luigi@nintendo.it",
      "address": "via address",
      "boilerId": "64ab115056f0596336453f9d"
   },{
      "_id": ObjectId("648dad26d873e0a930bad91a"),
      "date": ISODate("2023-06-17T12:55:02.988Z"),
      "name": "Peach",
      "surname": "Princess",
      "email": "peach@nintendo.it",
      "address": "via address",
      "boilerId": "64ab1172d65d5a1722fde753"
   }
] )


db.boiler.insertMany( [
   {
      "_id": ObjectId("64ab11356623471faa234a7a"),
      "date": ISODate("2023-06-17T12:55:02.988Z")
   },{
      "_id": ObjectId("64ab115056f0596336453f9d"),
      "date": ISODate("2023-06-17T12:55:02.988Z")
   },{
      "_id": ObjectId("64ab1172d65d5a1722fde753"),
      "date": ISODate("2023-06-17T12:55:02.988Z")
   }
] )


db.alarm.insertMany( [
   {
      "_id": ObjectId("64b90bbcbaaa33053b2b6347"),
      "date": ISODate("2023-07-20T10:26:03.911Z"),
      "alarmType": "LOW_WATER_PRESS",
      "boilerId": "64ab11356623471faa234a7a"
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6349"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "alarmType": "PERFORMANCE",
      "boilerId": "64ab11356623471faa234a7a"
   },{
      "_id": ObjectId("64b90bbcbaaa33053b2b6347"),
      "date": ISODate("2023-07-20T10:26:03.911Z"),
      "alarmType": "LOW_WATER_PRESS",
      "boilerId": "64ab115056f0596336453f9d"
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6349"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "alarmType": "PERFORMANCE",
      "boilerId": "64ab115056f0596336453f9d"
   },{
      "_id": ObjectId("64b90bbcbaaa33053b2b6347"),
      "date": ISODate("2023-07-20T10:26:03.911Z"),
      "alarmType": "LOW_WATER_PRESS",
      "boilerId": "64ab1172d65d5a1722fde753"
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6349"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "alarmType": "PERFORMANCE",
      "boilerId": "64ab1172d65d5a1722fde753"
   }
] )


db.aggregatedData.insertMany( [
   {
      "_id": ObjectId("64b90bbcbaaa33053b2b6346"),
      "date": ISODate("2023-07-20T10:26:03.906Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 55.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 585,
      "performanceAverageData": 96.5
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6348"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 52,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 574.5,
      "performanceAverageData": 83.5
   },{
      "_id": ObjectId("64b90c32baaa33053b2b634a"),
      "date": ISODate("2023-07-20T10:28:02.542Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 52.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 639.5,
      "performanceAverageData": 94.5
   },   {
      "_id": ObjectId("64b90bbcbaaa33053b2b6346"),
      "date": ISODate("2023-07-20T10:26:03.906Z"),
      "boilerId": "64ab115056f0596336453f9d",
      "temperatureAverageData": 55.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 585,
      "performanceAverageData": 96.5
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6348"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "boilerId": "64ab115056f0596336453f9d",
      "temperatureAverageData": 52,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 574.5,
      "performanceAverageData": 83.5
   },{
      "_id": ObjectId("64b90c32baaa33053b2b634a"),
      "date": ISODate("2023-07-20T10:28:02.542Z"),
      "boilerId": "64ab115056f0596336453f9d",
      "temperatureAverageData": 52.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 639.5,
      "performanceAverageData": 94.5
   },   {
      "_id": ObjectId("64b90bbcbaaa33053b2b6346"),
      "date": ISODate("2023-07-20T10:26:03.906Z"),
      "boilerId": "64ab1172d65d5a1722fde753",
      "temperatureAverageData": 55.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 585,
      "performanceAverageData": 96.5
   },{
      "_id": ObjectId("64b90c00baaa33053b2b6348"),
      "date": ISODate("2023-07-20T10:27:12.831Z"),
      "boilerId": "64ab1172d65d5a1722fde753",
      "temperatureAverageData": 52,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 574.5,
      "performanceAverageData": 83.5
   },{
      "_id": ObjectId("64b90c32baaa33053b2b634a"),
      "date": ISODate("2023-07-20T10:28:02.542Z"),
      "boilerId": "64ab1172d65d5a1722fde753",
      "temperatureAverageData": 52.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 639.5,
      "performanceAverageData": 94.5
   }
] )
