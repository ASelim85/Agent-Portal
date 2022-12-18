package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KYCDocumentPage extends PageBase {

    public By submitBtn = By.xpath("//button[@type='button' and span='SUBMIT']");
    public By kYCDocsTitle = By.xpath("//span[@class='ant-typography _header-title_1vd6y_36' and text()='KYC Document']");
    public By personalInfoTxt = By.xpath("//h1[@class='ant-typography _card-header_1xwec_13' and text()='Personal Information']");
    public By jobInfoTxt = By.xpath("//h1[@class='ant-typography _card-header_187l1_10' and text()='Job Information']");
    public By addressInfoTxt = By.xpath("//h1[@class='ant-typography _card-header_1spyb_9' and text()='Address Information']");
    public By additionalInfoTxt = By.xpath("//h1[@class='ant-typography _card-header_1k4t7_12' and text()='Additional Information']");
    public By CreateKYCTxt = By.xpath("//h1[@class='ant-typography' and text()='Create KYC']");

    public By govListInput = By.xpath("//div[@class='ant-select-item-option-content' and text()='Cairo']");
    public By jobInformationTxt = By.xpath("//span[@class='ant-typography _formTitle_1ep99_1' and text()='Job Information']");
    public By KYCDocumentTitle = By.xpath("//span[@class='ant-typography _header-title_1vd6y_36' and text()='KYC Document']");
    public By partnerInput2 = By.id("partnerId");
    //    String dataId = "data-axis-test-id";
    String dataId = "//*[@data-axis-test-id=";
    public By linkKYCManagement = By.xpath(dataId + "'kyc-management']");
    public By linkMyKYCDocs = By.xpath(dataId + "'my-kyc-documents']");
    public By btnAddNewKYCDoc = By.xpath(dataId + "'create-kyc-link']");
    public By inputPhoneNumber = By.xpath(dataId + "'phone-number-input']");
    public By btnSubmit = By.xpath(dataId + "'submit-button']");
    public By refNumInput = By.xpath(dataId + "'reference-number-input']");
    public By mobNumInput = By.xpath(dataId + "'mobile-number-input']");
    public By nationalIDInput = By.xpath(dataId + "'national-id-input']");
    public By nationalIDExpDateInput = By.xpath(dataId + "'national-id-expiry-date-input']");
    public By firstNameInput = By.xpath(dataId + "'first-name-input']");
    public By lastNameInput = By.xpath(dataId + "'last-name-input']");
    public By birthDateInput = By.xpath(dataId + "'birth-date-input']");
    public By martialStatusInput = By.xpath(dataId + "'marital-status-input']");
    public By maritalStatusSINGLE = By.xpath(dataId + "'MaritalStatus_SINGLE']");
    public By emailInput = By.xpath(dataId + "'email-input']");
    public By genderInput = By.xpath(dataId + "'gender-input']");
    public By governorateInput = By.xpath(dataId + "'governorate-input']");
    public By cityInput = By.xpath(dataId + "'city-input']");
    public By cityListInput = By.xpath(dataId + "'City_MAADI']");
    public By addressInput = By.xpath(dataId + "'address-input']");
    public By professionInput = By.xpath(dataId + "'profession-input']");
    public By professionListInput = By.xpath(dataId + "'Profession_ENGINEER']");
    public By jobTitleInput = By.xpath(dataId + "'job-title-input']");
    public By workEntityNameInput = By.xpath(dataId + "'work-entity-name-input']");
    public By workEntityAddressInput = By.xpath(dataId + "'work-entity-address-input']");
    public By sourceOfIncomeInput = By.xpath(dataId + "'source-of-income-input']");
    public By monthlyIncomeInput = By.xpath(dataId + "'monthly-income-input']");
    public By partnerInput = By.xpath(dataId + "'partner-input']");
    public By partnerListInput = By.xpath(dataId + "'OPay']");
    public By transactionNatureInput = By.xpath(dataId + "'transaction-nature-input']");
    public By trxNatureList = By.xpath(dataId + "'TransactionNature_LOAN_PAYMENT']");
    public By walletRegObjInput = By.xpath(dataId + "'wallet-registration-objective-input']");
    public By WalletRegObjList = By.xpath(dataId + "'WalletRegObjective_LOAN_PAYMENT']");
    public By haveDipJobYesBtn = By.xpath(dataId + "'have-diplomatic-job-yes']");
    public By dipJobDesInput = By.xpath(dataId + "'diplomatic-job-description-input']");
    public By relativeDiplomaticJobYesBtn = By.xpath(dataId + "'relative-has-diplomatic-job-yes']");
    public By relativeDipJobDesInput = By.xpath(dataId + "'relative-diplomatic-job-description-input']");
    public By createBtn = By.xpath(dataId + "'create-button']");
    public By cancelBtn = By.xpath(dataId + "'cancel-button']");

    Faker faker = new Faker();

    public KYCDocumentPage(WebDriver driver) {
        super(driver);
    }

    public void clickKYCManagementLink() {
        click(linkKYCManagement);
    }

    public void clickMyKYCDocsLink() {
        click(linkMyKYCDocs);
    }

    public String getKYCDocsTitle() {
        return getContent(kYCDocsTitle);
    }

    public String getPersonalInfoTitle() {
        return getContent(personalInfoTxt);
    }

    public String getJobInfoTitle() {
        return getContent(jobInfoTxt);
    }

    public String getAddressInfoTxt() {
       return getContent(addressInfoTxt);
    }

    public String getAdditionalInfoTxt() {
        return getContent(additionalInfoTxt);
    }

    public void clickSubmit() {
        click(btnSubmit);
    }

    public String getCreateKYCTitle() {
        String getCreateKYCTxt = getContent(CreateKYCTxt);
        return getCreateKYCTxt;
    }

    public void setRefNum() {
        setText(refNumInput, faker.number().digits(6));
    }

    public String getMobNum() {
        String MobNum = getContent(mobNumInput);
        return MobNum;
    }

    public void setNID() {
        setText(nationalIDInput, "30607180102211");
    }

    public void setNIDExpDate() {
        click(nationalIDExpDateInput);
        setText(nationalIDExpDateInput, "30/12/2022");
    }

    public void setFName() {
        setText(firstNameInput, "أحمد");
    }

    public void setLName() {
        setText(lastNameInput, "سليم");
    }

    public void clickMartialStatus() {
        click(martialStatusInput);
        click(maritalStatusSINGLE);
    }

    public void setEmail() {
        setText(emailInput, "aselim@axisapp.com");
    }

//    public String getAddInfoTitle() {
//        return getContent(addressInformationTxt);
//    }

    public void setGovernorate() {
        click(governorateInput);
        click(govListInput);
    }

    public void setCity() {
        click(cityInput);
        click(cityListInput);
    }

    public void setAddress() {
        setText(addressInput, "test address");
    }

    public void setProfession() {
        click(professionInput);
        click(professionListInput);
    }

    public void setTitle() {
        setText(jobTitleInput, "QC");
    }

    public void setWorkEntName() {
        setText(workEntityNameInput, "Testing");
    }

    public void setWorkAddress() {
        setText(workEntityAddressInput, "Axis");
    }

    public void setSourceOfIncome() {
        setText(sourceOfIncomeInput, "Working in Axis");
    }

    public void setMonthlyIncome() {
        setText(monthlyIncomeInput, "5000");
    }

    public String getAddInfTitle() {
        return getContent(additionalInfoTxt);
    }

    public void setPartner() {
        click(partnerInput);
        setText(partnerInput2, "OPay");
        click(partnerListInput);
    }

    public void setTrxNature() {
        click(transactionNatureInput);
        click(trxNatureList);
    }

    public void setwalletRegObjective() {
        click(walletRegObjInput);
        click(WalletRegObjList);
    }

    public void clickCreate() {
        click(createBtn);
    }

    public String getKYCDocumentTitle() {
        return getContent(KYCDocumentTitle);
    }
}

