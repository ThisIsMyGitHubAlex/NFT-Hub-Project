package domain;

public class User {
    private String username, password, role;
    private NFT[] NFTList;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public NFT[] getNFTList() {
        return NFTList;
    }

    public void setNFTList(NFT[] NFTList) {
        this.NFTList = NFTList;
    }
}
