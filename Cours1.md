# HDP Cours 1

## Panorama des outils

- Papiers de Google sur GFS et MapReduce

- HDFS => Syst�me de fichiers distribu�s

- HBASE 

- Hive => Plus pour les requetes SQL  (DSL => Domain Specific Language)

- PIG => Plus pour scripts type ETL/Batch ; Python� Plus de visibilit� sur comment sont stock�s les donn�es

- Oozie Scheduler mais qui a mal vieillit (xml uzinagaz�). Similaire : Azkaban, Airflow, Luigi

- Concurrent de YARN (Gestion des ressources) => Mesos 

- TEZ

- Mesos (Gestionnaire de ressources aussi)

- Zookeeper : Algorithme de consensus qui permet de g�rer certains �tats de fonctionnement distribu�s.

- Spark : Engine de donn�es distribu�s  (Offre Spark SQL)

- Spark Streaming => ~ pour flux de donn�es

- Kafka : Queue d�evenements

- Flume

- Storm : Framework d�events 

- Impala : Reponse au probleme de latence du requetage de Hive

- Mapreduce : Framework de la donn�e

- Ambari : Administration graphique du cluster

- Slider


## HADOOP
- bin : commande
- etc : conf
- lib/lib� : library
- sbin : scripts qui lancent les daemons
- ./hdfs dfs �ls
