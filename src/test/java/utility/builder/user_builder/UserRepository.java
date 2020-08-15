package utility.builder.user_builder;

public final class UserRepository {
    private static volatile UserRepository instance = null;

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser standardUser() {
        return User.get()
                .setFirstName("Standard")
                .setLastName("User")
                .setUserName("standard_user")
                .setUserPassword("secret_sauce")
                .setZipCode("12345")
                .build();
    }

    public IUser lockedOutUser() {
        return User.get()
                .setFirstName("Locked Out")
                .setLastName("User")
                .setUserName("locked_out_user")
                .setUserPassword("secret_sauce")
                .setZipCode("56789")
                .build();
    }

    public IUser problemUser() {
        return User.get()
                .setFirstName("Problem")
                .setLastName("User")
                .setUserName("problem_user")
                .setUserPassword("secret_sauce")
                .setZipCode("15975")
                .build();
    }

    public IUser performanceGlitchUser() {
        return User.get()
                .setFirstName("Performance Glitch")
                .setLastName("User")
                .setUserName("performance_glitch_user")
                .setUserPassword("secret_sauce")
                .setZipCode("95135")
                .build();
    }

    public IUser invalidUsernameUser() {
        return User.get()
                .setFirstName("Invalid Username")
                .setLastName("User")
                .setUserName("invalid_user")
                .setUserPassword("secret_sauce")
                .setZipCode("95135")
                .build();
    }

    public IUser invalidPasswordUser() {
        return User.get()
                .setFirstName("Invalid Password")
                .setLastName("User")
                .setUserName("standard_user")
                .setUserPassword("invalid_password")
                .setZipCode("95135")
                .build();
    }

    public IUser invalidUser() {
        return User.get()
                .setFirstName("Invalid")
                .setLastName("User")
                .setUserName("invalid_username")
                .setUserPassword("invalid_password")
                .setZipCode("95135")
                .build();
    }
}
