package lima.constants;

import org.openqa.selenium.By;

public interface Constants {

    interface Generic {
        String dateFormat = "ddMMyyyyhhmmss";
        By genericComboBoxText = By.xpath("//*[@id='elementundefined']");
    }

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
        By imageMessageLabel = By.className("uploadScreen_status_3E0A-");
        By imageNameLabel = By.className("uploadScreen_filename_3hEFr");
    }


    interface HomePage {
        By merchantTooltip = By.xpath("//div[@id='toolTip-merchant']");
        By merchantUsernameImage = By.xpath("//a[@data-for='toolTip-merchant']");
        By productProcess = By.xpath("//*[@class='bootstrap_flex-column_2Y-hE']//*[@src='/product-management.svg']");
        By galleryProcessButton = By.xpath("//*[@class='Navigation_sub-menu_339MK']//*[text()=\"Galeri\"]");
    }

    interface LoginPage {
        String rootMainPageloginURL = ("http://root-portal.preprod.hepsiburada.com");
        By usernameTextbox = By.id("loginPage-input-username");
        By passwordTextbox = By.id("loginPage-input-password");
        By loginButton = By.id("loginPage-button-login");
        By loginPageErrorMessageToast = By.cssSelector(".toast.toast-error");
    }

    interface AddSingleProduct {

        String imageUploadTempPath = System.getProperty("imagePath");
        String addProductPageLink = "/v2/products/add";
        By singleProductTabButton = By.id("fileUploadModal-tab-single");
        By singleProductModalTab = By.className("addSingleProductModal_singleProduct_2OY7D");
        By productCategoryCombobox = By.xpath("//input[@placeholder='Ürün kategorisini seçin']");
        By productCategoryComboItem = By.xpath("(//li[@data='Panduf'])[1]");
        By brandText = By.id("Marka");
        By productNameText = By.id("UrunAdi");
        By barcodeText = By.id("Barcode0");
        By merchantStockCodeText = By.id("merchantSku0");
        By colorCombobox = By.id("renk_variant_property01");
        By colorText = By.id("elementrenk_variant_property01");
        By colorComboItem = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[4]/div[1]/div/div[2]/div[3]/label[2]/div/div[2]/ul/li/div/span");
        By uploadImageFile = By.cssSelector("input[type=file]");
        By variantText = By.id("numara_variant_property00");
        By continueButton = By.id("addSingleProductModal-button-continue");
        By productFeaturePageStep = By.className("fileUploadModal_tabHeader_18V5n");
        By warrantyText = By.xpath("//div//input[@placeholder='Garanti süresini girin']");
        By taxPercentageCombobox = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[2]/div[1]/input");
        By taxPercentageComboItem = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[2]/div[2]/ul/li/div/span");
        By desiTextbox = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[3]/div/input");
        By sizeCombobox = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[5]/div[1]/input");
        By sizeComboboxItem = By.xpath("//*[@id='fileUploadModal-div-tabsParent']/div[3]/div[2]/div[5]/div[2]/ul/li/div/span");
        By descriptionButton = By.className("DescriptionTab_closable-button_2POE3");
        By descriptionText = By.xpath("//*[@id='cke_1_contents']/iframe");
        By descriptionPageStepLabel = By.className("addSingleProductModal_headerText_2-eed");
        By successfulMessageLabel = By.className("toastNotification_title_1rHVe");
        String successfulMessage = "Ürününüz onaya gönderildi";
        String addProductFailMessage = "Ürün ekleme basarisiz";
    }
}