## Configuration de la base de données PostgreSQL

1. **Créer la base de données**

   Dans votre outil PostgreSQL créer la table "webatrio" :

2. **Config application.properties**

   Renseignez vos informations de connexion :
   * spring.datasource.url=jdbc:postgresql://localhost:5432/webatrio
   * spring.datasource.username=VOTRE_UTILISATEUR
   * spring.datasource.password=VOTRE_MOT_DE_PASSE


## Configuration WebConfig

    Mettre le bon port pour allowedOrigins dans la class WebConfig.java

## Générez une API DOC

    http://localhost:8081/swagger-ui/index.html#/


# Auto-Evaluation

Ce projet a été réalisé en environ 3h15. J’ai développé une API REST en Spring Boot 3.4 avec Java 21, connectée à une base de données PostgreSQL avec une application front sous React.

### Outils et bibliothèques utilisés
1/ Lombok : pour éviter l’écriture manuelle des getters, setters, constructeurs, etc.

2/ springdoc-openapi : pour générer automatiquement la documentation de l’API via Swagger UI.

3/ Axios : pour faire les appels back

### Fonctionnalités implémentées

1/ Création d'une personne : en s'assurant que la personne ait moins de 150 ans.

2/ Ajout d’un emploi à une personne : avec une date de début obligatoire et une date de fin facultative.

3/ Liste des personnes : retour de toutes les personnes enregistrées, triées par ordre alphabétique, avec leur âge et leurs emplois actuels.

4/ Recherche par entreprise : retour de toutes les personnes ayant travaillé dans une entreprise donnée.

5/ Application Web en React : une interface utilisateur a été développée avec React, permettant d’ajouter une nouvelle personne et de lister toutes les personnes enregistrées via l’API.

6/ Intégration CSS : un style de base a été appliqué à la partie formulaire pour l’ajout d’une personne, afin d’améliorer la présentation de l’application.

### Travail partiellement réalisé

Par manque de temps, je n’ai pas pu finaliser la fonctionnalité suivante :

Recherche des emplois d’une personne entre deux dates : le code est partiellement implémenté dans le contrôleur JobController, dans la méthode commentée getJobsByPersonAndDateRange.

Une erreur est survenue au niveau de la méthode findByPersonIdAndStartDateBetweenOrEndDateBetween du PersonRepository, que je n’ai pas eu le temps de corriger dans les délais impartis.

### Ce que j'aurais aimé ajouter avec plus de temps

1/ Tests unitaires : J'aurais aimé ajouter des tests unitaires pour le code, notamment pour le back-end, afin de garantir la robustesse et la qualité du code.

2/ Finalisation du Front-End : Avec plus de temps, j’aurais finalisé le front-end en ajoutant des fonctionnalités telles que la possibilité de filtrer les personnes par date et par entreprise.

3/ Utilisation de composants HTML/CSS/JS purs : J’ai opté pour JSX afin d’optimiser le temps, mais j’aurais préféré utiliser des composants HTML, CSS et JavaScript séparés pour une meilleure structure et performance.

4/ Pagination : J’aurais intégré un système de pagination pour améliorer l'affichage des données lorsque la liste de personnes devient trop longue.

5/ Système de routage : Un système de routage aurait été mis en place pour une navigation plus fluide entre les différentes pages de l'application.

6/ Responsive Design : L’application aurait été rendue responsive en utilisant Flexbox afin d’assurer une bonne expérience utilisateur sur différents appareils et tailles d'écran.

7/ Système de design (ex : Bootstrap) : J’aurais utilisé un framework de design comme Bootstrap pour uniformiser et accélérer la mise en page de l’application, tout en assurant sa cohérence visuelle.

8/ Validation des paramètres : J’aurais ajouté des contrôles sur les paramètres d'entrée pour éviter d'enregistrer des données invalides ou incohérentes dans la base de données.

9/ SonarQube : J'aurais intégré SonarQube pour assurer la qualité du code, identifier les problèmes potentiels et faciliter la maintenance du projet à long terme.

10/ MapStruct : J’aurais mis en place MapStruct pour automatiser la conversion des objets et réduire la complexité du code.

11/ Login : J'aurais ajouté un système de login avec Spring Security/TOKEN

### Points de blocage rencontrés 

1/ Configuration de la base de données : Lors de la configuration de la base de données, mes entités pointaient vers une autre table que celle de webatrio. J'ai mis un certain temps à comprendre que j'avais configuré les accès (URL, mot de passe, nom d'utilisateur) de la base de données dans les variables d'environnement d'un ancien projet, ce qui a causé cette confusion.

2/ Problème avec MapStruct : J’ai rencontré des difficultés lors de la configuration de MapStruct avec Java 21. Le plugin maven-compiler-plugin ne reconnaissait pas la dernière version de MapStruct.