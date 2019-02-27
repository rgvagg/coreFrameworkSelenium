package coreFramework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {

	public void main(String[] args) {
		// TODO Auto-generated method stub

		Logger logs ;
		PropertyConfigurator.configure("\\src\\main\\resources\\log4j.properties");
		logs = Logger.getLogger(this.getClass().getSimpleName().toString());
		

	}

}
