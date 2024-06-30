package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.example.pages.AdminPage;


public class AdminOperationAddUser {


     AdminPage Adminpage=new AdminPage();
    public Integer recordsBeforeAdd;


    @Given("I navigate to admin tab")
    public void iNavigateToAdminTab() throws InterruptedException {
        Adminpage.clickAdminTab();
    }


    @When("Display the number of records found")
    public void DisplayTheNumberOfRecordsFound() throws InterruptedException {
        Adminpage.waitTotalRecords();
        String recordsFoundInString = Adminpage.getTotalRecordsAsString();
        recordsBeforeAdd = Adminpage.getTotalRecordsAsInteger(recordsFoundInString);
    }

    @And("I click on add button")
    public void iClickOnAddButton() {
        Adminpage.ClickAddButton();
    }

    @And("I Fill the required fields {} , {}, {} , {}, {}, {}")
    public void iFillTheRequiredFields(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {
        Adminpage.waitForAddUserTitleToAppear();
        Adminpage.selectFromUserRoleDropDown(arg0);
        Adminpage.selectFromStatusDropDown(arg1);
        Adminpage.InsertPasswordTxtBox(arg2);
        Adminpage.InsertEmployeeName(arg3);
        Adminpage.InsertUsername(arg4);
        Adminpage.InsertConfirmPassword(arg5);
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        Adminpage.ClickSaveBtn();
    }

    @Then("Validate Total Records Increased by {int}")
    public void validateTotalRecordsIncreasedBy(int Value) throws InterruptedException {

        String recordsFoundInString = Adminpage.getTotalRecordsAsString();
        Integer ActualRecordsAfterAddition = Adminpage.getTotalRecordsAsInteger(recordsFoundInString);
        Integer ExpectedResultAfterAdd = recordsBeforeAdd + Value;
        Assert.assertEquals(ActualRecordsAfterAddition, ExpectedResultAfterAdd);
    }


}
