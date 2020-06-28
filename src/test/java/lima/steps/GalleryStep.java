package lima.steps;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lima.page.GalleryPage;
import lima.page.UploadedMediaData;
import lima.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.By;

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
        Thread.sleep(2000);
    }

    @Then("^Merchant should see only see images that has \"([^\"]*)\" word contained in image name$")
    public void merchantShouldSeeOnlySeeImagesThatHasWordContainedInImageName(String searchResultImageName) throws Throwable {
        galleryPage.searchImageResultInGalleryPage();
    }


    @When("^Merchant upload files in Image Upload Page:$")
    public void merchantUploadFilesInImageUploadPage(List<String> images) throws Throwable {
        galleryPage.uploadImageFile(images);

    }

    @Then("^These images are available in Image Upload Page:$")
    public void theseImagesAreAvailableInImageUploadPage(List<UploadedMediaData> uploadedMediaDataList) throws Throwable {
        List<UploadedMediaData> uploadedImageResults = galleryPage.getUploadedImageResults();
        Assert.assertThat(uploadedImageResults, is(uploadedMediaDataList));
        System.out.println(uploadedImageResults);
    }


    @And("^Merchant open image upload modal in gallery with images$")
    public void merchantOpenImageUploadModalInGalleryWithImages() throws Throwable {
        galleryPage.clickUploadImageWithGalleryImage();
    }

    @And("^Merchant open image upload modal in gallery with no images$")
    public void merchantOpenImageUploadModalInGalleryWithNoImages() throws Throwable {
        galleryPage.clickUploadImageWithoutGalleryImage();
    }

    @Then("^These files are invalid format toast error message$")
    public void theseFilesAreInvalidFormatErrorMessage() throws Throwable {
        Assert.assertThat(galleryPage.invalidImageFormatErrorMessage(), is("Bazı dosyalarınızın formatı desteklenmiyor. Desteklenen formatlar: JPG ve PNG."));

    }

    @Then("^Merchant should see invalid URL fail message$")
    public void merchantShouldSeeInvalidURLFailMessage() throws Throwable {
        Assert.assertThat(galleryPage.invalidUrlErrorMessaage(), is("1 Görsel Yüklenemedi!"));
    }


    @Then("^Merchant should see success title$")
    public void merchantShouldSeeSuccessTitle() throws Throwable {

        String uploadedMessageTitle = galleryPage.getText(By.id("successPage-span-title"));
        Assert.assertThat(uploadedMessageTitle, is("Yükleme Tamamlandı!"));
    }


    @Then("^Merchant should see fail title$")
    public void merchantShouldSeeFailTitle() throws Throwable {
        String uploadedMessageTitle = galleryPage.getText(By.id("errorPage-span-title"));
        Assert.assertThat(uploadedMessageTitle, is("Yüklenemeyen 1 görseliniz var!"));
    }


    @And("^Merchant select images:$")
    public void merchantSelectImages(List<String> images) throws Throwable {
        galleryPage.selectImageCard(images);
    }

    @And("^Merchant delete images:$")
    public void merchantDeleteImages(List<String> images) throws Throwable {
        galleryPage.deleteImageTrashButtonClick(images);
    }

    @Given("^Merchant search \"([^\"]*)\" in search field in Gallery Page$")
    public void merchantSearchImageInGalleryPage(String imageName) throws Throwable {
        galleryPage.searchImageInGalleryPage(imageName);
    }
}
