#@Gallery feature
Feature: This feature contains gallery page's and its components' test

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-100" username, "Test123!" password
    Then Merchant should see product process button

  @check-gallery-page-opening
  Scenario: Check gallery page opening
    When Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    Then Merchant see upload image button

  @multiple-image-upload-success-with-image
  Scenario: Upload multiple image with upload my computer
    Given Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    And Merchant open image upload modal in gallery with images
    When Merchant upload files in Image Upload Page:
      | valid_kedi.jpg |
      | araba.jpg      |
      | emir.jpg       |
    Then These images are available in Image Upload Page:
      | name           | message           |
      | valid_kedi.jpg | Yükleme başarılı! |
      | araba.jpg      | Yükleme başarılı! |
      | emir.jpg       | Yükleme başarılı! |


  @single-image-upload-with-fail-image
  Scenario: Upload a single image fail with upload my computer
    Given Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    And Merchant open image upload modal in gallery with images
    When  Merchant upload files in Image Upload Page:
      | FailResim.jpg |
    Then Merchant should see fail title

    And These images are available in Image Upload Page:
      | name          | message               |
      | FailResim.jpg | Fotoğraf yüklenemedi. |

  @image-upload-invalid-files-upload-error-message
  Scenario: Upload an invalid file via upload my computer
    Given Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    And Merchant open image upload modal in gallery with images
    When  Merchant upload files in Image Upload Page:
      | aspxDosyasi.rar |
      | ExcelVar.rar    |
    Then These files are invalid format toast error message

  @image-upload-success-with-URL
  Scenario: Upload an image success with URL
    Given Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    And Merchant open image upload modal in gallery with images
    When Merchant click upload with URL tab
    Then  Merchant upload "https://iasbh.tmgrup.com.tr/ac71ff/0/0/0/0/0/0?u=http://i.sabah.com.tr/sb/galeri/yasam/en-iyi-en-guzel-kedi-fotograflari/1.jpg" URL from Image Upload Page

  @image-upload-fail-with-URL
  Scenario: Upload an image fail with URL
    Given Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page
    And Merchant open image upload modal in gallery with images
    When Merchant click upload with URL tab
    When  Merchant upload "Invalid URL" URL from Image Upload Page
    Then Merchant should see invalid URL fail message

  @single-image-upload-success
  Scenario: Correct format single image upload

    When Merchant click product process button
    And Merchant click gallery process button
    Then Merchant should see title as "Görsel Galerisi" in Gallery Page

    When Merchant click upload image button in gallery page
    And  Merchant upload files in Image Upload Page:
      | araba.jpg |
    Then Merchant check uploaded image message as "Yükleme başarılı!"

  @single-image-upload-unsuccess
  Scenario: Incorrect format single image upload

    When Merchant click product process button
    And Merchant click gallery process button
    Then Merchant should see title as "Görsel Galerisi" in Gallery Page

    When Merchant click upload image button in gallery page
    And  Merchant upload files in Excel Upload Page:
      | record34.xlsx |
    Then Merchant check incorrect format single image upload message as "Sadece JPG veya PNG formatında resim yükleyebilirsiniz."

  @search-image-verify @sanity
  Scenario: Search Image and verify

    When Merchant click product process button
    And Merchant click gallery process button
    Then Merchant should see title as "Görsel Galerisi" in Gallery Page

    When Merchant click upload image button in gallery page
    And  Merchant upload files in Image Upload Page:
      | araba.jpg |
    And Merchant check uploaded image message as "Yükleme başarılı!"
    Then Merchant close upload image page

    When Merchant click and search image textbox as "araba.jpg"
    Then Merchant should see image name as "araba.jpg"

  @verify-delete-image-button
  Scenario: Verify Delete Image Button

    When Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page

    When Merchant click upload image button in gallery page
    And  Merchant upload files in Image Upload Page:
      | araba.jpg |
    And Merchant check uploaded image message as "Yükleme başarılı!"
    Then Merchant close upload image page

    When Merchant click and search image textbox as "araba.jpg"
    And Merchant should see image name as "araba.jpg"
    Then Merchant delete uploaded image

  @verify-delete-selected-image-button-from-gallery
  Scenario: Verify delete selected image button from gallery

    When Merchant click product process button
    And Merchant click gallery process button
    And Merchant should see title as "Görsel Galerisi" in Gallery Page

    When Merchant click upload image button in gallery page
    And  Merchant upload files in Image Upload Page:
      | araba.jpg |
    And Merchant check uploaded image message as "Yükleme başarılı!"
    Then Merchant close upload image page

    When Merchant click and search image textbox as "araba.jpg"
    And Merchant should see image name as "araba.jpg"
    Then Merchant delete selected image from gallery

  @scroll-to-parameter-element
  Scenario: Scroll to end of the page with image name
    Then Merchant go to gallery page
    Then Scroll to end of the page with "Cat-COVID-19-Mask.jpg" image name







