class sqlconnjdbc(config:Config){
  val checkflags:String ="sink.db.flgstbl"
  val jdbc:String= config.getString("sink.db.jdbc_url")
  val dbname:String=config.getString("sink.db.dbname")

  def truncTbl(table:String):String={
    "Truncate table"+table+";" }

  def getTableCols(table:String,connection:Connection):List[String]={
    val colstartIndex=1
    val querystmnt=s"Select top 0* from $table"
    val resultMetadata=connection.createStatement().executequery(statement).getMetadata
    println("Metadata"+resultMetadata)
    val coltofilter = List("TO ADD")
    (colstartIndex to resultMetadata.getColumnCount).toList.map(resultSetMetaData.getColumnName).filterNot(coltofilter.contains(_)
                                                                      }
    def checktopush(stmnt:Statement, procname:String):Boolean={
      val querystmnt2 = "select flag from" + checkflags + "where tablename =''metrics''"
      val result:ResultSet=stmnt.executeQuery(querystmnt2)
      if(result.next() && result.getInt("Flag")==1) false else true
    }
                                                                                                           
     def pushMetricsdirectly(metricsDF:DataFrame , countz:Integer):Unit={
       val sqltbl = config.getString("sink.db.sink_tbl")
       val finaldf=metrics.withColumn("status","loading")
       val Decimal_formatting=List("amountz","grossingpresentingvalue")

       val modifiedlist=finaldf.columns.map(column=>{if(Decimal_formatting.cntains(column.toLowerCase)) col(column).cast(DecimalType(30,2))
      else col(column)
                                                    })
