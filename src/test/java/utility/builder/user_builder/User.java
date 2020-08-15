package utility.builder.user_builder;

interface IFirstName {
    ILastName setFirstName(String firstname);
}

interface ILastName {
    IUserName setLastName(String lastname);
}

interface IUserName {
    IUserPassword setUserName(String email);
}

interface IUserPassword {
    IZipCode setUserPassword(String telephone);
}

interface IZipCode {
    IUserBuild setZipCode(String address1);
}

interface IUserBuild {
    IUser build();
}

public class User implements IFirstName, ILastName, IUserName,
        IUserPassword, IZipCode, IUserBuild, IUser {

    private String firstName;
    private String lastName;
    private String userName;
    private String userPassword;
    private String userZip;


    private User() {
    }

    public static IFirstName get() {
        return new User();
    }

    public ILastName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public IUserName setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public IUserPassword setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public IZipCode setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public IUserBuild setZipCode(String userZip) {
        this.userZip = userZip;
        return this;
    }

    public IUser build() {
        return this;
    }

    // getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserZip() {
        return userZip;
    }


}