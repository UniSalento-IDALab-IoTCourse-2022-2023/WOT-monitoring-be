db = connect( 'mongodb://localhost:27017/test' );

db.aggregatedData.insertMany( [
   {
      "_id": ObjectId("64b90bbbbce1d67bd5e1fdc4"),
      "date": ISODate("2023-07-20T10:26:03.874Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 55.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 585,
      "performanceAverageData": 96.5
   },{
      "_id": ObjectId("64b90c00bce1d67bd5e1fdc7"),
      "date": ISODate("2023-07-20T10:27:12.830Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 52,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 574.5,
      "performanceAverageData": 83.5
   },{
      "_id": ObjectId("64b90c32bce1d67bd5e1fdca"),
      "date": ISODate("2023-07-20T10:28:02.540Z"),
      "boilerId": "64ab11356623471faa234a7a",
      "temperatureAverageData": 52.5,
      "pressureAverageData": 3.5,
      "carbonMonoxideAverageData": 639.5,
      "performanceAverageData": 94.5
   }
] )
