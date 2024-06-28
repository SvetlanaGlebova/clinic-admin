package examples.lesson20062024;

import java.util.ArrayList;
import java.util.List;

public class Category extends Identity{
    private String name;
    private String description;

    //cats: [23, 67, 258, 1]
    //@JsonManagedReference //включаем в сериализацию
    private List<Cat> cats = new ArrayList<>();

    public String getName() {return name;}
}
