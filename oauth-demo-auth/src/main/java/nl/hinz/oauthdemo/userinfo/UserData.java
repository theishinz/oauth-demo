package nl.hinz.oauthdemo.userinfo;

public class UserData {
    private String sub;

    public UserData(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
