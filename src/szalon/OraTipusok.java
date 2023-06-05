package szalon;

public enum OraTipusok {
//karóra; falióra; ébresztõóra; stopperóra 
	
	KARORA("karóra"),FALIORA("falióra"),EBRESZTOORA("lébresztõóra"), STOPPERORA("stopperóra");
	
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
