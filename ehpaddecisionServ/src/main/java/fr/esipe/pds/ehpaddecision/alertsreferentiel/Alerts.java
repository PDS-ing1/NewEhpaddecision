package fr.esipe.pds.ehpaddecision.alertsreferentiel;
import java.sql.Timestamp;

public class Alerts  {
		private int idAlert;
		private String nameAlert;
		private Timestamp creationDate;
		
		public Alerts(String nameAlert) {
			this.nameAlert = nameAlert;
		}
		
		
		public Alerts() {
			this.idAlert = 1;
			this.nameAlert = "Default Alert";
			
			
		}
		public Alerts(int idAlert, String nameAlert, Timestamp creationDate) {
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
