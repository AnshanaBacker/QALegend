package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataUtilityClass;

public class AddUserClass {

	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();

	public AddUserClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "surname")
	WebElement prefix;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath = "//select[@id='role']")
	WebElement dropDown;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirmPassword;

	@FindBy(id = "submit_user_button")
	WebElement saveButton;

	@FindBy(xpath = "//table[@id='users_table']//tr")
	List<WebElement> row;

	@FindBy(xpath = "//table[@id='users_table']//th")
	List<WebElement> column;

	@FindBy(xpath = "//span[contains(text(),'admin KL')]")
	WebElement adminKL;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	WebElement signOut;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement adminName;

	public void enterPrefix(String text) {
		gl.toTypeElement(prefix, text);

	}

	public String getPrefix() {
		return RandomDataUtilityClass.getPrefix();
	}

	public void enterFirstName(String name) {
		gl.toTypeElement(firstName, name);
	}

	public String getFirstName() {
		return RandomDataUtilityClass.getfName();
	}

	public void enterLastName(String name1) {
		gl.toTypeElement(lastName, name1);
	}

	public String getLastName() {
		return RandomDataUtilityClass.getlName();
	}

	public void enterEmail(String mail) {
		gl.toTypeElement(email, mail);
	}

	public String getEmail() {
		return RandomDataUtilityClass.getRandomEmail();
	}

	public void selectRole(int num) {
		gl.toSelectElementUsingIndex(dropDown, num);
	}

	public void enterUsername(String usern) {
		gl.toTypeElement(username, usern);
	}

	public String getUName() {
		return RandomDataUtilityClass.getUsername();
	}

	public void enterPassword(String passwd) {
		gl.toTypeElement(password, passwd);
	}

	public String getPasswd() {
		return RandomDataUtilityClass.getPassword();
	}

	public void enterConfirmPassword(String cnfmpasswd) {
		gl.toTypeElement(confirmPassword, cnfmpasswd);
	}

	public void clickSave() {
		gl.toClickElement(saveButton);
	}
	
	

	public Boolean isUseremailIDDisplayed(String email) {
		int rowCount = row.size();
		int colCount = column.size();
		System.out.println(rowCount + "  " + colCount);

		boolean flag = false;

		for (int row = 1; row < rowCount; row++) {
			for (int col = 1; col < colCount; col++) {

				String actValue = driver
						.findElement(By.xpath("//table[@id='users_table']//tr[" + row + "]//td[" + col + "]"))
						.getText();
				if (actValue.equalsIgnoreCase(email)) {

					flag = true;
					System.out.println(row + " : " + col);
					break;

				}
			}
		}
		if (flag) {
			return true;
		}
		return flag;

	}

	public String getTextOfEmail() {
		return gl.getTextOfElement(email);
	}

	public void clickOnAdminKL() {
		gl.toClickElement(adminKL);
	}

	public void clickOnSignout() {
		gl.toClickElement(signOut);
	}
    public String getTextOdAdmin()
    {
    	return gl.getTextOfElement(adminName);
    }
	
}
