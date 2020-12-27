package bg.sofia.uni.fmi.piss.project.wevip.user;

public class WevipUser {

    private final Integer userId;
    private final String userName;

    public WevipUser(Integer userId,
                     String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "WevipUser{" +
                "userId=" + userId +
                ", studentName='" + userName + '\'' +
                '}';
    }
}
