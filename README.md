   ![EHPAD Decision](https://github.com/PDS-ing1/PDS/blob/master/Ehpaddecision.png)
   
# EHPADDECISION

## Sommaire
- [Pralable](#Préalable)
- [Projet](#Projet)
	- [Politique de nommage] (#Politique-de-nommage)
	- [Organisation du projet Maven] (#Organisation-du-projet-Maven)
	- [Git-Eclipse; Eclipse-Git] (#Etapes-de-generation-via-Eclipse -(l-'-outil-utilisé)) 
	- [Generation de l’artefact JAVA : JAR] (#Generation de l'artefact JAVA: JAR)
- [Scenario de demonstration pour la release 1 ] (#Release-1)
- [Scenario de demonstration pour la release 2 ] (#Release-2)
- [Quelques conseils]

## Prélable
1. La branche master est didiée uniquement pour des "merges".
	Par conséquent, il faut éviter au maximum de modifier directement les fichiers à partir de la branche master, il faut [créer des branches] (#creation-de-branches-pour-les-evolutions).
2. Dans certains dossiers, vous trouverez un fichier oneFileIsRequired.txt. Vous pourrez supprimer ces fichiers lorsque le dossier contiendra au moins un autre fichier (par exemple un fichier .java). Si vous supprimez ce fichier .txt et que le dossier devient vide, alors le dossier ne pourra pas être 'commit' ce qui pourra entraîner des erreurs de compilation.
3. N'oubliez pas de faire des "Fetch" et des "Pull" lorsque vous changez de branche.
4. N'oubliez pas de faire des commits réguliers afin que les autres membres du groupe puissent connaitre votre avancement.

## Projet:

## Politique de nommage
- Le nom des variables ainsi que le nom des méthodes seront en anglais
	Chaque classe doit avoir un nom clair et réprésetant.

## Organisation du projet Maven
- le projet contient différents branches, dans le src/main/java on trouve les classes suivantes: 
	App, DataSource, JDBCConnection ces classes permettent de créer un pool de connexion. 
	Fichier pom contient la configuratin du projet. 
	


## Etapes de generation via Eclipse (l'outil utilisé) 
 Artifact Maven est une classe Java qui représente le type de "nom" qui est déréférencé par un gestionnaire de référentiel dans un artefact de gestionnaire de référentiel. Lorsqu'il est utilisé dans ce sens, un Artifact est simplement un nom glorifié composé de parties telles que groupId , artifactId , version , scope , classifier et ainsi de suite.
1. Faites : clic-droit sur le projet EHPADDECISION > Run As > Run Configurations
2. Dans la fenêtre qui va s'ouvrir et dans la partie Maven Build, sélectionnez le module que vous voulez générer
3. Dans la partie goals, y écrire :
```
assembly:single
---- A ne pas oublier
1.Assurez-vous d'avoir cette partie de code xml dans le fichier pom.xml du module que vous allez exporter au format .jar
```xml
<build>
	<plugins>
		<plugin>
			<artifactId>maven-assembly-plugin</artifactId>
			<configuration>
				<archive>
					<manifest>
						<mainClass>[package de la classe contenant la méthode main].[nom
							de la classe contenant la méthode main]</mainClass>
					</manifest>
				</archive>
				<descriptorRefs>
					<descriptorRef>jar-with-dependencies</descriptorRef>
				</descriptorRefs>
			</configuration>
		</plugin>
	</plugins>
</build>
Pour le moment actuel (mardi 12/02/2019 la generation du fichier jar ne fonctionne pas, cela du au paramètrage. 
Scanning for projects.../
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.330 s
[INFO] Finished at: 2019-02-12T15:41:14+01:00
[INFO] Final Memory: 8M/245M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-assembly-plugin:2.2-beta-5:single (default-cli): Goal requires a project to execute but there is no POM in this directory (D:\Divers\PdsIng1\Pds2018-2019\target\generated-sources). Please verify you invoked Maven from the correct directory. -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
  http://cwiki.apache.org/confluence/display/MAVEN/MissingProjectException


```
## Scenario de demonstration pour la release 1 : R1
1. Lancer la machine virtuelle contenant la base de données de production, si cette dernière ne fonctionne pas essayer de démontrer en local.
2. Mettre dans le code une requete parmi les CRUD puis lancer le programme (ce qui devrait envoyer une requête à la base de données)
4. Refaire l'étape précédente avec plusieurs différentes requetes si necessaire.
5. Aller dans la base de données pour vérifier si les changement ont été reçus
6. Une liste avec tous les noms qui ont été ajoutés précédemment devrait apparaître

## Quelques notes pour la release 2 : R2


- On peut tracker les bandes passantes et les flux qui traversent les canaux TCP. Le monitoring peut être fait à l'aide de WireShark. On peut savoir aussi ce que ces bandes contiennent (texte, image..).
- 


## Quelques conseils
- N'hésitez pas de passer vos recherches sur Google pour avoir toutes les informations.
- Consulter le drive pour connaître la spec et les use-cases.
- Des modifications ont eu lieu lors de la première release de la R2. [politique de nommage a été rediscuté, tous les fichiers de config sont nommés en miniscule, suppression des noms clés tels que Interfarce, thread]
- 


 ![EHPAD Decision](https://github.com/PDS-ing1/PDS/blob/master/Ehpaddecision.png)
 
 

