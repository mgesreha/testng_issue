package platform.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import platform.sections.homepage.KpiFilter;
import platform.sections.homepage.KpiWidgets;

import java.util.List;

public class HomePage {
    private final Page page;
    private List<Locator> kpiLoading;
    private Locator kpiFilterButton;

    public HomePage(Page page) {
        this.page = page;
        kpiLoading = page.getByTestId("spinner").all();
        kpiFilterButton = page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText("KPIs"));
    }

    @Step("Wait KPI Loading")
    public HomePage waitKPILoading(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        kpiLoading.forEach(locator-> locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(10000)));
        return this;
    }

    @Step("Open KPI Filter")
    public KpiFilter openKpiFilter(){
        kpiFilterButton.click();
        return new KpiFilter(page);
    }

    @Step("Access KPI Widgets")
    public KpiWidgets getKpiWidgets(){
        return new KpiWidgets(page);
    }
}
