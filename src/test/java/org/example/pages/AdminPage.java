package org.example.pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdminPage {


    WebDriver driver;

    By AdminTab = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Admin']//parent::a[@class='oxd-main-menu-item']");
    public static By TotalRecordsFound = By.xpath("//div[@class='orangehrm-paper-container']//child::div[2]//child::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//child::span");
    By AddButton = By.xpath("//div[@class='orangehrm-header-container']//button");
    By UserRoleDropDown = By.xpath("//label[text()='User Role']/following::div[1]");
    //By UserRoleDropDown = By.xpath("//div[@class='oxd-select-text oxd-select-text--focus']");
    By UserRoleOptionInList = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//child::div[2]");
    By StatusDropDown = By.xpath("//label[text()='Status']/following::div[1]");
    By StatusOption = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@class='oxd-select-option'][2]");
    //  By PasswordTxtBox = By.xpath("//label[text()='Password']/following::div[1]");
    By PasswordTxtBox = By.xpath("//input[@class='oxd-input oxd-input--active'][@type='password']");
    // By EmployeeNameElement = By.xpath("//label[text()='Employee Name']/following::div[1]");
    By EmployeeNameElement = By.xpath("//input[@placeholder='Type for hints...']");
    By EmployeeOption = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//child::div[@class='oxd-autocomplete-option']//child::span[text()='manda akhil user']");
    // By UsernameTxtBox = By.xpath("//label[text()='Username']/following::div[1]");
    By UsernameTxtBox = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//child::div[@class='oxd-input-group oxd-input-field-bottom-space']//child::div[2]//child::input[@class='oxd-input oxd-input--active']");
    //By ConfirmPassword = By.xpath("//label[text()='Confirm Password']/following::div[1]");
    By ConfirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//child::div//child::div[2]//child::input[@type='password']");
    By SaveBtn = By.xpath("//button[text()=' Save ']");
    By SearchUserNameTxtBox = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//child::div//child::div[2]//input[@class='oxd-input oxd-input--active']");
    By SearchBtn = By.xpath("//button[@type='submit']");
    By DeleteBtn = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//child::i[@class='oxd-icon bi-trash']");
    By yesDeleteButtonLocator = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    By resetButton = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]");
    By SuccessMsg = By.id("oxd-toaster_1");


    public void clickAdminTab() throws InterruptedException {
        WebElement Admin = Hooks.driver.findElement(AdminTab);
        waitForElementToAppear(Admin);
       // Thread.sleep(5000);
        Hooks.driver.findElement((AdminTab)).click();
    }

    public void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTotalRecords() {
        WebElement totalRecords = Hooks.driver.findElement((TotalRecordsFound));
        waitForElementToAppear(totalRecords);
    }

    public String getTotalRecordsAsString() throws InterruptedException {

        Thread.sleep(5000);

        String numberOfRecords = Hooks.driver.findElement((TotalRecordsFound)).getText();
        System.out.println(numberOfRecords);
        return numberOfRecords;
    }

    public Integer getTotalRecordsAsInteger(String recordsFoundString) {
        String regEx = "\\(\\s*(\\d+)\\s*\\)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(recordsFoundString);
        if (matcher.find()) {
            Integer recordValueInt = Integer.parseInt(matcher.group(1));
            System.out.println("The number in the text is : " + recordValueInt);
            return recordValueInt;
        }
        return 0;
    }

    public void ClickAddButton() {
        Hooks.driver.findElement(AddButton).click();
    }

    public void waitForAddUserTitleToAppear() {
        String addUserTitleLocator = "//*[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]";
        waitForElementToAppear(Hooks.driver.findElement(By.xpath(addUserTitleLocator)));
    }

    public void selectFromUserRoleDropDown(String arg0) throws InterruptedException {

        Hooks.driver.findElement(UserRoleDropDown).click();
        WebElement userRoleList = Hooks.driver.findElement((UserRoleOptionInList));
        waitForElementToAppear(userRoleList);
        userRoleList.click();
    }

    public void selectFromStatusDropDown(String arg1) {
        Hooks.driver.findElement(StatusDropDown).click();
        WebElement Status = Hooks.driver.findElement(StatusOption);
        waitForElementToAppear(Status);
        Status.click();
    }

    public void InsertPasswordTxtBox(String password) throws InterruptedException {
        //Thread.sleep(3000);
        WebElement Pass = Hooks.driver.findElement(PasswordTxtBox);
        waitForElementToAppear(Pass);
        Hooks.driver.findElement(PasswordTxtBox).sendKeys(password);
    }

    public void InsertEmployeeName(String name) throws InterruptedException {
        WebElement EmployeeName = Hooks.driver.findElement(EmployeeNameElement);
        waitForElementToAppear(EmployeeName);
        EmployeeName.click();
        EmployeeName.sendKeys(name);

        WebElement Employee = Hooks.driver.findElement(EmployeeOption);
        //Thread.sleep(2000);
        waitForElementToAppear(Employee);
        Employee.click();
    }

    public void InsertUsername(String username) {
        WebElement userNameElement = Hooks.driver.findElement(UsernameTxtBox);
        userNameElement.click();
        userNameElement.sendKeys(username);
    }

    public void InsertConfirmPassword(String password) {
        WebElement confirmationPassElement = Hooks.driver.findElement(ConfirmPassword);
        confirmationPassElement.click();
        confirmationPassElement.sendKeys(password);
    }

    public void ClickSaveBtn() {
        Hooks.driver.findElement(SaveBtn).click();
    }

    public void searchForTheAddedUser(String username) {
        Hooks.driver.findElement(SearchUserNameTxtBox).sendKeys(username);
        Hooks.driver.findElement(SearchBtn).click();
    }

    public void DeleteUser() {
        Hooks.driver.findElement(DeleteBtn).click();
    }

    public void clickYesDeleteButton() {
        WebElement yesDeleteButtonElement = Hooks.driver.findElement((yesDeleteButtonLocator));
        waitForElementToAppear(yesDeleteButtonElement);
        yesDeleteButtonElement.click();

    }

    public void waitForSuccessMessage() {
        WebElement yesDeleteButtonElement = Hooks.driver.findElement(SuccessMsg);
        waitForElementToAppear(yesDeleteButtonElement);
    }

    public void clickResetSearch() {

        Hooks.driver.findElement((resetButton)).click();
    }

}
