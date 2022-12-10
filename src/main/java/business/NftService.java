package business;

import domain.NFT;

import java.io.FileNotFoundException;
import java.util.List;

public interface NftService {

     int getImageCounter() throws BusinessException;
     List<NFT> getNftList() throws BusinessException;

}
