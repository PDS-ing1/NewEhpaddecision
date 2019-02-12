# PDS
dépôt dédiés au PDS
#Sommaire
- [Préalable]
- [Politique de nommage]
- [Organisation du projet Maven] 
- [Creation de branches pour les evolutions]
- [Git-Eclipse; Eclipse-Git]
- [Generation de l’artefact JAVA : JAR]
- [Scenario de demonstration pour la release 1 (R1)
- [Quelques conseils]

#Prélable
1. La branche master est didiée uniquement pour des "merges".
	Par conséquent, il faut éviter au maximum de modifier directement les fichiers à partir de la branche master, il faut [créer des branches](#creation-de-branches-pour-les-evolutions).
2. Dans certains dossiers, vous trouverez un fichier oneFileIsRequired.txt. Vous pourrez supprimer ces fichiers lorsque le dossier contiendra au moins un autre fichier (par exemple un fichier .java). Si vous supprimez ce fichier .txt et que le dossier devient vide, alors le dossier ne pourra pas être 'commit' ce qui pourra entraîner des erreurs de compilation.
3. N'oubliez pas de faire des "Fetch" et des "Pull" lorsque vous changez de branche.
4. N'oubliez pas de faire des commits réguliers afin que les autres membres du groupe puissent connaitre votre avancement.


#Politique de nommage
- Le nom des variables ainsi que le nom des méthodes seront en anglais
	Chaque classe doit avoir un nom clair et réprésetant.



## Etapes de generation via Eclipse
1. Faites : clic-droit sur le projet Monitrack > Run As > Run Configurations
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



```
#Scenario de demonstration pour la release 1 : R1
1. Lancer la machine virtuelle contenant la base de données de production, si cette dernière ne fonctionne pas essayer de démontrer en local.
2. Mettre dans le code une requete parmi les CRUD puis lancer le programme (ce qui devrait envoyer une requête à la base de données)
4. Refaire l'étape précédente avec plusieurs différentes requetes si necessaire.
5. Aller dans la base de données pour vérifier si les changement ont été reçus
6. Une liste avec tous les noms qui ont été ajoutés précédemment devrait apparaître


#Quelques conseils
- N'hésitez pas de passer vos recherches sur Google pour avoir toutes les informations.
- Consulter le drive pour connaître la spec et les use-cases.
