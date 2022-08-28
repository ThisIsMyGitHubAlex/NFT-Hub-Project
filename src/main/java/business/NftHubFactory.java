package business;

import business.fileImplementation.FileNftHubBusinessFactory;

public abstract class NftHubFactory {

    private static NftHubFactory factory = new FileNftHubBusinessFactory();

    public static NftHubFactory getInstance(){
        return factory;
    }

    public abstract UserService getUserService();
}
