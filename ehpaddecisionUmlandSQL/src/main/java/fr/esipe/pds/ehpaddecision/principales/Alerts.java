package fr.esipe.pds.ehpaddecision.principales;
import java.sql.Timestamp;
public class Alerts {
		private int idAlert;
		private String nameAlert;
		
		private Timestamp creationDate;
		
		public Alerts(String nameAlert, String string) {
			super();
			
		}
		public Alerts() {
			super();
		}
		public Alerts(int idAlert, String nameAlert, Timestamp creationDate) {
			this.idAlert = idAlert;
			this.nameAlert = nameAlert;
			this.creationDate = creationDate;
		}
		public Alerts(String nameAlert2) {
			// TODO Auto-generated constructor stub
			this.nameAlert=nameAlert2;
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
