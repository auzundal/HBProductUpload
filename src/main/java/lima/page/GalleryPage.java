package lima.page;

import lima.base.BasePage;
import lima.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GalleryPage extends BasePage {


    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGallery() {
        getDriver().get("http://192.168.55.112:30011/v2/gallery");
    }


    public String getTitle() {
        return getText(By.id("galleryView-div-showTitle"));

    }

    public boolean checkEmptyGalleryPage() {
        waitUntilVisibleByLocator(By.id("galleryView-button-searchNoImageUpload"));
        return isElementExists(By.id("galleryView-button-searchNoImageUpload"));
    }

    public void clickUploadImageButton() {
        clickAfterWaitForElement(By.id("galleryView-button-uploadImage"));
    }

    public void clickUploadImageWithGalleryImage() {
        click(By.id("galleryView-button-uploadImage"));
    }

    public void clickUploadImageWithoutGalleryImage() {
        click(By.id("galleryView-button-searchNoImageUpload"));
    }

    public void uploadImageFile(List<String> images) {
        List<String> pathImages = new ArrayList<>();
        for (String image : images) {
            pathImages.add(FileUtil.IMAGE_UPLOAD_FOLDER + "/" + image);

        }
        String imageList = String.join(" \n ", pathImages);
        WebElement fileInput = getDriver().findElement(By.id("fileUploadModal-dragAndDrop-imageUpload"));
        fileInput.sendKeys(imageList);
    }

    public void clickUploadWithUrlTab() {
        clickAfterWaitForElement(By.id("fileUploadModal-tab-fromLink"));
    }

    public void uploadImageWithUrl(String urlAdress) {
        clickAndWrite(By.id("linkFileUpload-input-linkImage"), urlAdress);
        click(By.id("linkFileUpload-button-uploadWithLink"));
    }

    public void searchImageInGalleryPage(List<String> imageList) {

        for (String image : imageList) {

            waitUntilVisibleByLocator(By.id("galleryView-input-searchImage"));
            clickAndWrite(By.id("galleryView-input-searchImage"), image);
            getDriver().findElement(By.id("galleryView-input-searchImage")).clear();
        }
    }

    public void selectImageCard(List<String> imageList) {

        for (String imageName : imageList) {
            click(By.cssSelector("div[title='" + imageName + "'] > div > span"));
        }
    }

    public void deleteImageTrashButtonClick(List<String> imageList) {

        for (String imageName : imageList) {
            WebElement imageCard = hover(By.cssSelector("div[title='" + imageName + "']"));
            imageCard.findElement(By.id("imageCard-button-removeImage")).click();
            click(By.xpath("//*[@id='product-app']/div/div[2]/div/div[2]/button[2]"));
        }
    }

    public List<UploadedMediaData> getUploadedImageResults() {
        List<UploadedMediaData> uploadedMediaDataList = new ArrayList<>();
        List<WebElement> elements = getDriver().findElements(By.cssSelector("#fileUploadModal-div-tabsParent > div > ul > li"));

        for (WebElement imageElement : elements) {
            UploadedMediaData uploadedMediaData = new UploadedMediaData();
            uploadedMediaData.setName(imageElement.findElement(By.cssSelector("div > span > span")).getText());
            uploadedMediaData.setMessage(imageElement.findElement(By.cssSelector("div > span:nth-child(2)")).getText());
            uploadedMediaDataList.add(uploadedMediaData);
        }
        return uploadedMediaDataList;
    }

    public String invalidImageFormatErrorMessage() {
        WebElement errorToastNotification = waitUntilVisibleByLocator(By.cssSelector("#product-app > div > div.notification__notification___3eGwx.notification__success___1YQYR > span > span:nth-child(1)"));
        return errorToastNotification.getText();
    }

    public String invalidUrlErrorMessaage() {
        WebElement errorPageTitle = waitUntilVisibleByLocator(By.id("errorPage-span-title"));
        return errorPageTitle.getText();
    }


}

