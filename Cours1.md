# HDP Cours 1

## Panorama des outils

- Papiers de Google sur GFS et MapReduce

- HDFS => Système de fichiers distribués

- HBASE 

- Hive => Plus pour les requetes SQL  (DSL => Domain Specific Language)

- PIG => Plus pour scripts type ETL/Batch ; Python… Plus de visibilité sur comment sont stockés les données

- Oozie Scheduler mais qui a mal vieillit (xml uzinagaz…). Similaire : Azkaban, Airflow, Luigi

- Concurrent de YARN (Gestion des ressources) => Mesos 

- TEZ

- Mesos (Gestionnaire de ressources aussi)

- Zookeeper : Algorithme de consensus qui permet de gérer certains états de fonctionnement distribués.

- Spark : Engine de données distribués  (Offre Spark SQL)

- Spark Streaming => ~ pour flux de données

- Kafka : Queue d’evenements

- Flume

- Storm : Framework d’events 

- Impala : Reponse au probleme de latence du requetage de Hive

- Mapreduce : Framework de la donnée

- Ambari : Administration graphique du cluster

- Slider


## HADOOP
- bin : commande
- etc : conf
- lib/lib… : library
- sbin : scripts qui lancent les daemons
- ./hdfs dfs –ls
