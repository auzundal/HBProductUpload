package lima.page;

import lima.base.BasePage;
import lima.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GalleryPage extends BasePage {


    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGallery() {
        getDriver().get("http://192.168.55.112:30011/v2/gallery");
    }


    public boolean checkGalleryIsOpened() {
        waitUntilVisibleByLocator(By.id("galleryView-div-showTitle"));
        return isElementExists(By.id("galleryView-div-showTitle"));
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

        List<String> imageNames = FileUtil.getValidImageNames();

        for (int i = 0; i < imageNames.size(); i++) {
            WebElement fileInput = getDriver().findElement(By.id("fileUploadModal-dragAndDrop-imageUpload"));
//            WebElement fileInput = getDriver().findElement(By.xpath("/html/body/div/div[2]/div/div/div[6]/div/div/div[4]/label/div/input"));
            fileInput.sendKeys(FileUtil.IMAGE_UPLOAD_FOLDER + "/" + imageNames.get(i) + "/" + "\n");
            //.sendKeys("C:/Users/eanyig/Desktop/Lima/data/sample/imageUpload/emir.jpg \n C:/Users/eanyig/Desktop/Lima/data/sample/imageUpload/Single.jpg");
        }

    }

    public void clickUploadWithUrlTab() {
        clickAfterWaitForElement(By.id("fileUploadModal-tab-fromLink"));
    }

    public void uploadImageWithUrl(String UrlAdress) {
        clickAndWrite(By.cssSelector("[data_id='styles_inputContainer_']"), UrlAdress);
        click(By.id("linkFileUpload-button-uploadWithLink"));
    }

    public void searchImageInGalleryPage(String ImageName) {
        waitUntilVisibleByLocator(By.id("galleryView-input-searchImage"));
        clickAndWrite(By.id("galleryView-input-searchImage"), ImageName);

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
}

