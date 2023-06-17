package salesforce;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest 
{
	
	@Test
	public static void login()
	{
		Logger log = LogManager.getLogger(LoggingTest.class);
		log.info("Browser has been launched");
		log.warn("printing warning meassages");
		log.debug("printing debug messages");
		log.error("printing error");
		log.fatal("priting fatal messages");
		log.info("completed");
	}
}
