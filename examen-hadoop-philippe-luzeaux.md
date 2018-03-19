Examen Hadoop Philippe LUZEAUX

## citez 3 composantes de l’écosystème Hadoop: Décrivez les succinctement, expliquez votre choix

HDFS, YARN, Mesos, Spark

Pour moi ce sont les briques de base d'un système Hadoop pour HDFS Mesos et YARN.
Et les système de calcul distribué le plus efficace pour Spark.

HDFS est un système de fichiers distribués

YARN est un outil de gestion des ressources distribuées multi-clusters. Adopté lors de la version 2 de Hadoop

Mesos est un concurrent de YARN et possède les mêmes fonctions, mais plus récent et plus évolué

Spark est un framework open source de calcul distribué. Il s'agit d'un ensemble d'outils et de composants de traitements big data pour effectuer des analyses complexes à grande échelle.

## Qu’avez vous retenu de HDFS: architecture, fonctionnement, éléments de conception, points fort/faible

HDFS offre une abstraction du stockage de fichiers distribué
Le stockage des fichier se fait en mode block
HDFS offre

- Abstraction du stockage pour faciliter la manipulation des fichiers
- Fiabilité, résilience, disponibilité
- Expose une interface pour optimiser le processing
- Scalabilité


## Qu’avez vous retenu de Spark: architecture, fonctionnement, éléments de conception, points fort/faible

Spark exécute la totalité des opérations d'analyse de données en mémoire et en temps réel.
Il s'appuie sur des disques seulement lorsque sa mémoire n'est plus suffisante.
À l'inverse, avec Hadoop les données sont écrites sur le disque après chacune des opérations.
Ce travail en mémoire permet de réduire les temps de latence entre les traitements, ce qui explique une telle rapidité.
Spark est effectivement beaucoup plus rapide que Hive.

En cas de panne ou de défaillance du système :
les objets de données sont stockés dans ce que l'on appelle des ensembles de données distribués résilients (RDD : resilient distributed datasets)
répartis sur le cluster de données permettant la récupération complète de données.

Il possède un langage de requêtage SparkQL
Spark peut traiter des données en flux avec Spark Streaming


## Peut on faire du spark sans HDFS? et sans YARN?
Oui par exemple en mode standalone sur le file système de sa machine.
On peut utiliser Spark dans trois modes: Standalone, YARN and Mesos
c'est une simple librairie que l'on gère en tant que dépendance d'une application pouvant accéder à son propre fileSystem.

## Quelles sont les differences entre Hadoop v1 et Hadoop v2?

-  Hadoop v1 supporte uniquement MapReduce
-  Hadoop v1 est limité à 4000 noeuds par cluster contre 10 000 pour Hadoop v2
-  Hadoop v1 autorise 1 seul nameNode ce qui constitue un SPOF

-  Hadoop v2 supporte MapReduce mais également d'autres framework de calculs distribués comme Spark
-  Hadoop v2 intègre YARN
-  Hadoop v2 gère plusieurs nameNodes
-  Hadoop v2 gère la haute disponibilité Mode (HA) des Namenodes
-  Hadoop v2 peut gérer jusqu'à 10 000 noeuds par cluster
