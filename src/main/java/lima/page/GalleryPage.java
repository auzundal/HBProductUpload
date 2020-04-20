package lima.page;

import lima.base.BasePage;
import lima.constants.Constants;
import lima.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static lima.constants.Constants.GalleryPage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryPage extends BasePage {


    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGallery() {
        getDriver().get(imageGalleryURL);
    }


    public String getTitle() {
        return getText(galleryViewTitle);

    }

    public boolean checkEmptyGalleryPage() {
        waitUntilVisibleByLocator(noImageUploadButton);
        return isElementExists(noImageUploadButton);
    }

    public void clickUploadImageButton() {
        clickAfterWaitForElement(imageUploadButton);
    }

    public void clickUploadImageWithGalleryImage() {
        click(imageUploadButton);
    }

    public void clickUploadImageWithoutGalleryImage() {
        click(noImageUploadButton);
    }


    public void uploadImageFile(List<String> images) {
        List<String> pathImages = new ArrayList<>();
        for (String image : images) {
            pathImages.add(FileUtil.IMAGE_UPLOAD_FOLDER + "/" + image);

        }
        String imageList = String.join(" \n ", pathImages);
        WebElement fileInput = getDriver().findElement(imageUploadModalDragAndDrop);
        fileInput.sendKeys(imageList);
    }

    public void clickUploadWithUrlTab() {
        clickAfterWaitForElement(imageUploadFromUrlButton);
    }

    public void uploadImageWithUrl(String urlAdress) {
        clickAndWrite(imageUploadUrlTextbox, urlAdress);
        click(imageUploadModalFromURLTab);
    }

    public List<String> searchImageInGalleryPage(String imageName) {

        List<String> imageList = Arrays.asList(imageName.split(","));

        for (String image1 : imageList) {

            waitUntilVisibleByLocator(searchImageTextbox);
            clickAndWrite(searchImageTextbox, image1);
            getDriver().findElement(searchImageTextbox).clear();
        }
        return imageList;
    }


    public void searchImageResultInGalleryPage() {
        waitUntilVisibleByLocator(By.cssSelector("div[title='Single.jpg']")).getText();
    }

    public void selectImageCard(List<String> imageList) {


        for (String imageName : imageList) {

            click(By.cssSelector("div[title='" + imageName + "'] > div > span"));
        }

    }

    public void deleteImageTrashButtonClick(List<String> imageList) {

        for (String imageName : imageList) {
            WebElement imageCard = hover(By.cssSelector("div[title='" + imageName + "']"));
            imageCard.findElement(removeImageButton).click();
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
        WebElement errorPageTitle = waitUntilVisibleByLocator(invalidUrlErrorPageTitle);
        return errorPageTitle.getText();
    }
}

