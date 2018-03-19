# Spark
### Qu'est-ce que Spark dans l'environnement Hadoop?

YARN amene à Spark les ressources à utiliser?

## Exploration de Spark
Téléchagement de Apache Spark 2.3.0 pre-built for Hadoop 2.7


Principales API en Scala. Surtout ne pas faire du Java pour Spark.

dans /bin/ nous trouvons trois binaires important:

- pyspark -> Lance un environement spark en Python
- spark-shell -> Lance un environement spark en Scala
- spark-submit -> Lance un envrionnement pre-packagé (utilisation pour prod)


On va set une variable pour s'amuser:
```
val license = spark.read.textFile("LICENSE")
```

On va ensuite ce qui constitue cette valeur:

```
license.schema
license
license.printSchema
```


On va regarder dans cet élément:
```
lisence.show
lisence.show(20,false) => Que 20 lignes, sans tronquer.
```

Fonction un peu plus avancée:
```
license.sample(0.1).foreach(println(_)) 
```

Nous permet de sampler un gros dataset.

Avec les RDD on utilise pas mal de fonctions annonymes (lambda). C'est déconseillé avec les DataFrames.

## RDD *- Resilient Distributed Dataset*
Deux caractéristiques RDD:
### Résilient
On peut la regénéré en cas d'erreure 
### Distribué
Est distribué sur plusieurs Datanodes (de base avec HDFS)


### Job? Stage? Tâche? Executor?
Un "Job" va prendre le Dataset et faire une opération, représenté par un DAG (représentation logique). Il est constitué de "Stages".

Un "Stage" c'est la ou on a les déplacement de donnée (map / shuffle).

Les "Tâches" sont les opération élémentaires sur les données (peut regroupper plusieurs tâches élémentaires). Vont avoir des Exécutors qui vont durer toute la vie de la JVM/

Les "Executors" permetent de faire du scheduling des jobs et de gérer les ressources associées


Pourquoi être partitionné? Car si une partition tombe on peut reconstituer facilement la partition.

Les RDD peuvent être mis en cache (de plusieurs manières). Le mieux c'est de cacher les choses lourdes au niveau processing.


Utiliser le standalone quand on dev ou test. En générale en fait du YARN en production.


### Configuration Spark
Les configurations les plus importantes ont des alias !!!


### Autres
En environement de production, Spark vérifie que la sortie n'existe pas avant de lancer tous les process.

Faire attention que notre algo ne créent pas un skew sur les données.


**Avro vs Json**
> Compression! 1M vs 7M avec l'exemple utilisé en cours

Sinon utiliser Parquet! utilise de la compression de base (ie. snappy)
