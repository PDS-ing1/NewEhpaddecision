package fr.esipe.pds.ehpaddecision.principales;
import java.sql.Timestamp;

import fr.esipe.pds.ehpaddecision.enumerations.SensorType;

public class Alert  {
		private int idAlert;
		private String nameAlert;
		private Timestamp creationDate;
		private SensorType sensorType;
		
		public SensorType getSensorType() {
			return sensorType;
		}


		public void setSensorType(int sensorId) {
			this.sensorType = SensorType.valueFrom(sensorId);
		}


		public String getTypeAlert() {
			return typeAlert;
		}


		public void setTypeAlert(String typeAlert) {
			this.typeAlert = typeAlert;
		}
		private String typeAlert;
		
		public Alert(String nameAlert) {
			this.nameAlert = nameAlert;
			this.creationDate = new Timestamp(System.currentTimeMillis());
		}
		
		
		public Alert() {
			this.idAlert = 1;
			this.nameAlert = "Default Alert";
			
			
		}
		public Alert(int idAlert, String nameAlert, Timestamp creationDate) {
			this.idAlert = idAlert;
			this.nameAlert = nameAlert;
			this.creationDate = creationDate;
		}
		public int getIdAlert() {
			return idAlert;
		}
		public void setIdAlert(int idAlert) {
			this.idAlert = idAlert;
		}
		public String getNameAlert() {
			return nameAlert;
		}
		public void setNameAlert(String nameAlert) {
			this.nameAlert = nameAlert;
		}
		public Timestamp getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Timestamp creationDate) {
			this.creationDate = creationDate;
		}
		@Override
		public String toString() {
			return "Alerts [idAlert=" + idAlert + ", nameAlert=" + nameAlert + ", creationDate=" + creationDate + "]";
		}

}
