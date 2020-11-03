package logic;

import java.io.IOException;
import java.util.List;

public interface Friends {
   public boolean create(Friend friend);

   public boolean update(Friend friend);

   public boolean delete(Friend friend);

   public Friend read(String key);

   public List<Friend> search(String str);

   public void setURI(String uri) throws IOException;

   public void setSaveStrategy(SaveStrategy format);
}