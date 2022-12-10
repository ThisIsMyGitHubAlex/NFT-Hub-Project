package domain;

import javafx.scene.image.ImageView;

public class NFT {
    // TODO setup the library table IDK how just try it
    private ImageView image;
    private String name;
    private double price;
    private String onSale;
    private String ownerUsername;

    /*private enum myEnumeration {
        YES, NO
    }*/


    public void setOnSale(String s) {
        this.onSale = s;
    }

    public String getOnSale() {
        return onSale;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    /*
    public void setOnSaleYES() {
        onSale = myEnumeration.YES.toString();
    }

    public void setOnSaleNO() {
        onSale = myEnumeration.NO.toString();
    }
    */


    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }


}
