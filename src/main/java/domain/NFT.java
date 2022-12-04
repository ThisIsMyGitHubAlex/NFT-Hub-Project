package domain;

import javafx.scene.image.ImageView;

public class NFT {
    // TODO setup the librery table IDK how jut try it
    private ImageView image;
    private String name;
    private double price;
    private User owner;
    private String onSale;

    private enum myEnumeration {
        YES, NO
    }


    private ImageView getImage() {
        return image;
    }

    private void setImage(ImageView image) {
        this.image = image;
    }


    public String getOnSale() {
        return onSale;
    }

    public void setOnSaleYES() {
        onSale = myEnumeration.YES.toString();
    }

    public void setOnSaleNO() {
        onSale = myEnumeration.NO.toString();
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    public User getOwner() {
        return this.owner;
    }

}
