package lima.constants;

import org.openqa.selenium.By;

public interface Constants {
    interface GalleryPage {
        String imageGalleryURL = ("http://root-portal.preprod.hepsiburada.com/v2/gallery");
        By galleryViewTitle = By.id("galleryView-div-showTitle");
        By noImageUploadButton = By.id("galleryView-button-searchNoImageUpload");
        By imageUploadButton = By.id("galleryView-button-uploadImage");
        By imageUploadModalDragAndDrop = By.id("fileUploadModal-dragAndDrop-imageUpload");
        By imageUploadFromUrlButton = By.id("fileUploadModal-tab-fromLink");
        By imageUploadUrlTextbox = By.id("linkFileUpload-input-linkImage");
        By imageUploadModalFromURLTab = By.id("linkFileUpload-button-uploadWithLink");
        By searchImageTextbox = By.id("galleryView-input-searchImage");
        By removeImageButton = By.id("imageCard-button-removeImage");
        By invalidUrlErrorPageTitle = By.id("errorPage-span-title");
    }

    interface HomePage {
        By merchantTooltip = By.xpath("//div[@id='toolTip-merchant']");
        By merchantUsernameImage = By.xpath("//a[@data-for='toolTip-merchant']");
    }

    interface LoginPage {
        String rootMainPageloginURL = ("http://root-portal.preprod.hepsiburada.com");
        By usernameTextbox = By.id("loginPage-input-username");
        By passwordTextbox = By.id("loginPage-input-password");
        By loginButton = By.id("loginPage-button-login");
        By loginPageErrorMessageToast = By.cssSelector(".toast.toast-error");
    }
}
