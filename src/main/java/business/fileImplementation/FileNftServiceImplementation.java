package business.fileImplementation;

import business.BusinessException;
import business.NftService;
import domain.NFT;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileNftServiceImplementation implements NftService {
    String NFTFilename;
    String NFTDirectory;

    public FileNftServiceImplementation(String NFTFilename, String NFTDirectory) {
        this.NFTFilename = NFTFilename;
        this.NFTDirectory = NFTDirectory;
    }

    @Override
    public int getImageCounter() throws BusinessException {

        try {
            FileData fileData = FileUtility.readAllRows(NFTFilename);
            int counter = (int) fileData.getPositionCounter();
            return counter;

        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        }
    }

    @Override
    public List<NFT> getNftListByUser(String username) throws BusinessException {

        try {
            List<NFT> nftList = new ArrayList<>();
            FileData fileData = FileUtility.readAllRows(NFTFilename);

            List<String[]> rows = fileData.getRows();
            for (String[] row : rows) {
                if (row[5].equals(username)) {
                    NFT nft = new NFT();
                    ImageView imageView = new ImageView();

                    Image image = new Image("data/NFTs/" + row[1]);
                    imageView.setImage(image);
                    nft.setImageView(imageView);
                    nft.setName(row[2]);
                    nft.setPrice(Double.valueOf(row[3]));
                /*
                if (row[4].equals("YES")) nft.setOnSaleYES();
                if (row[4].equals("NO")) nft.setOnSaleNO();*/
                    nft.setOnSale(row[4]);
                    nft.setOwnerUsername(row[5]);
                    nftList.add(nft);

                }
            }
            return nftList;


        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException();
        }

    }
}
