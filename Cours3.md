# Spark
- Telecharger Spark depuis le site apache
- tar xzvf spark…
- sbin pour utiliser spark en mode standalone
- pour utiliser un gestionnaire de données : yarn ou kubernetes (pas stable encore)

## Scripts plus importants :
- pyspark et spark-submit
- spark-class est ce qui va lancer le driver de l’executeur (point commun de tous) alors que les autres sont des Wrapper

## UI Spark
- localhost/4040

## Dans spark 2 types d’opérations : 
- Transformations : Juste prise en compte
- Actions : Appliquer à la donnée

## Debut pratique :
- val license = spark.read.textFile(« LICENSE »)
- license.schema
- license
- license.printSchema
- license.show
- license.show(10, false) => Afficher toutes les lignes sans les tronquer
- license.sample(0.1).foreach(println(_)) : Affiche toutes les lignes pour 10% du RDD en se servant d’une fonction anonyme ?

## RDD :
- Résilience : On peut recréer le dataset s’il y a une erreur = > (parent, operation)
- Distribué
- Une partition du RDD c’est un bloc comme ça en cas d’erreur, on va directement chercher le réplicat de la partition

## HDFS / Shuffle
- HDFS : Assez de metadonnées pour effectuer les opérations là où est la donnée
- Shuffle : Lorsque je déplace de la donnée

## Tâche : Opération concrète élémentaire
Dans le job :
- Donnée originale
- On fait les filtrages au tout début
- DAG : Directed Acyclic Graph
- Jobs => Dag (représenation logique du job) => Plusieurs Stages => Plusieurs tâches => Vont s’exécuter sur des Exécuteurs

## Utilisation ou non des Ressource Managers
- Standalone pas assez solide pour être en prod (plutôt Dev / Test)
- Ressource Managers : On peut faire sans mais ca devient vite très compliqué
- Pour passer de standalone à YARN/MESOS => Grace à un Flag
- Mesos : Grosses contraintes de scheduling
- Yarn : HDFS sécurisé => Il faut que le HDFS supporte le MapReduce v1

## Pratique
- Conf spark avec 4 cores : ./bin/spark-shell –-master local[4]

## Fonctionnement Global
- spark-submit : Si Yarn, il le contacte pour lancer un application master
- En lancant un job, essayer d’utiliser le minimum d’espace
- Un Driver => Des Executeurs => Nombre de core par Executeur
- Mémoire nécessaire aux tasks ou dans les Executeurs est dans les RDD
- JVM : RDD, Task, Executeur
- Map Reduce => Aucune task depend de l’autre : La c’est partagé
- Dans le cas d’une jointure, on cache des RDD ce qui est couteux

## Modelisation des donnees
- csv a eviter, pas de typage, pas efficace
- JSON => La taille est trop importante, préférer avro ou parquet
- En Avro, pas de compression normalement (Mais dans notre exemple, snappy aussi)
- En parquet, compression par défaut snappy