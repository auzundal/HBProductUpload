package lima.constants;

import org.openqa.selenium.By;

public interface Constants {
    interface GalleryPage {
        String imageGalleryURL = ("http://192.168.55.112:30011/v2/gallery");
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
        By merchantTooltip = By.cssSelector("[data-for='toolTip-merchant']");
    }

    interface LoginPage {
        String rootMainPageloginURL = ("http://192.168.55.112:30011/login");
        By usernameTextbox = By.id("loginPage-input-username");
        By passwordTextbox = By.id("loginPage-input-password");
        By loginButton = By.id("loginPage-button-login");
        By loginPageErrorMessageToast = By.cssSelector(".toast.toast-error");
    }
}
