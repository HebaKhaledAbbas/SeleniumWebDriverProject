package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.example.pages.AdminPage;

import static org.example.pages.AdminPage.TotalRecordsFound;

public class AdminOperationDeleteUser {

    AdminPage Adminpage = new AdminPage();
    Integer TotalRecordsBeforeDeletion;

    @Given("Get Total Records Before Deletion")
    public void getTotalRecordsBeforeDeletion() throws InterruptedException {
        Adminpage.waitTotalRecords();
        String recordsFoundInString = Adminpage.getTotalRecordsAsString();
        TotalRecordsBeforeDeletion = Adminpage.getTotalRecordsAsInteger(recordsFoundInString);

    }

    @When("I Search for the new user {}")
    public void iSearchForTheNewUser(String arg0) {
        Adminpage.searchForTheAddedUser(arg0);

    }

    @And("I Delete the new user")
    public void iDeleteTheNewUser() {

        Adminpage.DeleteUser();

    }

    @And("confirm to delete")
    public void confirmToDelete() {

        Adminpage.clickYesDeleteButton();

    }

    @And("wait for success message")
    public void waitSuccessMsg() {
        Adminpage.waitForSuccessMessage();
    }

    @And("I click on Reset Research")
    public void iClickOnResetResearch() {
        Adminpage.clickResetSearch();
    }

    @Then("Validate that the number of records decreased by {int}")
    public void verify_number_of_records_decreased_by_1(Integer Value) throws InterruptedException {

        WebElement totalRecords = Hooks.driver.findElement((TotalRecordsFound));
        Adminpage.waitForElementToAppear(totalRecords);
        Thread.sleep(3000);
        String recordsFoundInString = Adminpage.getTotalRecordsAsString();
        Integer ActualRecordsAfterDeletion = Adminpage.getTotalRecordsAsInteger(recordsFoundInString);
        Integer ExpectedResultAfterAdd = TotalRecordsBeforeDeletion - Value;
        Assert.assertEquals(ActualRecordsAfterDeletion, ExpectedResultAfterAdd);


    }


}
