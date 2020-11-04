package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import logic.Friend;

public class FriendOBJECT extends AbstractListData<Friend> {


    public FriendOBJECT(String uri) throws IOException {
        super(uri);
    }

    public FriendOBJECT(AbstractListData<Friend> data){
        super(data);
    }

	@Override
    public void commit() throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(uri))) {
            oos.writeObject(data);
        }
    }

    /**
     * Deserialazation can be quite insecure and exploited for arbitrary code execution if no means of safty is made.
     * The use of SaferObjectInputStream is a very basic mean of safty, and does not over all insecurities.
     * The use of some public libery will protect against wellknow vulnerabilities.
     * Encrypting the serialisation is a safe way to use serialsation safely.
     * Another option is to use "safe" liberies, which either has no known vunerabilites, or uses theroy proven methods to insure safety.
     * Gson could be used instead of serialisation.
     * @see https://greyshell.github.io/blog/2019/11/22/insecure-deserialization-java/
     */
    @SuppressWarnings("unchecked")
    @Override
    public void rollback() throws IOException {
        var file = new File(uri);
        file.createNewFile();
        data.clear();
        if(file.length()!=0)
        try (var ois = new SaferObjectInputStream(new FileInputStream(file))) {
            data = (List<Friend>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
