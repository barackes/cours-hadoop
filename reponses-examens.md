### Citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix
HDFS : système de fichiers distribué créé lors de la première version d'Hadoop, qui crée une abstraction des découpages des fichiers et une résilience du FS
YARN : Yet Another Ressource Negociator, a été introduit lors de Hadoop V2 afin de permettre de lancer d'autres applications que MapReduce sur un cluster Hadoop
SPARK : est une framework de calcul distribué qui effectue tous les traitements en mémoire, peut être déployé seul ou sur un ressource manager (Yarn ou MESOS)

J'ai choisi ces 3 composants car 
* HDFS est le point d'entrée de toute donnée du cluster
* YARN est utile à plusieurs applications sur le cluste hadoop
* SPARK, l'outil de choix pour le traitement de données dans Hadopp

### Qu’avez vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible

1- HDFS fournit une abstraction globale du découpage et de la répartition des fichiers dans le cluster, ainsi il facilite la manipulation des fichiers dans un environnement distribué

2- HDFS offre l'option de réplication des données pour éviter le SPOF 
Partant du principe que les disques tombent en panne souvent et les réseaux ne sont pas fiables, il permet de gagner en fiabilité, ésilience et disponibilité

3- HDFS expose une interface de metadata aux jobs de data processing

4- HDFS est un FS extensible, il est possible d'ajouter des noeuds au cluster et reconfigurer le namenode à cet effet

Points faibles : 
* accès random aus fichiers est long car nécessaire de parcourir tout le fichier
* le NameNode ne peut pas gérer un gros volume de données, mémoire JVM restreinte
* l'attribubtion des blocs se fait indépendement de la taille du fichier, stocker beaucoup de petits fichiers est un anti-pattern

### Qu’avez vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible

Spark est un framework de traitement distribué en mémoire qui repose sur le principe de RDD : Resilient Distributed Dataset, en d'autres termes si un dataset sur un noeud est perdu (un switch tombe), on peut reconstruire de RDD à l'aide du parent et des opérations effectués

Spark repose aussi sur le principe de DAG : Direct Acyclic Graph, principe utilisé par d'autres outils de l'écosystème hadoop (Map Reduce). Toutefois, l'engin DAG de Spark prend en compte toutes les tâches et optimise leurs executions (par exemple : regrouper des maps en un seule tranformation)

Job = DAG = Suite de tâches, les tâches sont regroupées par stage

### Peut on faire du spark sans HDFS? et sans YARN?

Oui, il est possible de faire du Spark sans HDFS en mode standalone, c'est à dire lire des fichiers directement avec Spark ou accéder à une base de données et la requêter à l'aide SparkSQL.

Aussi, on peut aussi faire du Spark sans Yarn en mode standalone ou avec MESOS dans le cas d'un cluster existant.

### Quelles sont les differences entre Hadoop v1 et Hadoop v2?

Hadoop 1 : restreint l'utilisation du cluster hadoop avec un seul engin de traitement MapReduce, Hive/Pig vont utiliser MapReduce pour les jobs

Hadoop 2 : ouvrira l'exploitation du cluster hadoop avec d'autres engins de traitemens tel Tez ou Spark. Ceci est rendu possible grâce à Yarn. 