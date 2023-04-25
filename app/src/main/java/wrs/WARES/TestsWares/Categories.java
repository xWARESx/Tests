package wrs.WARES.TestsWares;

import com.WARES.tests.R;

public class Categories {
    private String name;
    private int imageId;

    public Categories(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public static final Categories[] cats = {
            new Categories(MainActivity.psycho, R.drawable.psycho),
            new Categories(MainActivity.brain, R.drawable.brain),
            new Categories(MainActivity.pciho, R.drawable.pciho),
            new Categories(MainActivity.explanation, R.drawable.explanation),
            new Categories(MainActivity.explanationBuy, R.drawable.blocked),
    };

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
