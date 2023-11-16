package manage;

import model.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class ProviderData {
//    @DataProvider
//    public Iterator<Object[]> loginModelDto(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{User.builder().email("").password("").build()});
//        list.add(new Object[]{User.builder().email("").password("").build()});
//        list.add(new Object[]{User.builder().email("").password("").build()});
//        return list.iterator();
//    }
//}

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> loginModelDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{User.builder().email("galina@gmail.com").password("Gg123456$").build()});
        list.add(new Object[]{User.builder().email("galina@gmail.com").password("Gg123456$").build()});
        list.add(new Object[]{User.builder().email("galina@gmail.com").password("Gg123456$").build()});
        return list.iterator();
    }
}
