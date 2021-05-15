### To run the app:

- config Jade Framework (see *how -to-install-and-config-jade.md*)
- start **VillainAgent**
	- create a new Run Configuration called *sender* (the name can be changed) 
		- add *-gui -services jade.core.event.NotificationService;jade.core.messaging.TopicManagementService sender:com.company.VillainAgent* as CLI arguments
		- add *jade.Boot* as Main Class
	- run the configuration
- start **DinoAgent** 
	- create a new Run Configuration called *receiver* (the name can be changed) 
		- add *-container -services jade.core.event.NotificationService;jade.core.messaging.TopicManagementService receiver:com.company.DinoAgent* as CLI arguments
		- add *jade.Boot* as Main Class
	- run the configuration
- start **GUIAgent** 
	- create a new Run Configuration called *gui* (the name can be changed)
		- add *-container -services jade.core.event.NotificationService;jade.core.messaging.TopicManagementService gui:com.company.GuiAgent* as CLI arguments
		- add *jade.Boot* as Main Class
	- run the configuration	
	
### GUI


![Screenshot](https://github.com/teofanaenachioiu/Dino-T-Rex-Simulation/blob/main/Dino-T-Rex-Simulation/images/start-game.png)
![Screenshot](https://github.com/teofanaenachioiu/Dino-T-Rex-Simulation/blob/main/Dino-T-Rex-Simulation/images/simulation.png)
