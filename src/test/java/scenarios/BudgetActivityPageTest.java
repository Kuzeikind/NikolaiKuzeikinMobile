package scenarios;

import data.UserData;
import entity.User;
import org.testng.annotations.Test;
import pages.nativ.BudgetActivityPage;
import pages.nativ.LoginPage;
import setup.BaseTest;

public class BudgetActivityPageTest extends BaseTest {

    private User defaultUser = UserData.testUser;

    @Test(groups = {"native"}, description = "Verify Budget Activity page is opened upon login")
    public void testCanOpenBudgetActivityPage() {
        BudgetActivityPage budgetActivityPage = new LoginPage(getDriver())
            .openRegistrationPage()
            .registerUser(defaultUser)
            .loginAs(defaultUser);

        budgetActivityPage.shouldHaveAddExpenseBtn();
    }

}
