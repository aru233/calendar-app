package dao;

public class UserIdGenerator {
    private static UserIdGenerator userIdGenerator = new UserIdGenerator();
    private int userId = 101;

    public static UserIdGenerator getInstance(){
        if(userIdGenerator == null){
            userIdGenerator = new UserIdGenerator();
        }
        return userIdGenerator;
    }

    public int getUserId(){
        return userId++;
    }
}
