package szalon;

public enum OraTipusok {
//kar�ra; fali�ra; �breszt��ra; stopper�ra 
	
	KARORA("kar�ra"),FALIORA("fali�ra"),EBRESZTOORA("l�breszt��ra"), STOPPERORA("stopper�ra");
	
	private String type;
	
	private OraTipusok(String type) {
		this.type=type;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type;
	}
}
