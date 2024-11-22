# IFT 2255 Devoir 1 pour le groupe 38

Le projet MaVille vise à créer une application mobile dédiée à la gestion et à la communication des travaux publics et privés au sein d'une ville. Elle permet aux résidents d'accéder en temps réel aux informations sur les travaux en cours ou à venir dans leur quartier, de signaler des problèmes d'infrastructure, et de soumettre des requêtes pour des interventions spécifiques. L'application envoie également des notifications personnalisées aux utilisateurs concernant les perturbations dans leur zone. De plus, elle facilite la soumission de candidatures par les intervenants pour réaliser les travaux demandés par les résidents, offrant ainsi un espace de collaboration entre les citoyens, les entreprises et la municipalité.

## Organisation du répertoire

Le répertoire `diagrammes` contien les tout diagrammes du projet.

Le fichier `template.html` contien le rapport.

## Implementation de MaVille

### Prérequis
- JDK 8 ou supérieur

### Exécution
1. Trouver le fichier `MaVille.jar` dans le répertoire `implementation`.
2. Exécutez avec `java -jar MaVille.jar`

### Development
- Compilez depuis le répertoire `implementation/src` avec `javac -cp org.json.jar main/*.java`
- Exécutez depuis le répertoire `implementation/src` avec `java -cp .:org.json.jar main.Main` (Linux ou Mac) ou `java -cp .;org.json.jar main.Main` (windows) 
- Compilez le jar depuis le répertoire `implementation/src` avec `jar cfm MaVille.jar MANIFEST.MF main/*.class`

## Prototype de Ma Ville

Ce dépôt contient un prototype simplifié de l'application en Java. Le prototype permet aux résidents de s'inscrire, de se connecter et d'accéder à un menu offrant diverses options liées à la gestion de la ville.

### Prérequis
- Java Development Kit (JDK) 8 ou supérieur

### Installation et exécution
1. Clonez ce dépôt sur votre machine locale.
2. Naviguez vers le répertoire du projet dans votre terminal.
3. Compilez le programme avec la commande : javac Main.java

4. Exécutez le programme avec : java Main
5. Au menu principal, vous pouvez :

-Vous connecter avec l'un des comptes préconfigurés.

-Créer un nouveau compte résident.

-Quitter le programme.

-Après la connexion en tant que résident, vous verrez le menu résident avec les options pour signaler un problème, consulter les travaux, etc.

-Testez chaque option du menu pour vérifier qu'elle affiche le message approprié.

-Utilisez l'option "Retour au menu principal" pour revenir au menu de connexion/inscription.

_Ce prototype n’est qu’une version abrégée du produit recherché. Il n’y a pas de compte prédéfini ce qui vous permet de naviguer à travers les différentes options du menu sans devoir vous enregistrer réellement._
