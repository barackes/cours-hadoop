# Notes complémentaires

## 27.02.2018

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


## 05.03.2018


### Parallélisation **vs** Distribué
- Parallélisé
  - Un même job peut être partagé entre plusieurs proccess mais ces proccess partage un même état (Shared state) -> Beaucou de RAM partagé
- Distribué
  - Job est découpé. Chaque portion peut être exécuté indépendamment des autres.
