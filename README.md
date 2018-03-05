# cours-hadoop
**Cours Hadoop SIO 2018** *- notes par Yoannis*


## Structure du cour?
- [ ] Vision de l'écosystème
- [ ] Cas d'usage
- [ ] Critères de sélection
- [ ] Le Datalake


## L'écosystème Hadoop

### HDFS
* Système de fichier distribué
* Abstraction du stockage pour faciliter la manipulation des fichiers (Scalabilité)
* Fiabilité; Résilience; Disponibilité
* Expose une interface pour optimser le processing (intelligence dans GFS avec des métadonnées)


### HBase
* Base de donnée distribuée


### Hive
* Langage de requetage SQL


### YARN *Yet Another Ressource Negociator*
* Gestion de ressources / allocation pour un cluster


### PIG
* ETL, batch


### ~~OOZIE~~
* scheduler


### TEZ
* *TODO*


### MEZOS
* Gestion de ressources


### Zookeeper
* Bon fonctionnement des services entre eux
* Implémente un algorithme de consensus; Permet de gérer certains états de fonctionnement


### Spark
* Engine pour calcule de donnée distribuée (microbatch)


### SparkStreaming
* Spark pour le streaming


### KAFKA
* Permet de contenir les évènements dans une architecture en flux (queue)


### Flume
* Déplacer des quantitées de données (fichiers)


### STORM
* event processing framework


### ~~Impala~~
* Réponse au problème de latence et requêtage de HIVE (SQL compliant) (Framework)
* Sur-coût de RAM (!!!)

### MapReduce
* Implémentation Hadoop de l'algorithme de Google


### Ambari
* Administration graphique du cluster Hadoop


### Slider
* Long running service possible


- - -


### Context **Streaming** ou **Batch**
* Stream -> Peut-être 1% d'erreur mais on obtient une réponse, même si ce n'est pas forcement stable
* Batch -> Réponse précise mais prend du **temps**!


### Comment choisir la configuration de son cluster?
* Voir les minimas
 * Tester sur AWS
* Implémenter les mimas
* La majorité des problèmes résides généralement dans l'achat du matériel qui prend trop de temps


### Combinaisons possibles:
- MapReduce
  - HIVE / Pig
- Spark
  - Spark / SparkSQL / Hive / Pig
- Tez
  - Hive / (Pig?)


### Kerberos
* Protocole de sécurité, reponse sur le principe de tickets (voir Kerberos 5 vMIT)

### Parallélisation **vs** Distribué
- Parallélisé
  - Un même job peut être partagé entre plusieurs proccess mais ces proccess partage un même état (Shared state) -> Beaucou de RAM partagé
- Distribué
  - Job est découpé. Chaque portion peut être exécuté indépendamment des autres.
