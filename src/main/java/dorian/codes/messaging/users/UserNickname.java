package dorian.codes.messaging.users;

public class UserNickname {
    private String nickname;

    public UserNickname(){

    }

    public UserNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
