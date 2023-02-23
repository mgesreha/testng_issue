package platform.sections.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class KpiWidgets {
    private final Page page;
    private List<Locator> clinicalKPIWidgets;
    private List<Locator> operationalKPIWidgets;


    public KpiWidgets(Page page) {
        this.page = page;
        clinicalKPIWidgets = page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Clinical")).locator("../..").
                getByTestId("analyzeLink").
                getByRole(AriaRole.HEADING, new Locator.GetByRoleOptions().setLevel(6)).all();

        operationalKPIWidgets = page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Operational")).locator("../..").
                getByTestId("analyzeLink").
                getByRole(AriaRole.HEADING, new Locator.GetByRoleOptions().setLevel(6)).all();
    }

    @Step(value = "Assert all Clinical KPI widgets are visible")
    public KpiWidgets assertClinicalKPIWidgetsAreVisible(){
        clinicalKPIWidgets.stream().forEach(locator -> assertThat(locator).isVisible());
        return this;
    }

    @Step("Retrieve Clinical KPI's Headers List")
    public List<String> getClinicalKPIsHeadersList(){
       return clinicalKPIWidgets.stream().map(locator -> locator.innerText()).collect(Collectors.toList());
    }

    @Step(value = "Assert all Operational KPI widgets are visible")
    public KpiWidgets assertOperationalKPIWidgetsAreVisible(){
        operationalKPIWidgets.stream().forEach(locator -> assertThat(locator).isVisible());
        return this;
    }

    @Step("Retrieve Operational KPI's Headers List")
    public List<String> getOperationalKPIsHeadersList(){
        return operationalKPIWidgets.stream().map(locator -> locator.innerText()).collect(Collectors.toList());
    }


}
