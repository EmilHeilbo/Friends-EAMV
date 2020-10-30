package logic;

import java.util.List;

public interface Friends {
   public boolean create(Friend friend);

   public boolean update(Friend friend);

   public boolean delete(Friend friend);

   public Friend read(int key);

   public List<Friend> search(String str);

   public void setURI(String uri);

   public void setSaveStrategy(SaveStrategy format);
}