package order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class orderInputStream {
	String order = "";

	public orderInputStream(String order) {
		this.order = order;
	}

	public FileInputStream getInputStream() {
		URL fileUrl = getClass().getClassLoader().getResource(order);
		String filePath = "";
		try {
			filePath = Paths.get(fileUrl.toURI()).toString();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
