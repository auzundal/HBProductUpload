package lima.constants;

import org.openqa.selenium.By;

public interface Constants {
    interface GalleryPage {
        String imageGalleryURL = ("http://192.168.55.112:30011/v2/gallery");
        By galleryViewTitle = By.id("galleryView-div-showTitle");
        By noImageUploadButton = By.id("galleryView-button-searchNoImageUpload");
        By imageUploadButton = By.id("galleryView-button-uploadImage");
        By fileUploadButton = By.id("fileUploadModal-dragAndDrop-imageUpload");
        By fileUploadFromUrlButton = By.id("fileUploadModal-tab-fromLink");
        By fileUploadUrlTextbox = By.id("linkFileUpload-input-linkImage");
        By fileUploadButtonFromUrl = By.id("linkFileUpload-button-uploadWithLink");
        By searchImageTextbox = By.id("galleryView-input-searchImage");
        By removeImageButton = By.id("imageCard-button-removeImage");
        By errorPageSpanTitle = By.id("errorPage-span-title");
    }

    interface HomePage {
        By merchantTooltip = By.cssSelector("[data-for='toolTip-merchant']");
    }

    interface LoginPage {
        String rootMainPageloginURL = ("http://192.168.55.112:30011/login");
        By usernameTextbox = By.id("loginPage-input-username");
        By passwordTextbox = By.id("loginPage-input-password");
        By loginButton = By.id("loginPage-button-login");
        By errorMessageToast = By.cssSelector(".toast.toast-error");
    }
}
