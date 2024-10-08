package Payloads.Response;

public class AuthResponse {
    AuthResponse(){

    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

}
