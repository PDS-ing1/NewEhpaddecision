package fr.esipe.pds.ehpaddecision.enumerations;

public enum SensorType {
	Temperature(0),
	Smoke(1);
	
	private int value;

	private SensorType(int sensorValue) {
		this.value = sensorValue;
	}
	
	public static SensorType valueFrom(int v) {
		for(SensorType s : SensorType.values()) {
			if(s.value == v){
				return s;
			}
		}
		throw new IllegalArgumentException("unknow value: " + v);
	}

}
