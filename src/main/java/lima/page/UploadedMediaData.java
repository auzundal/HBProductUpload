package lima.page;

import lombok.Data;

@Data
public class UploadedMediaData {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String name;

    private String message;

}
