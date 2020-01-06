#@Gallery feature
Feature: This feature contains gallery page's and its components' teste

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "TEST-AHMET" username, "Test123!" password
    When Merchant should see "TEST-AHMET" username as on Home Page
    Then Merchant go to gallery page

  Scenario: Gallery page opening
    Given Merchant should see gallery page is opened
    Then I see there is no image in gallery page


  Scenario: Gallery image upload modal
    Given Merchant should see gallery page is opened
    When Merchant click upload image button in empty gallery
    Then Merchant should see image upload modal is opened
    Then Merchant see all of the image upload modal components

  @image-upload-single-image-test1
  Scenario: Upload a single image with upload from my computer1
    Given Merchant should see gallery page is opened
    When  Merchant upload files in Image Upload Page:
      | emir.jpg   |
      | Single.jpg |
    Then These images are available in Image Upload Page


  @image-upload-single-image
  Scenario: Upload a single image with upload from my computer
    Given Merchant click upload image button in empty gallery
    When  Merchant upload "Single.jpg" file from Image Upload Page
    Then These images are available in Image Upload Page

  @image-upload-upload-multiple-image-as-zip
  Scenario: Upload multiple image as a ZIP file
    Given Merchant click upload image button in gallery page
    When Merchant upload "SampleMultipleImageUpload.zip" file from Image Upload Page
     #Then These images are available in Image Upload Page:
      #| cat1.jpg |
      #| cat2.jpg |
      #| cat3.jpg |

  @image-upload-upload-single-image-as-rar
  Scenario: Upload a single image as a RAR file
    Given Merchant click upload image button in gallery page
    When Catalog user upload "SampleSingleImageUpload.rar" file from Image Upload Page
    Then These images are available in Image Upload Page:
      | ANA SAYFA.png |


  Scenario: Upload a single image with via Drag and Drop
    Given Merchant click upload image button in gallery page
    When  Merchant upload "Single.jpg" file from Image Upload with Drag and Drop
    Then These images are available in Image Upload Page:
      | Single.jpg |


  Scenario: Upload an invalid file via upload my computer
    Given Merchant click upload image button in gallery page
    When  Merchant upload "Single.exe" file from Image Upload Page
    Then Merchant should see invalid format error message

  Scenario: Upload a single image with via Drag and Drop
    Given Merchant click upload image button in gallery page
    When  Merchant upload "Single.exe" file from Image Upload with Drag and Drop
    Then Merchant should see invalid format error message

  Scenario: Upload more than 100 image via my computer
    Given Merchant click upload image button in gallery page
    When  Merchant upload more than 100 image from my computer
    Then Merchant should see count error message

  Scenario: Upload more than 100 image via Drag and Drop
    Given Merchant click upload image button in gallery page
    When  Merchant upload more than 100 image from Drag and Drop
    Then Merchant should see count error message

  Scenario: Upload an image with URL
    Given Merchant click upload image button in gallery page
    When Merchant click upload with URL tab
    When  Merchant upload "https://iasbh.tmgrup.com.tr/ac71ff/0/0/0/0/0/0?u=http://i.sabah.com.tr/sb/galeri/yasam/en-iyi-en-guzel-kedi-fotograflari/1.jpg" URL from Image Upload Page
    Then These images are available in Image Upload Page:
      | 1.jpg |

  Scenario: Upload an image with invalid URL
    Given Merchant click upload image button in gallery page
    When Merchant click "Bağlantıdan Yükle" tab
    When  Merchant upload "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZ8A3qSbT9iiZgE-XU5yk0NNhTEWLhHKWj8OHWOh13nJB9Cj7lnA&s" file from Image Upload Page
    Then Merchant should see error component about invalid URL

  Scenario: Search an image that is in merchant's gallery
    Given Merchant search "deliesra" in search field in gallery page
    Then Merchant should see only see images that has "deliesra" word contained in image name
    Then should be same as image cards

  Scenario: Check sort strategy
    Given Merchant click sort button
    And Merchant select "Tarihi Sıraya Göre" sort strategy
    Then Merchant should see "En Son Yüklenen" text in sort field
    And Merchant click sort arrow
    Then Merchant should see "İlk Yüklenen" text in sort field
    And Merchant click sort arrow
    Then Merchant should see defauld sort button
    And Merchant click sort button
    And Merchant select "Alfabetik Sıraya Göre" sort strategy
    Then Merchant should see "İsme Göre Azalan" text in sort field
    And Merchant click sort arrow
    Then Merchant should see "İsme Göre Artan" text in sort field
    And Merchant click sort arrow
    Then Merchant should see defauld sort button

  Scenario: Check sort working
    Given Merchant click sort button
    And Merchant select "Tarihi Sıraya Göre" sort strategy
    Then first image should be "1.jpg"
    And Merchant click sort arrow
    Then first image should be "Single.jpg"
    And Merchant click sort arrow
    Then Merchant should see defauld sort button
    And Merchant select "Alfabetik Sıraya Göre" sort strategy
    Then first image should be "Single.jpg"
    And Merchant click sort arrow
    Then first image should be "1.jpg"
    And Merchant click sort arrow
    Then Merchant should see defauld sort button

  Scenario: Delete Sıngle Image
    Given Merchant search "canbab1a" in search field in gallery page
    And Merchant select image for delete
    And Click delete button
    Then Merchant search "canbab1a" in search field in gallery page


