package im.vtngsystm.dto;

public class FingerprintDTO extends SuperDTO {

    private String key;
    private String username; //in the form of "ELC***","GRN***","NIC***"

    public FingerprintDTO(String key, String username) {
        this.key = key;
        this.username = username;
    }

    public FingerprintDTO() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
