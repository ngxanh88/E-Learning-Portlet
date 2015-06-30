Entwicklungsumgebung: 	- Eclipse luna mit liferay plugin
			- Tomcat server mit lifaray
			- Vorgegebene Serverkomponente
			- maven Projekt mit liferay plugin

deployen:	- start vorgegebene Serverkomponente
		- sichern, dass competenceServerHost-Name in file 
			config.properties passt
		- config.properties: $project-folder/src/main/resources/config.properties
		- deployen file .war in target-folder in eigene Server mit liferay
		- add Komponenten in liferay