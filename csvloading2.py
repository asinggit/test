
val table: String = config.getString("sink.db.tbl")
val files: String = config.getString("source.file")
df= spark.read.csv(
    files, 
    header=True, 
    mode="DROPMALFORMED", 
    schema=schema
)

df.write.saveAsTable("table1")
