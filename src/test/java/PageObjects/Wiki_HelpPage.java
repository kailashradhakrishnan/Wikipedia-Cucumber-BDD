package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.Utils.Base;

public class Wiki_HelpPage extends Base {

	public static void navigateToHelpPage() {

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();

			if (!parent.equals(child_window)) {

				driver.switchTo().window(child_window);
				String title = driver.findElement(By.id("firstHeading")).getText();
				Assert.assertEquals("Help:Searching", title);
				driver.close();
			}
		}
		// switch to the parent window
		driver.switchTo().window(parent);

	}
}
