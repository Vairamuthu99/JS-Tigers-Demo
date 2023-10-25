package TestDrive;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseDrive.BaseClass;

public class BrokenlinksTest extends BaseClass {

	@Test
	public void BrokenLinkTest() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links = " + links.size());

		List<String> urllist = new ArrayList<String>();

		for (WebElement E1 : links) {
			String url = E1.getAttribute("href");
			urllist.add(url);
			//verifyLinks(url);
		}
		
		long stTime = System.currentTimeMillis();
		urllist.parallelStream().forEach(E1 -> verifyLinks(E1));
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken : " +(endTime-stTime));
		driver.quit();
	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL link = new URL(linkUrl);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();

			if (httpConn.getResponseCode() >= 400) {
				System.out.println(linkUrl + " -> " + httpConn.getResponseMessage() + " is broken link");
			} else {
				System.out.println(linkUrl + " -> " + httpConn.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}
}
