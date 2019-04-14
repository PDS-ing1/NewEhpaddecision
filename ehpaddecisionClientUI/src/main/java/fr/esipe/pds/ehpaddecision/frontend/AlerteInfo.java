package fr.esipe.pds.ehpaddecision.frontend;

public class AlerteInfo {
	
		private int id;
		private String name, description;


		public AlerteInfo(){}
		
		
		
		public AlerteInfo(int id, String name, String description){
			this.id =id;
			this.name = name;
			this.description = description;
			
		}
		
		
	
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public String toString(){
			String str;
			if(this.id!= 0 && this.name!= null &&
					
					this.description != null){
				str = "L'alerte est nommé :";
				str += "marque : " + this.name + "\n";
				str += "Est caractérisée par : " + this.description + "\n";
				
				
				
			}
			else{
				str = "Aucune information n'est disponible!";
			}
			return str;
		}
	}
