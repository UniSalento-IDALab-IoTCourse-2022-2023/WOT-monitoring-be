// drop di "gateway"
db = connect( 'mongodb://localhost:27017/test' );
db.dropDatabase()

// drop di "monitoringbe"
db = connect( 'mongodb://localhost:27027/test' );
db.dropDatabase()