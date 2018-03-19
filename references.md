Hadoop/HDFS:

- La reference des livres sur hadoop c'est [Hadoop: The Definitive Guide, 4th Edition ](http://shop.oreilly.com/product/0636920033448.do). C'est une excellente lecture pour faire le tour de l'ecosysteme et comprendre son etat d'esprit.
Certains chapitres sont extremement importants et peu repris dans d'autres ouvrages (hdfs, IO, Input/output Format)

- Sinon le site de hadoop comporte pas mal d'informations de facon concise. Par exemple :
 - Notre premier exercice: http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html
 - Une overview de l'architectre de hdfs: http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/HdfsDesign.html
 - les commandes: http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/HDFSCommands.html et http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/FileSystemShell.html
 - le deploiement en High Availability http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/HDFSHighAvailabilityWithQJM.html
 
 
Spark:
- La documentation sur le site est trés bien faite et assez complete.
- Il n'y a pas beaucoup de bon livre qui traitent la version 2 et les API actuelles de spark. Matei Zaharia viens d'editer un nouveau livre [Spark: The Definitive Guide](http://shop.oreilly.com/product/0636920034957.do) que j'ai pas encore lu.

Sinon il y a les "fondements" de cet ecosystemes et qui sont pour moi des lectures obligatoires:
 - [The Google File System ] (https://research.google.com/archive/gfs.html)
 - [MapReduce: Simplified Data Processing on Large Clusters ] (https://research.google.com/archive/mapreduce.html)
 - [Bigtable: A Distributed Storage System for Structured Data](https://research.google.com/archive/bigtable.html)
 - [Dynamo: amazon's highly available key-value store] (https://s3.amazonaws.com/AllThingsDistributed/sosp/amazon-dynamo-sosp2007.pdf)
 - [Perspectives on the CAP Theorem] (https://groups.csail.mit.edu/tds/papers/Gilbert/Brewer2.pdf)
 - [Mesos: A Platform for Fine-Grained Resource Sharing in the Data Center] (https://people.eecs.berkeley.edu/~alig/papers/mesos.pdf)
 - [Resilient Distributed Datasets: A Fault-Tolerant Abstraction for In-Memory Cluster Computing] (http://people.csail.mit.edu/matei/papers/2012/nsdi_spark.pdf)
 - [Spark SQL: Relational Data Processing in Spark] (https://people.csail.mit.edu/matei/papers/2015/sigmod_spark_sql.pdf)
 - [c10k problem](http://www.kegel.com/c10k.html)
 - [Latency Numbers Every Programmer Should Know] (https://people.eecs.berkeley.edu/~rcs/research/interactive_latency.html)
