# Projet Doodle TCHIASSO Nono Armel - LOMBARD Rudy 4A CFA Classe 41 

Création d'API pour soumettre un sondage aux différents utilisateurs identifiés sur la base, les clients ont la possibilité de créer un sondage en invitant leurs amis enregistrés, en fonction de la date et d'un lieu.

# Architecture Globale
![ARCHITECTURE](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/Architecture1.PNG?raw=true)


# Stack Technique 
![STACK](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/Stack1..PNG?raw=true)

# Lancement du projet

1) Utiliser MySQL WorkBench, le logiciel de gestion et d'administration des bases de données MySQL

2) Créer une base de données sur MySQL WorkBench avec un nom, un username et un password conformes à ce qui sera indiqué dans le fichier application.properties (cf. ci-dessous)

![PROPRIETE](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/Propri%C3%A9t%C3%A9s.PNG?raw=true)

3) SUR UN NAVIGATEUR WEB, TAPER L'URL SUIVANTE : http://localhost:8080/login (si bien-sûr vous utilisez le port 8080 sinon remplacez 8080 par le port choisi)

# Différentes étapes du projet

La première étape pour un utilisateur est de s'identifier

![IDENTIFIACTION](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/Authentification.PNG?raw=true)

Celui-ci peut aussi choisir de se connecter s'il est déjà authentifié.

![CONNEXION](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/connexion.PNG?raw=true)

La page d'accueil se présente ci-dessous, la supression  de l'évènement n'est pas disponible pour le créateur.

![INDEX](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/Index.PNG?raw=true)

Lors de la création d'évènement, l'utilisateur se trouve sur la page ci-dessous.

![EVENT](https://github.com/armelito60/RudyArmel_ProgWeb/blob/master/images/%C3%A9v%C3%A8nement.PNG?raw=true)

# Remarques

Le vote des utilisateurs invités à un évènement et la suppression d'un sondage ne sont pas disponibles.
