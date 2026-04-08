import pyspark
from pyspark.sql import SparkSession
from pyspark.sql import Row
appName= "hive_pyspark"
master= "local"

spark = SparkSession.builder \
	.master(master).appName(appName).enableHiveSupport().getOrCreate()

datafile=spark.read.csv("/home/bigdata/Downloads/drakes.csv",header=True)
datafile.show(5)
datafile.write.saveAsTable("drivers_table")




