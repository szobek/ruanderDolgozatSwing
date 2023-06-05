package szalon;

public enum OraTipusok {
//karóra; falióra; ébresztõóra; stopperóra 
	
	KARORA("karóra"),FALIORA("falióra"),EBRESZTOORA("ébresztõóra"), STOPPERORA("stopperóra");
	
	private String type;
	
	private OraTipusok(String type) {
		this.type=type;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public static OraTipusok convertToEnum(String tipus) {
		for(OraTipusok elem: OraTipusok.values()) {
			if(elem.type.equals(tipus)) {
				return elem;
			}
		}
		return null;
	}
}
