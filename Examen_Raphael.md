# Citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix

Je fais le choix de ne pas évoquer HDFS et Spark dans cette question vu qu'ils seront évoqués dans
les questions suivantes.

## Element 1 : YARN
YARN (pour "Yet Another Ressource Negociator") est un gestionnaire de ressources pour un cluster Hadoop. 
Il permet de gérer l'allocation des ressources de manière effective. Il se base sur 2 différents daemon,
un tracker de job et un suivi de l'avancement. Il me semblait important d'évoquer cette composante qui 
est très couramment utilisée sur un cluster Hadoop et qui est la principale différence entre Hadoop 1 et
Hadoop 2. On peut se passer d'un gestionnaire de ressource mais cela complique vraiment la tâche.
On peut aussi citer son principal concurrent : MESOS.

## Element 2 : HBASE
HBase est une base de donnée distribuée oritenté colonne qui s'utilise avec le système de fichiers HDFS.
HBase a été développé en s'inspirant des publications de Google sur BigTable. En pratique, HBase utilise 
le filtre de Bloom qui est un test de présence pour ses requêtes. J'ai fait le choix de citer cette composante
car elle offre un certain intérêt quand on veut effectuer des accès Random sur des fichiers car elle offre plus
de rapidité comparé à l'utilisation de HDFS sans HBase.

## Element 3 : MapReduce
MapReduce est un framework d'execution qui est l'implémentation Hadoop de l'algorithme de Google du même nom.
Il permet de décomposer le traitement des jobs en plusieurs étapes afin d'optimiser le traitement parallèle des données.
On peut noter qu'il est possible d'utiliser TEZ à la place de MapReduce

# Qu’avez vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible

HDFS est un système de fichiers distribués. Il permet une abstraction du stockage pour faciliter la manipulation
des fichiers et se caractérise par sa fiabilité, sa résilience, sa disponibilité et sa scalabilité. Il fonctionne en 
exposant une interface pour optimiser le processing des fichiers. Son architecture, de type Master/Worker repose sur un 
NameNode qui gère et expose l'ensemble des métadonnées du système de fichiers mais ne stocke pas la donnée. Il contient notamment
l'état global du cluster, sa topologie, les différents point d'entrée. Il permet de garantir la conistence du cluster. Ce sont les 
DataNodes qui contiennent les données sous forme de blocs qui sont l'unité atomique de gestion des fichiers. En pratique, quand un client
veut ajouter un fichier sur le cluster, il commence par faire une demande au NameNode qui vérifie ses droits et lui renvoie un token avec des informations
telles que des pointeurs vers les DataNodes et les blocs sur lesquels il peut écrire. L'écriture sur les DataNodes se fait de manière
séquentielle. Ainsi, il est en général plus judicieux d'insérer son fichier avec un facteur de réplication 1 puis de le passer à 3 par la suite. 
Le point faible principal repose sur le mode Master/Worker qui fait que le NameNode est un SPOF. Il est possible d'implémenter un secondary
NameNode et c'est ZKFC (similaire à ZooKeeper) qui décidera de qui est actif et passif.

# Qu’avez vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible

Spark est un engine de calcule de données distribuées. Il peut être lancé avec des langages tels que Python (Pyspark) ou R mais le mieux est de l'utiliser avec 
le langage Scala qui est son langage natif. Il y a deux types d'opérations possibles dans Spark : les transformations qui sont juste une prise en compte 
de l'opération et les actions qui sont appliquées à la donnée. Les opérations Spark sont appelés "jobs" et peuvent être représentés de manière logique
sous forme de DAG (Directed Acyclic Graph). Un job se décompose en plusieurs stages qui se décomposent en même en plusieurs opérations atomiques appelées des
tâches. Les tâches s'executent sur des Executors. En pratique, on peut avoir une vision des différents jobs depuis l'interface graphique accessible sur le port 4040.
Spark peut être utilisé sans Ressource Manager ce qu'on appelle le mode Standalone mais ce n'est pas assez solide pour être utilisé en production. On réserve cette option
plutot pour du Dev ou du Test. On peut utiliser un Ressource Manager tel que Yarn ou Mesos grâce à l'ajout d'un flag. L'utilisation de Yarn permet de d'avoir un HDFS sécurisé
mais il faut que le HDFS supporte la version 1 du MapReduce. L'utilisation de Mesos pose des grandes contraintes de scheduling. Un point fort de Spark est la possibilité d'effectuer
des traitements en mémoire pour les accélérer. Spark propose un formattage des données propre se nommant
RDD pour "Resilient Distributed Dataset" qui permet comme son nom l'indique, la résilience dans un environnement de distibution des données. Un des pont faible notable est qu'en effectuant 
une jointure, on met le RDD en cache ce qui est très couteux. Au contraire, le point fort du RDD c'est le fait qu'une partition soit un bloc comme ca en cas d'erreur, on peut directement aller
chercher le réplicat du bloc. On a aussi pu étudier la thématique de la modélisation des données avec la recommendation d'utiliser le format "parquet" qui
utilise par défaut une compression snappy.

# Peut on faire du spark sans HDFS? et sans YARN?

## Spark sans HDFS
Il est en effet possible de faire du spark sans HDFS en l'utilisant dans un mode standalone sans Hadoop. Spark peut en effet lire et processer des données sur d'autres types de systèmes de fichiers
en jouant son role d'engine de calcul de données. Etant donné que Spark n'a pas de layer de stockage, on l'associe en général à un système de fichiers distribué tel que HDFS. Sans HDFS, Spark fait ses calculs
de manière distribuée sur différentes machines sans stockage distribué.


## Spark sans YARN
C'est aussi possible comme évoqué plusieurs fois précédemment avec son utilisation en mode Standalone mais on rappelle que cela n'est pas assez solide pour de la production. Cela
nous servira principalement pour du développement ou du test.

# Quelles sont les differences entre Hadoop v1 et Hadoop v2?

La version 1 de Hadoop était uniquement composée de Hadoop Common, HDFS et MapReduce. La différence majeure avec la version 2 de Hadoop est l'ajout du gestionnaire de ressources YARN décrit 
précedemment.
