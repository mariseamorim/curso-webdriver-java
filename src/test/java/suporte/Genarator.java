package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Genarator {
	public static String dateHourForFile() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
	return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
	}
}
