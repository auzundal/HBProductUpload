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
        return waitUntilVisibleByLocator(By.id("galleryView-div-showTitle")).getText();
//        return isElementExists(By.id("galleryView-div-showTitle"));
    }

    public boolean checkEmptyGalleryPage() {
        waitUntilVisibleByLocator(By.id("galleryView-button-searchNoImageUpload"));
        return isElementExists(By.id("galleryView-button-searchNoImageUpload"));
    }

    public void clickUploadImageButton() {
        clickAfterWaitForElement(By.id("galleryView-button-uploadImage"));
    }

    public void uploadImageFile(List<String> images) {
        // click to open pop up
        click(By.id("galleryView-button-uploadImage"));

        List<String> pathImages = new ArrayList<>();
        for (String image : images) {
            pathImages.add(FileUtil.IMAGE_UPLOAD_FOLDER + "/" + image);
            ////      click(By.cssSelector("div[title='" + image + "']"));
        }
        String imageList = String.join(" \n ", pathImages);
        WebElement fileInput = getDriver().findElement(By.id("fileUploadModal-dragAndDrop-imageUpload"));
        fileInput.sendKeys(imageList);
    }

    public void clickUploadWithUrlTab() {
        clickAfterWaitForElement(By.id("fileUploadModal-tab-fromLink"));
    }

    public void uploadImageWithUrl(String urlAdress) {
        clickAndWrite(By.cssSelector("[data_id='styles_inputContainer_']"), urlAdress);
        click(By.id("linkFileUpload-button-uploadWithLink"));
    }

    public void searchImageInGalleryPage(String imageName) {
        waitUntilVisibleByLocator(By.id("galleryView-input-searchImage"));
        clickAndWrite(By.id("galleryView-input-searchImage"), imageName);

    }

    public void searchImageResultInGalleryPage() {
        waitUntilVisibleByLocator(By.cssSelector("imageList__cardTitle___1VBaj")).getText();
    }

    public void selectImageCard() {
        click(By.cssSelector(".imageList__cardTitle___1VBaj"));
    }

    public void deleteImageButtonClick() throws InterruptedException {
        click(By.id("imageCard-button-removeImage"));
        click(By.cssSelector(".false.modal__modalButton___27v8M.modal__secondButton___1udK8"));


    }

    public String getSuccessMsg(int idx) {
        int imageIndx = idx + 1;
        return getDriver().findElement(By.xpath("/html/body/div/div[2]/div/div/div[6]/div/div/div[4]/ul/li[" + imageIndx + "]/div[2]/span[2]")).getText();
    }

    public String getImageName(int idx) {
        int imageIndx = idx + 1;
        return getDriver().findElement(By.xpath("/html/body/div/div[2]/div/div/div[6]/div/div/div[4]/ul/li[" + imageIndx + "]/div[2]/span[1]")).getText();
    }

    public List<UploadedMediaData> getUploadedImageResults() {
        List<UploadedMediaData> uploadedMediaDataList = new ArrayList<>();
//        getDriver().findElement(By.id("ul-un idsi")).findElements(By.tagName("li"));
        waitUntilVisibleByLocator(By.cssSelector("#merchant-portal > div > div.fileUploadModal__container___17MAk > div > div > div.uploadScreen__uploadContainer___2sXxU > div > div > div > div > span.fileUploadModal__titleText___2t8LD"));
        List<WebElement> elements = getDriver().findElements(By.xpath("/html/body/div/div[2]/div/div/div[6]/div/div/div[4]/ul/li"));
        System.out.println(elements);

        for (WebElement imageElement : elements) {
            UploadedMediaData uploadedMediaData = new UploadedMediaData();
            uploadedMediaData.setName(imageElement.findElement(By.cssSelector("div > span > span")).getText());
            uploadedMediaData.setMessage(imageElement.findElement(By.cssSelector("div > span:nth-child(2)  ")).getText());
            uploadedMediaDataList.add(uploadedMediaData);

        }

        return uploadedMediaDataList;

    }
}

