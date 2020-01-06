package lima.steps;


import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lima.page.GalleryPage;
import lima.util.DriverUtil;
import lima.util.FileUtil;
import org.junit.Assert;

import java.util.List;

public class GalleryStep {
    private GalleryPage galleryPage;

    @Before
    public void GalleryStep() {
        galleryPage = DriverUtil.createClass(GalleryPage.class);
    }

    @Then("^Merchant go to gallery page$")
    public void navigateToGallery() {
        galleryPage.navigateToGallery();
    }


    @Given("^Merchant should see gallery page is opened$")
    public void merchantShouldSeeGalleryPageIsOpened() throws Throwable {
        Assert.assertTrue("Gallery page cannot be opened", galleryPage.checkGalleryIsOpened());
    }

    @Then("^I see there is no image in gallery page$")
    public void iSeeThereIsNoImageInGalleryPage() throws Throwable {

        Assert.assertTrue("No image page cannot be opened", galleryPage.checkEmptyGalleryPage());
    }


    @Given("^Merchant click upload image button in gallery page$")
    public void merchantClickUploadImageButtonInGalleryPage() throws Throwable {
        galleryPage.clickUploadImageButton();
    }


    @When("^Merchant click upload with URL tab$")
    public void merchantClickUploadWithURLTab() throws Throwable {
        galleryPage.clickUploadWithUrlTab();
    }

    @When("^Merchant upload \"([^\"]*)\" URL from Image Upload Page$")
    public void merchantUploadURLFromImageUploadPage(String UrlAdress) throws Throwable {
        galleryPage.uploadImageWithUrl(UrlAdress);
    }

    @Given("^Merchant search \"([^\"]*)\" in search field in gallery page$")
    public void merchantSearchInSearchFieldInGalleryPage(String imageName) throws Throwable {
        galleryPage.searchImageInGalleryPage(imageName);
    }

    @Then("^Merchant should see only see images that has \"([^\"]*)\" word contained in image name$")
    public void merchantShouldSeeOnlySeeImagesThatHasWordContainedInImageName(String searchResultImageName) throws Throwable {
        galleryPage.searchImageResultInGalleryPage();
    }

    @And("^Merchant select image for delete$")
    public void merchantSelectImageForDelete() throws Throwable {
        galleryPage.selectImageCard();
    }

    @And("^Click delete button$")
    public void clickDeleteButton() throws Throwable {
        galleryPage.deleteImageButtonClick();
    }


    @Then("^These images are available in Image Upload Page$")
    public void theseImagesAreAvailableInImageUploadPage() throws Throwable {
        List<String> fileNames = FileUtil.getValidImageNames();
        for (int i = 0; i < fileNames.size(); i++) {
            String imageName = galleryPage.getImageName(i);
            String successMsg = galleryPage.getSuccessMsg(i);
            Assert.assertEquals("Yükleme başarılı!", successMsg);
            Assert.assertEquals(fileNames.get(i), imageName);
        }
    }

    @When("^Merchant upload files in Image Upload Page:$")
    public void merchantUploadFilesInImageUploadPage(List<String> images) throws Throwable {
        galleryPage.uploadImageFile(images);

    }
}
