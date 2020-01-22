package lima.steps;


import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lima.page.GalleryPage;
import lima.page.UploadedMediaData;
import lima.util.DriverUtil;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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


//    @Then("^Merchant should see gallery page is opened$")
//    public void merchantShouldSeeGalleryPageIsOpened() throws Throwable {
//
////        Assert.assertTrue("Gallery page cannot be opened", galleryPage.checkGalleryIsOpened());
//    }

    @Then("^Merchant should see title as \"([^\"]*)\" in Gallery Page$")
    public void merchantShouldSeeTitleAsInGalleryPage(String title) throws Throwable {
        assertThat(galleryPage.getTitle(), is(title));
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


    @When("^Merchant upload files in Image Upload Page:$")
    public void merchantUploadFilesInImageUploadPage(List<String> images) throws Throwable {
        galleryPage.uploadImageFile(images);

    }

    @Then("^These images are available in Image Upload Page:$")
    public void theseImagesAreAvailableInImageUploadPage(List<UploadedMediaData> uploadedMediaDataList) throws Throwable {
        List<UploadedMediaData> uploadedImageResults = galleryPage.getUploadedImageResults();
        System.out.println(uploadedImageResults);
    }


}
