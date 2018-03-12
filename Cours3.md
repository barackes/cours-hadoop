# Spark
- Telecharger Spark depuis le site apache
- tar xzvf spark�
- sbin pour utiliser spark en mode standalone
- pour utiliser un gestionnaire de donn�es : yarn ou kubernetes (pas stable encore)

## Scripts plus importants :
- pyspark et spark-submit
- spark-class est ce qui va lancer le driver de l�executeur (point commun de tous) alors que les autres sont des Wrapper

## UI Spark
- localhost/4040

## Dans spark 2 types d�op�rations : 
- Transformations : Juste prise en compte
- Actions : Appliquer � la donn�e

## Debut pratique :
- val license = spark.read.textFile(� LICENSE �)
- license.schema
- license
- license.printSchema
- license.show
- license.show(10, false) => Afficher toutes les lignes sans les tronquer
- license.sample(0.1).foreach(println(_)) : Affiche toutes les lignes pour 10% du RDD en se servant d�une fonction anonyme ?

## RDD :
- R�silience : On peut recr�er le dataset s�il y a une erreur = > (parent, operation)
- Distribu�
- Une partition du RDD c�est un bloc comme �a en cas d�erreur, on va directement chercher le r�plicat de la partition

## HDFS / Shuffle
- HDFS : Assez de metadonn�es pour effectuer les op�rations l� o� est la donn�e
- Shuffle : Lorsque je d�place de la donn�e

## T�che : Op�ration concr�te �l�mentaire
Dans le job :
- Donn�e originale
- On fait les filtrages au tout d�but
- DAG : Directed Acyclic Graph
- Jobs => Dag (repr�senation logique du job) => Plusieurs Stages => Plusieurs t�ches => Vont s�ex�cuter sur des Ex�cuteurs

## Utilisation ou non des Ressource Managers
- Standalone pas assez solide pour �tre en prod (plut�t Dev / Test)
- Ressource Managers : On peut faire sans mais ca devient vite tr�s compliqu�
- Pour passer de standalone � YARN/MESOS => Grace � un Flag
- Mesos : Grosses contraintes de scheduling
- Yarn : HDFS s�curis� => Il faut que le HDFS supporte le MapReduce v1

## Pratique
- Conf spark avec 4 cores : ./bin/spark-shell �-master local[4]

## Fonctionnement Global
- spark-submit : Si Yarn, il le contacte pour lancer un application master
- En lancant un job, essayer d�utiliser le minimum d�espace
- Un Driver => Des Executeurs => Nombre de core par Executeur
- M�moire n�cessaire aux tasks ou dans les Executeurs est dans les RDD
- JVM : RDD, Task, Executeur
- Map Reduce => Aucune task depend de l�autre : La c�est partag�
- Dans le cas d�une jointure, on cache des RDD ce qui est couteux

## Modelisation des donnees
- csv a eviter, pas de typage, pas efficace
- JSON => La taille est trop importante, pr�f�rer avro ou parquet
- En Avro, pas de compression normalement (Mais dans notre exemple, snappy aussi)
- En parquet, compression par d�faut snappy