package driver;

public enum WebDriverTypes {
	FIREFOX("firefox"), 
	IE("internet explorer"), 
	CHROME("chrome"), 
	OPERA("opera"), 
	SAFARI("safari"),
	HTMLUNIT("htmlunit"),
	PHANTOM("phantom");

	private String driverName;

	private WebDriverTypes(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}
}
