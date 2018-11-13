import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.jar.Attributes;

@Entity(tableName = "UserLogin")
public class UserLogin {

    @PrimaryKey
    @ColumnInfo(name = "UserName")
    private String userName;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Password")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
